package steps;

import config.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import static com.codeborne.selenide.Selenide.*;

public class PageSteps {

    @Given("перехожу на главную страницу")
    public void loadMainPage(){
        open(Config.baseUri);
    }
}
