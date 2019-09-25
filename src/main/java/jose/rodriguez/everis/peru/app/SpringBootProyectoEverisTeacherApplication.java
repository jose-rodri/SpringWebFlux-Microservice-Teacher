package jose.rodriguez.everis.peru.app;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import jose.rodriguez.everis.peru.app.models.document.Dictates;
import jose.rodriguez.everis.peru.app.models.document.Teacher;
import jose.rodriguez.everis.peru.app.models.service.implement.TeacherServiceImplement;
import reactor.core.publisher.Flux;

@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootProyectoEverisTeacherApplication implements CommandLineRunner {

  private static final Logger log = LoggerFactory.getLogger(SpringBootProyectoEverisTeacherApplication.class);
  
  @Autowired
  private TeacherServiceImplement service;
  
  @Autowired
  private ReactiveMongoTemplate mongoTemplate;
  

  public static void main(String[] args) {
    SpringApplication.run(SpringBootProyectoEverisTeacherApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    mongoTemplate.dropCollection("teachers").subscribe();
    mongoTemplate.dropCollection("dictates").subscribe();
      
    Dictates oneCourse = new Dictates("oneCourse");
    Dictates twoCourse = new Dictates("twoCourse");
     
 Flux.just(oneCourse,twoCourse)
 .flatMap(c -> service.saveDict(c))
 .doOnNext(c ->{
   log.info("Cantidad de curso : " + c.getNumCourses());
 }).thenMany(
     // String name,  String lastName,  String gender,Date date,  String typeDocument,  int document
     Flux.just(
         new Teacher("Venon","Ames","M",new Date(),"Dni",4456456,oneCourse),
         new Teacher("Hal","Aioma","M",new Date(),"Dni",969559898,twoCourse),
         new Teacher("Selena","Delmar","F",new Date(),"Dni",87878487,oneCourse),
         new Teacher("Edgar","Poma","M",new Date(),"Dni",63221212,twoCourse),
         new Teacher("Adeline","Amm","M",new Date(),"Dni",87848758,oneCourse),
         new Teacher("Isabel","Abelson","F",new Date(),"Dni",96665989,twoCourse),
         new Teacher("Abella","Anderson","M",new Date(),"Dni",32326595,oneCourse))
     .flatMap(teacher ->{
       teacher.setDate(new Date());
       return service.save(teacher);
     })
     ).subscribe(teacher ->log.info("insert :" + teacher.getName()));
 

  }

}
