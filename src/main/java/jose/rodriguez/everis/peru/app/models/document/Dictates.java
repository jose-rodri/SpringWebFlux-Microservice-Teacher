package jose.rodriguez.everis.peru.app.models.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document(collection = "dictates")
public class Dictates {


  @Id
  private String id;
  private String numCourses;



  public Dictates(String numCourses) {
    this.numCourses = numCourses;
  }



}
