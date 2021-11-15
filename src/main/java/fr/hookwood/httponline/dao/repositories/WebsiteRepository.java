package fr.hookwood.httponline.dao.repositories;

import fr.hookwood.httponline.dao.entities.Website;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface WebsiteRepository extends ReactiveMongoRepository<Website, String> {

    Mono<Website> findByName(String name);

    Mono<Void> deleteByName(String name);


}
