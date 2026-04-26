package model.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Advert {
  private Integer id;
  private Integer price;
  private String name;
  private String category;
  private String condition;
  private String city;
  private String description;
  private String img1;
  private String img2;
  private String img3;
  private Boolean isFavorite;
  private Integer owner;
  private String createdAt;
  private String updatedAt;

  public Advert(Integer price, String name, String city, String category, String condition, String description){
      this.price = price;
      this.name = name;
      this.city = city;
      this.category = category;
      this.condition = condition;
      this.description = description;
  }
}
