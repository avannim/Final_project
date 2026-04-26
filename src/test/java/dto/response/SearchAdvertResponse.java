package dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.api.Advert;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchAdvertResponse {
    private List<Advert> offers;
    private int totalPages;
}
