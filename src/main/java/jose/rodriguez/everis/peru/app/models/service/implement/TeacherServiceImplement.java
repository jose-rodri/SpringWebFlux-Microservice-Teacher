package jose.rodriguez.everis.peru.app.models.service.implement;
import jose.rodriguez.everis.peru.app.models.dao.DictatesDao;
import jose.rodriguez.everis.peru.app.models.dao.TeacherDao;
import jose.rodriguez.everis.peru.app.models.document.Dictates;
import jose.rodriguez.everis.peru.app.models.document.Teacher;
import jose.rodriguez.everis.peru.app.models.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * . josé Rodriguez
 *
 */
@Service
public class TeacherServiceImplement implements TeacherService {


  @Autowired
  private TeacherDao dao;


  @Autowired
  private DictatesDao daoDict;


  /**
   * .
   *
   */
  @Override
  public Flux<Teacher> findAll() {
    return dao.findAll();
  }


  @Override
  public Mono<Teacher> findById(String id) {
    return dao.findById(id);
  }

  @Override
  public Mono<Teacher> findByName(String name) {

    return null;
  }

  @Override
  public Mono<Teacher> save(Teacher teacher) {
    return dao.save(teacher);
  }

  @Override
  public Mono<Void> delete(Teacher teacher) {
    return dao.delete(teacher);
  }


  @Override
  public Flux<Dictates> findAllDictates() {
    // TODO Auto-generated method stub
    return daoDict.findAll();
  }


  @Override
  public Mono<Dictates> findDictById(String id) {
    // TODO Auto-generated method stub
    return daoDict.findById(id);
  }


  @Override
  public Mono<Dictates> saveDict(Dictates dict) {
    // TODO Auto-generated method stub
    return daoDict.save(dict);
  }



}
