package dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAdvertResponse {
    private int id;
    private int price;
    private String name;
    private String category;
    private String condition;
    private String city;
    private String description;
    private String img1;
    private String img2;
    private String img3;
    private boolean isFavorite;
    private int owner;
    private String createdAt;
    private String updatedAt;
}
