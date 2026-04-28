package steps;

import config.Config;
import config.LocalStorageHelper;
import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.*;

public class HomePageSteps {

    private final TestContext context;

    public HomePageSteps(TestContext context) {
        this.context = context;
    }

    @Given("перехожу на главную страницу")
    public void loadMainPage() throws InterruptedException {
        open(Config.baseUri);
        context.getPageObjectManager().getHomePage().waitingToLoadPage();
    }

    @Given("перехожу на главную страницу под авторизованным пользователем")
    public void loadMainPageAuthorized() throws InterruptedException {
        open(Config.baseUri);
        LocalStorageHelper helper = new LocalStorageHelper();
        helper.setItem("islogin", "true");
        helper.setItem("password", context.getUserPassword());
        System.out.println(context.gson.toJson(context.getUser()));
        helper.setItem("token", context.getAccessToken().getAccess_token());
        helper.setItem("user", context.gson.toJson(context.getUser()));
        refresh();
        sleep(10000);
        context.getPageObjectManager().getHomePage().waitingToLoadPage();
    }

    @When("нажимаю на кнопку входа и авторизации")
    public void clickonLoginButton(){
        context.getPageObjectManager().getHomePage().clickLoginButton();
    }

    @When("перехожу на страницу создания объявления")
    public void clickCreateAdvertButton() {
        context.getPageObjectManager().getHomePage().clickCreateAdvertButton();
        context.getPageObjectManager().getCreateAdvertPage().waitToLoadPage("Новое объявление");
    }

    @And("ищу объявление")
    public void searchAdvert(){
        context.getPageObjectManager().getHomePage().searchByAllOptions(context.getAdvert());
        context.getPageObjectManager().getHomePage().checkThereOneCard();
    }

    @And("проверяю что создалось объявление")
    public void checkAdvert() throws InterruptedException {
        context.getPageObjectManager().getHomePage().searchByAllOptions(context.getAdvert());
        context.getPageObjectManager().getHomePage().waitingToLoadPage();
        context.getPageObjectManager().getHomePage().checkThereOneCard();
        context.getPageObjectManager().getHomePage().clickCard();
        context.getPageObjectManager().getAdvertPage().checkAdvertAttributes(context.getAdvert());
    }

    @And("проверяю что объявление изменилось")
    public void checkEditedAdvert() throws InterruptedException {
        context.getPageObjectManager().getHomePage().searchByAllOptions(context.getAdvert());
        context.getPageObjectManager().getHomePage().waitingToLoadPage();
        context.getPageObjectManager().getHomePage().checkThereOneCard();
        context.getPageObjectManager().getHomePage().clickCard();
        context.getPageObjectManager().getAdvertPage().checkAdvertAttributes(context.getAdvert());
    }

    @And("открываю объявление на редактирование")
    public void openToEdit(){
        context.getPageObjectManager().getHomePage().clickEditButton();
    }
}
