package jose.rodriguez.everis.peru.app.models.dao;

import jose.rodriguez.everis.peru.app.models.document.Teacher;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;



public interface TeacherDao extends ReactiveMongoRepository<Teacher, String> {

  
  
}
