package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ModalWindowPage {

    @FindBy(how = How.XPATH, using = ".//div[@class = 'homePage_modal__zSdUB']//input[@name = 'email']")
    private SelenideElement emailInput;

    @FindBy(how = How.XPATH, using = ".//div[@class = 'homePage_modal__zSdUB']//input[@name = 'password']")
    private SelenideElement passwordInput;

    @FindBy(how = How.XPATH, using = ".//div[@class = 'homePage_modal__zSdUB']//input[@name = 'submitPassword']")
    private SelenideElement submitPasswordInput;

    @FindBy(how=How.XPATH, using = ".//div[@class = 'homePage_modal__zSdUB']//button[contains(@class,'buttonPrimary')]")
    private SelenideElement submitButton;

    @FindBy(how=How.XPATH, using = "//div[@class = 'homePage_modal__zSdUB']//button[contains(@class, 'buttonSecondary')]")
    private SelenideElement changeFormButton;


    public void waitToModalLoad(){
        $x("//div[@class = 'homePage_modal__zSdUB']").shouldBe(visible);
    }

    public void setEmailInput(String email) {
        emailInput.setValue(email);
    }

    public void setPasswordInput(String password) {
        passwordInput.setValue(password);
    }

    public void setSubmitPasswordInput(String password) {
        submitPasswordInput.setValue(password);
    }

    public void clicksubmitButton(){
        submitButton.click();
    }

    public void clickChangeFormButton() {
        changeFormButton.click();
    }

    public void loginUser(String email, String password){
        setEmailInput(email);
        setPasswordInput(password);
        clicksubmitButton();
    }

    public void registerUser(String email, String password){
        setEmailInput(email);
        setPasswordInput(password);
        setSubmitPasswordInput(password);
        clicksubmitButton();
    }
}
