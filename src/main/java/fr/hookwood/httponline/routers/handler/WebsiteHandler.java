package fr.hookwood.httponline.routers.handler;

import fr.hookwood.httponline.helpers.DomainsName;
import fr.hookwood.httponline.model.WebsiteModel;
import fr.hookwood.httponline.services.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

@Controller
public class WebsiteHandler {

    @Autowired
    private WebsiteService websiteService;

    @NonNull
    public Mono<ServerResponse> getDomain(ServerRequest serverRequest) {
        return ServerResponse.ok().render("getDomain", Map.of(DomainsName.WEBSITE_MODEL,
                websiteService.getWebsite(serverRequest.pathVariable(DomainsName.DOMAINS_ROUTE))));
    }

    @NonNull
    @SuppressWarnings("unused")
    public Mono<ServerResponse> getDomains(ServerRequest serverRequest) {
        return ServerResponse.ok().render("allDomains", Map.of("websites", websiteService.getWebsites()));
    }

    @NonNull
    @SuppressWarnings("unused")
    public Mono<ServerResponse> createDomainGet(ServerRequest serverRequest) {
        return ServerResponse.ok().render("createDomain", Map.of(DomainsName.WEBSITE_MODEL, new WebsiteModel()));
    }

    @NonNull
    public Mono<ServerResponse> createDomainPost(ServerRequest serverRequest) {
        Mono<MultiValueMap<String, String>> formData = serverRequest.formData();

        Mono<WebsiteModel> websiteMono = formData.flatMap(website ->
                websiteService.createWebsite(website.get("name").get(0), website.getFirst("url"))
        );

        return ServerResponse.ok().render(DomainsName.REDIRECT_ROUTE, websiteMono);
    }

    @ModelAttribute("website")
    public WebsiteModel website() {
        return new WebsiteModel();
    }

    @NonNull
    public Mono<ServerResponse> deleteDomain(ServerRequest serverRequest) {
        String domainName = serverRequest.pathVariable("domain");
        websiteService.deleteWebsite(domainName);
        return ServerResponse.ok().render(DomainsName.REDIRECT_ROUTE);
    }

    @NonNull
    public Mono<ServerResponse> updateDomainGet(ServerRequest serverRequest) {
        return ServerResponse.ok().render("updateDomain", Map.of(DomainsName.WEBSITE_MODEL,
                websiteService.getWebsite(serverRequest.pathVariable("domain"))));
    }

    @NonNull
    public Mono<ServerResponse> updateDomainPost(ServerRequest serverRequest) {
        Mono<MultiValueMap<String, String>> formData = serverRequest.formData();

        Mono<WebsiteModel> websiteMono = formData.flatMap(website ->
                websiteService.updateWebsite(website.get("name").get(0), website.getFirst("url"))
        );

        return ServerResponse.ok().render("redirect:/", websiteMono);

    }
}
