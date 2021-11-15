package fr.hookwood.httponline.services;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import fr.hookwood.httponline.dao.entities.Website;
import fr.hookwood.httponline.dao.repositories.WebsiteRepository;
import fr.hookwood.httponline.model.WebsiteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WebsiteService {

    private final Cache<String, Mono<WebsiteModel>> cache;
    private final WebsiteRepository websiteRepository;
    private final SitePingerService sitePingerService;

    @Autowired
    public WebsiteService(Caffeine<Object, Object> cacheHelper, WebsiteRepository websiteRepository,
                          SitePingerService sitePingerService) {
        this.cache = cacheHelper.build();
        this.websiteRepository = websiteRepository;
        this.sitePingerService = sitePingerService;
    }

    public Flux<Website> getWebsites() {
        return websiteRepository.findAll();
    }

    public Mono<WebsiteModel> getWebsite(String name) {
        return cache.get(name, websiteName ->
                websiteRepository.findByName(websiteName).map(website -> {
                            final var websiteModel = new WebsiteModel();
                            websiteModel.setName(website.getName());
                            websiteModel.setUrl(website.getUrl());
                            sitePingerService.getStatusCode(website.getUrl()).map(websiteModel::setStatusCode);
                            return websiteModel;
                        }
                ).defaultIfEmpty(new WebsiteModel().setName("google").setUrl("https://google.fr/"))
        );
    }

    public Mono<WebsiteModel> createWebsite(String name, String url) {
        final var website = new Website().setName(name).setUrl(url);

        return cache.get(name, websiteName -> sitePingerService.getStatusCode(url).flatMap(statusCode ->
                websiteRepository.save(website).map(websiteEntity -> new WebsiteModel()
                        .setName(websiteEntity.getName())
                        .setUrl(websiteEntity.getUrl())
                        .setStatusCode(statusCode))
        ));
    }

    public void deleteWebsite(String name) {
        websiteRepository.deleteByName(name).subscribe(website -> cache.invalidate(name));
    }

    public Mono<WebsiteModel> updateWebsite(String name, String url) {
        final Mono<WebsiteModel> websiteModelMono = websiteRepository.findByName(name)
                .flatMap(website -> websiteRepository.save(website.setUrl(url)))
                .map(updatedItem -> {
                    final var websiteModel = new WebsiteModel()
                            .setName(updatedItem.getName())
                            .setUrl(updatedItem.getUrl());
                    sitePingerService.getStatusCode(websiteModel.getUrl()).subscribe(websiteModel::setStatusCode);
                    return websiteModel;
                });
        cache.put(name, websiteModelMono);

        return websiteModelMono;
    }
}