package jose.rodriguez.everis.peru.app.models.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document(collection = "teachers")
public class Teacher {

  @Id
  private String id;
  @NotEmpty
  private String name;
  @NotEmpty
  private String lastName;
  @NotEmpty
  private String gender;
  @JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
  private Date date;
  @NotEmpty
  private String typeDocument;
  @NotNull
  private int document;


  private Dictates dictates;




  public Teacher() {

  }

  /**.
   l
   */
  public Teacher(String name, String lastName, String gender, Date date, String typeDocument,
      int document, Dictates dictates) {


    this.name = name;
    this.lastName = lastName;
    this.gender = gender;
    this.date = date;
    this.typeDocument = typeDocument;
    this.document = document;
    this.dictates = dictates;
  }






  


}
