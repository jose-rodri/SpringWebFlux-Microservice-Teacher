package jose.rodriguez.everis.peru.app.models.dao;

import jose.rodriguez.everis.peru.app.models.document.Dictates;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;



public interface DictatesDao extends ReactiveMongoRepository<Dictates, String> {


}
