package jose.rodriguez.everis.peru.app.models.document;

import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;





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
  public Teacher( String name,  String lastName,  String gender,
      Date date,  String typeDocument,  int document) {
   
    this.name = name;
    this.lastName = lastName;
    this.gender = gender;
    this.date = date;
    this.typeDocument = typeDocument;
    this.document = document;
  }

  
  
  
  
  public Teacher(  String name,  String lastName, String gender, Date date,  String typeDocument,  int document, Dictates dictates) {
    
    this(name, lastName, gender, date, typeDocument, document);
    this.dictates = dictates;
  }
  
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }
  public String getTypeDocument() {
    return typeDocument;
  }
  public void setTypeDocument(String typeDocument) {
    this.typeDocument = typeDocument;
  }
  public int getDocument() {
    return document;
  }
  public void setDocument(int document) {
    this.document = document;
  }
  public Dictates getDictates() {
    return dictates;
  }
  public void setDictates(Dictates dictates) {
    this.dictates = dictates;
  }
 
  

  
}
