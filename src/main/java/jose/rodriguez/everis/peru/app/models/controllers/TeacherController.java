package jose.rodriguez.everis.peru.app.models.controllers;

import java.net.URI;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jose.rodriguez.everis.peru.app.models.document.Teacher;
import jose.rodriguez.everis.peru.app.models.service.TeacherService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/everis/teachers")
public class TeacherController {


  @Autowired
  private TeacherService service;


  /**
   * . Método listar coment
   */
  @GetMapping
  public Mono<ResponseEntity<Flux<Teacher>>> findAll() {
    return Mono.just(

        ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(service.findAll()));
  }

  /**
   * . a Método crear
   */

  @PostMapping
  public Mono<ResponseEntity<Teacher>> save(@RequestBody Teacher teacher) {
    if (teacher.getDate() == null) {
      teacher.setDate(new Date());
    }
    return service.save(teacher)
        .map(p -> ResponseEntity.created(URI.create("/api/everis/teachers/".concat(p.getId())))
            .contentType(MediaType.APPLICATION_JSON_UTF8).body(p));

  }

  /**
   * . Método filtrar por codigo
   * 
   * @return
   */
  @GetMapping("/{id}")
  public Mono<ResponseEntity<Teacher>> findById(@PathVariable String id) {
    return service.findById(id)
        .map(p -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(p))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  /**
   * . Método actualizar
   * 
   * @return
   */
  @PutMapping("/{id}")
  public Mono<ResponseEntity<Teacher>> update(@RequestBody Teacher teacher,
      @PathVariable String id) {
    return service.findById(id).flatMap(t -> {
      t.setName(teacher.getName());
      t.setLastName(teacher.getLastName());
      t.setGender(teacher.getGender());
      t.setTypeDocument(teacher.getTypeDocument());
      t.setDocument(teacher.getDocument());
      t.setDictates(teacher.getDictates());
      return service.save(t);
    }).map(
        p -> ResponseEntity.created(URI.create("/api/everis/teachers/".concat(p.getId()))).body(p))
        .defaultIfEmpty(ResponseEntity.notFound().build());


  }

  /**
   * .
   * 
   * @return
   */
  @DeleteMapping("/{id}")
  public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
    return service.findById(id).flatMap(p -> {
      return service.delete(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));

    }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
  }


}
