package fr.hookwood.httponline.routers;

import fr.hookwood.httponline.routers.handler.WebsiteHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DomainRouter {

    @Bean
    RouterFunction<ServerResponse> getDomainsRoutes(WebsiteHandler websiteHandler) {
        return route()
                .GET("/", websiteHandler::getDomains)
                .GET("/getDomain/{domain}", websiteHandler::getDomain)
                .GET("/createDomain", websiteHandler::createDomainGet)
                .POST("/createDomain", accept(MediaType.APPLICATION_FORM_URLENCODED),
                        websiteHandler::createDomainPost)
                .GET("/deleteDomain/{domain}", websiteHandler::deleteDomain)
                .GET("/updateDomain/{domain}", websiteHandler::updateDomainGet)
                .POST("/updateDomain", accept(MediaType.APPLICATION_FORM_URLENCODED),
                        websiteHandler::updateDomainPost)
                .build();
    }
}
