package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BasePage {

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'buttonSecondary') and not(@type='submit')]")
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'buttonPrimary')]")
    private SelenideElement createAdvertButton;

    public void clickLoginButton(){
        loginButton.click();
    }

    public void clickCreateAdvertButton(){
        createAdvertButton.click();
    }

}
