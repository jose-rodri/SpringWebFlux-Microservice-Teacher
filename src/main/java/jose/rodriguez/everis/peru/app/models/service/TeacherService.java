package jose.rodriguez.everis.peru.app.models.service;
import jose.rodriguez.everis.peru.app.models.document.Dictates;
import jose.rodriguez.everis.peru.app.models.document.Teacher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TeacherService {

  public Flux<Teacher> findAll();
  public Mono<Teacher> findById(String id);
  public Mono<Teacher> findByName(String name);
  public Mono<Teacher> save(Teacher teacher);
  public Mono<Void> delete(Teacher teacher);
  
  
  public Flux<Dictates>findAllDictates();
  public Mono<Dictates>findDictById(String id);
  public Mono<Dictates>saveDict(Dictates dict);
  
}
