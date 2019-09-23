package jose.rodriguez.everis.peru.app.models.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import jose.rodriguez.everis.peru.app.models.document.Dictates;
import reactor.core.publisher.Mono;

public interface DictatesDao extends ReactiveMongoRepository<Dictates, String>{

  
    //public Mono<Dictates> findByName(String name);
}
