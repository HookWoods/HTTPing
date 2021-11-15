package fr.hookwood.httponline.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class SitePingerService {

    public Mono<Integer> getStatusCode(String url) {
        return WebClient.create(url).get().exchangeToMono(response -> Mono.just(response.statusCode().value()));
    }
}
