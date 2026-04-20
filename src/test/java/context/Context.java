package context;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Token;
import model.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Context {
    private User user;
    private Token token;
}
