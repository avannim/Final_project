package steps;

import config.Config;
import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.*;

public class AdvertPageSteps {
    private final TestContext context;

    public AdvertPageSteps(TestContext context) {
        this.context = context;
    }

    @And("создаю объявление")
    public void createAdvert(){
        context.setAdvert();
        context.getPageObjectManager().getCreateAdvertPage().setPriceInput(context.getAdvert().getPrice());
        context.getPageObjectManager().getCreateAdvertPage().setTitleInput(context.getAdvert().getName());
        context.getPageObjectManager().getCreateAdvertPage().setDescriptionInput(context.getAdvert().getDescription());
        context.getPageObjectManager().getCreateAdvertPage().chooseCondition(context.getAdvert().getCondition());
        context.getPageObjectManager().getCreateAdvertPage().chooseCategory(context.getAdvert().getCategory());
        context.getPageObjectManager().getCreateAdvertPage().chooseCity(context.getAdvert().getCity());
        context.getPageObjectManager().getCreateAdvertPage().clickSubmitButton();
        context.getPageObjectManager().getHomePage().waitingToLoadPage();
    }

    @And("удаляю объявление")
    public void searchAdvert(){
        context.getPageObjectManager().getHomePage().clickCard();
        context.getPageObjectManager().getAdvertPage().clickDeleteButton();
        context.getPageObjectManager().getHomePage().checkCardNotExist(context.getAdvert());
    }

    @And("открываю объявление на редактирование со страницы объявления")
    public void openAdvertonEdit(){
        context.getPageObjectManager().getAdvertPage().clickEditButton();
        context.getPageObjectManager().getCreateAdvertPage().waitToLoadPage("Редактировать объявление");
    }

    @And("редактирую объявление")
    public void editAdvert(){
        context.changeAdvert();
        context.getPageObjectManager().getCreateAdvertPage().setTitleInput(context.getAdvert().getName());
        context.getPageObjectManager().getCreateAdvertPage().chooseCategory(context.getAdvert().getCategory());
        context.getPageObjectManager().getCreateAdvertPage().chooseCity(context.getAdvert().getCity());
        context.getPageObjectManager().getCreateAdvertPage().clickSubmitButton();
        context.getPageObjectManager().getHomePage().waitingToLoadPage();
    }
}
