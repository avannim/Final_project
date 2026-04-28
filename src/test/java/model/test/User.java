package model.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.datafaker.Faker;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String email;
    private String password;

    public User(Faker faker){
        this.email = faker.internet().safeEmailAddress();
        this.password = faker.internet().password(6, 15,true);
    }

}
