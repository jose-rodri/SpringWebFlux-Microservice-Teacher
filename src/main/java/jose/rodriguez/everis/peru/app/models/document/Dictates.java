package jose.rodriguez.everis.peru.app.models.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="dictates")
public class Dictates {

  
  @Id
  private String id;
  private String numCourses;
  
  
  
  
  public Dictates() {
    
  }
  
  
  public Dictates(String numCourses) {
    this.numCourses = numCourses;
  }
  
  
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getNumCourses() {
    return numCourses;
  }
  public void setNumCourses(String numCourses) {
    this.numCourses = numCourses;
  }
  
  
  
  
}
