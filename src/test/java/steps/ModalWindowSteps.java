package steps;

import context.TestContext;
import io.cucumber.java.en.And;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


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
        assertTrue(context.getPageObjectManager().getModalWindow().isModalWindowDisplayed());
    }

    @And("регистирую пользователя с проверкой успеха")
    public void userRegistration(){
        context.setUser();
        context.getPageObjectManager().getModalWindow().registerUser(context.getUserEmail(), context.getUserPassword());
        context.getPageObjectManager().getHomePage().waitingToLoadPage();
        context.getPageObjectManager().getHomePage().getLogoutButton().shouldBe(visible);
    }

    @And("регистирую пользователя с существующим email")
    public void userRegistrationWithExistingEmail(){
        context.getPageObjectManager().getModalWindow().registerUser(context.getUserEmail(), context.getUserPassword());
        context.getPageObjectManager().getHomePage().waitingToLoadPage();
    }

    @And("вижу ошибку на форме создания")
    public void seeErrorMessage(){
        context.getPageObjectManager().getModalWindow().getErrorMessage().shouldBe(visible);
        String errorText = context.getPageObjectManager().getModalWindow().getErrorMessageText();
        assertEquals("Ошибка", errorText, "Сообщение об ошибке имеет не верный текст");
    }

    @And("авторизую пользователя с проверкой успеха")
    public void userAuthorisation(){
        context.getPageObjectManager().getModalWindow().loginUser(context.getUserEmail(), context.getUserPassword());
        context.getPageObjectManager().getHomePage().waitingToLoadPage();
        context.getPageObjectManager().getHomePage().getLogoutButton().shouldBe(visible);
    }

}
