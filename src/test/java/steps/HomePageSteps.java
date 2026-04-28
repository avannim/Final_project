package steps;

import config.Config;
import config.LocalStorageHelper;
import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        context.getPageObjectManager().getHomePage().waitingToLoadPage();
    }

    @When("нажимаю на кнопку входа и авторизации")
    public void clickOnLoginButton(){
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
        assertEquals(1,context.getPageObjectManager().getHomePage().checkThereOneCard(), "Найдено более одного объявления");
    }

    @And("проверяю что создалось объявление")
    public void checkAdvert() throws InterruptedException {
        context.getPageObjectManager().getHomePage().searchByAllOptions(context.getAdvert());
        context.getPageObjectManager().getHomePage().waitingToLoadPage();
        assertEquals(1,context.getPageObjectManager().getHomePage().checkThereOneCard(), "Найдено более одного объявления");
        context.getPageObjectManager().getHomePage().clickCard();
        String priceValue = String.format(Locale.US,"%,d ₽", context.getAdvert().getPrice()).replace( ",", " ");
        assertEquals(priceValue, context.getPageObjectManager().getAdvertPage().getAdvertPrice(), "Цена неверная");
        assertEquals(context.getAdvert().getCity(), context.getPageObjectManager().getAdvertPage().getAdvertCity(), "Город неверный");
        assertEquals(context.getAdvert().getName(), context.getPageObjectManager().getAdvertPage().getAdvertName(), "Название неверное");
        assertEquals(context.getAdvert().getDescription(), context.getPageObjectManager().getAdvertPage().getAdvertDescription(), "Описание неверное");
    }

    @And("проверяю что объявление изменилось")
    public void checkEditedAdvert() throws InterruptedException {
        context.getPageObjectManager().getHomePage().searchByAllOptions(context.getAdvert());
        context.getPageObjectManager().getHomePage().waitingToLoadPage();
        assertEquals(1,context.getPageObjectManager().getHomePage().checkThereOneCard(), "Найдено более одного объявления");
        context.getPageObjectManager().getHomePage().clickCard();
        String priceValue = String.format(Locale.US,"%,d ₽", context.getAdvert().getPrice()).replace( ",", " ");
        assertEquals(priceValue, context.getPageObjectManager().getAdvertPage().getAdvertPrice(), "Цена не изменилась");
        assertEquals(context.getAdvert().getCity(), context.getPageObjectManager().getAdvertPage().getAdvertCity(), "Город не изменился");
        assertEquals(context.getAdvert().getName(), context.getPageObjectManager().getAdvertPage().getAdvertName(), "Название не изменилось");
        assertEquals(context.getAdvert().getDescription(), context.getPageObjectManager().getAdvertPage().getAdvertDescription(), "Описание не изменилось");
    }

    @And("открываю объявление на редактирование")
    public void openToEdit(){
        context.getPageObjectManager().getHomePage().clickEditButton();
    }
}
