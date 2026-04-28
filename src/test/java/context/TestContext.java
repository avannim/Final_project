package context;

import com.google.gson.Gson;
import config.Config;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import managers.PageObjectManager;
import model.api.Advert;
import model.api.AccessToken;
import model.test.User;
import net.datafaker.Faker;
import utils.faker.AdvertFaker;

import java.util.Random;
import java.util.UUID;

@Data
public class TestContext {
    final public Gson gson = new Gson();
    final Faker faker = new Faker();
    final AdvertFaker advertFaker = new AdvertFaker();
    private User user;
    private AccessToken accessToken;
    private Advert advert;
    private String userinfo;
    private final PageObjectManager pageObjectManager = new PageObjectManager();

    public void setUser() {
        user = new User(faker);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserInfo(){
        return userinfo;
    }

    public void setUserInfo(String info){
        this.userinfo = info;
    }

    public void setAdvert(){
        Random random = new Random();
        advert = new Advert(random.nextInt(Integer.MAX_VALUE), UUID.randomUUID().toString(),
                advertFaker.advert().city(),
                advertFaker.advert().category(),
                advertFaker.advert().condition(),
                faker.cosmere().knightsRadiant().toUpperCase());
    }

    public void changeAdvert(){
        advert.setCategory(advertFaker.advert().category());
        advert.setCondition(advertFaker.advert().city());
        advert.setName(UUID.randomUUID().toString());
    }

    public String getUserPassword(){
        return user.getPassword();
    }

    public String getUserEmail(){
        return user.getEmail();
    }

    public void setUserId(Integer id){ user.setId(id); }

    public void setAccessToken(String token) {
        this.accessToken = new AccessToken(token);
    }

    public RequestSpecification requestSpec() {
        return Config.getRequestSpec();
    }
}
