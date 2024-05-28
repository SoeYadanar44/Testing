package bookmanagement.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

public class BookBean implements Serializable{
  private int id;
  @NotEmpty
  private String name;
  @NotEmpty
  private String author;
 
  @Range(min=1,max=1000000)
  private double price;
 
  
  public BookBean() {
    
  }
  
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getAuthor() {
    return author;
  }
  public void setAuthor(String author) {
    this.author = author;
  }
  public double getPrice() {
    return price;
  }
  public void setPrice(double price) {
    this.price = price;
  }
}