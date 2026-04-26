package steps;

import config.Config;
import context.TestContext;
import io.cucumber.java.en.And;
import pages.HomePage;
import pages.ModalWindowPage;
import pages.ProfilePage;


public class ModalWindowSteps {

    private final TestContext context;

    public ModalWindowSteps(TestContext context) {
        this.context = context;
    }

    @And("перехожу с формы авторизации на форму регистрации в окне")
    public void changeAuthFormToRegistration(){
        context.getPageObjectManager().getModalWindow().clickChangeFormButton();
        context.getPageObjectManager().getModalWindow().waitToRegisterFormLoad();
    }

    @And("вижу окно авторизации")
    public void modalWindowVisible(){
        context.getPageObjectManager().getModalWindow().waitToModalLoad();
    }

    @And("^регистирую пользователя( с данными уже существующего пользователя)?$")
    public void userRegistration(String withError){
        if (withError == null) {
            context.setUser();
        }
        context.getPageObjectManager().getModalWindow().registerUser(context.getUserEmail(), context.getUserPassword());
        if (withError == null) {
            context.getPageObjectManager().getProfilePage().isLogoutButtonVisible();
        } else {
            context.getPageObjectManager().getModalWindow().isErrorVisible("Ошибка");
        }
    }

    @And("авторизую пользователя")
    public void userAuthorisation(){
        context.getPageObjectManager().getModalWindow().loginUser(context.getUserEmail(), context.getUserPassword());
        context.getPageObjectManager().getProfilePage().isLogoutButtonVisible();
    }

}
