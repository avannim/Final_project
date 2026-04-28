package dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.api.AccessToken;
import model.api.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResponse {
    private User user;
    private AccessToken access_token;
}
