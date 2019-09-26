package jose.rodriguez.everis.peru.app.Service;

import static org.mockito.Mockito.when;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.reactivestreams.Publisher;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import jose.rodriguez.everis.peru.app.models.dao.TeacherDao;
import jose.rodriguez.everis.peru.app.models.document.Teacher;
import jose.rodriguez.everis.peru.app.models.service.implement.TeacherServiceImplement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class testService {
  

  @Mock
  private TeacherDao teacherDao;

  @InjectMocks
  private TeacherServiceImplement teacherService;

  


  private void assertResults(Publisher<Teacher> publisher, Teacher... expectedProducts) {
    StepVerifier.create(publisher).expectNext(expectedProducts).verifyComplete();
  }


  @Test
  public void findAll() {
    Teacher p = new Teacher();
    
    p.setName("Ángel");
    p.setLastName("Diam");
    p.setGender("M");
    p.setDate(new Date());
    p.setTypeDocument("dni");
    p.setDocument(58485888);
    when(teacherService.findAll()).thenReturn(Flux.just(p));
    Flux<Teacher> actual = teacherService.findAll();
    assertResults(actual, p);
  }


  @Test
  public void idexisting() {
    Teacher p = new Teacher();
    p.setName("Mae");
    p.setLastName("zoeli");
    p.setGender("F");
    p.setDate(new Date());
    p.setTypeDocument("dni");
    p.setDocument(47232312);
    when(teacherDao.findById(p.getId())).thenReturn(Mono.just(p));
    Mono<Teacher> actual = teacherService.findById(p.getId());
    assertResults(actual, p);
  }


  @Test
  public void idInvalid() {
    Teacher p = new Teacher();
    p.setId("111111");
    p.setName("Mae");
    p.setLastName("zoeli");
    p.setGender("F");
    p.setDate(new Date());
    p.setTypeDocument("dni");
    p.setDocument(96895756);
    when(teacherDao.findById(p.getId())).thenReturn(Mono.empty());
    Mono<Teacher> actual = teacherService.findById(p.getId());
    assertResults(actual);
  }



  @Test
  public void save() {
    Teacher p = new Teacher();
    p.setId("iiiiiiiii");
    p.setName("Mae");
    p.setLastName("zoeli");
    p.setGender("F");
    p.setDate(new Date());
    p.setTypeDocument("dni");
    p.setDocument(96895756);
    when(teacherDao.save(p)).thenReturn(Mono.just(p));
    Mono<Teacher> actual = teacherService.save(p);
    assertResults(actual, p);
  }



  @Test
  public void delete() {
    Teacher p = new Teacher();
    p.setId("iiiiii");
    p.setName("Mae");
    p.setLastName("zoeli");
    p.setDate(new Date());
    p.setTypeDocument("dni");
    p.setDocument(96895756);
    when(teacherDao.delete(p)).thenReturn(Mono.empty());
  }






}
