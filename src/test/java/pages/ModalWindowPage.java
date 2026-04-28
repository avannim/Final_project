package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Data
public class ModalWindowPage {

    @FindBy(xpath = "//div[@class = 'homePage_modal__zSdUB']//input[@name = 'email']")
    private SelenideElement emailInput;

    @FindBy(xpath = "//div[@class = 'homePage_modal__zSdUB']//input[@name = 'password']")
    private SelenideElement passwordInput;

    @FindBy(xpath = "//div[@class = 'homePage_modal__zSdUB']//input[@name = 'submitPassword']")
    private SelenideElement submitPasswordInput;

    @FindBy(xpath = "//div[@class = 'homePage_modal__zSdUB']//button[contains(@class,'buttonPrimary')]")
    private SelenideElement submitModalButton;

    @FindBy(xpath = "//div[@class = 'homePage_modal__zSdUB']//button[contains(@class, 'buttonSecondary')]")
    private SelenideElement changeFormButton;

    @FindBy(xpath = "//div[input[@name = 'email']]/ancestor::div/span")
    private SelenideElement errorMessage;

    public ModalWindowPage(){
        page(this);
    }

    public boolean isModalWindowDisplayed(){
        return  $x("//div[@class = 'homePage_modal__zSdUB']").isDisplayed();
    }

    public void waitToModalLoad() {
        $x("//div[@class = 'homePage_modal__zSdUB']").shouldBe(visible);
    }

    public void waitToRegisterFormLoad(){
        $x("//div[@class = 'homePage_modal__zSdUB']//h1[text() = 'Зарегистрироваться']").shouldBe(visible);
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

    public void clickSubmitButton(){
        submitModalButton.click();
    }

    public void clickChangeFormButton() {
        changeFormButton.click();
    }

    public void loginUser(String email, String password){
        setEmailInput(email);
        setPasswordInput(password);
        clickSubmitButton();
    }

    public void registerUser(String email, String password){
        setEmailInput(email);
        setPasswordInput(password);
        setSubmitPasswordInput(password);
        clickSubmitButton();
    }

    public String getErrorMessageText(){
        return errorMessage.getText();
    }
}
