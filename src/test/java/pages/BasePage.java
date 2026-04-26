package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class BasePage {

    @FindBy(xpath = "//button[contains(@class, 'buttonSecondary') and not(@type='submit')]")
    private SelenideElement loginButton;

    @FindBy(xpath = "//button[contains(@class, 'buttonPrimary')]")
    private SelenideElement createAdvertButton;

    @FindBy(xpath = "//button[@class = 'circleSmall']")
    private SelenideElement userProfileButton;

    @FindBy(xpath = "//button[contains(@class, 'btnSmall')]")
    private SelenideElement logoutButton;

    public BasePage(){
        page(this);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void clickCreateAdvertButton(){
        createAdvertButton.click();
    }

    public void clickLogoutButton() { logoutButton.click(); }

    public void clickUserProfileButton() { userProfileButton.click(); }

    public void waitingToLoadPage() {
        createAdvertButton.shouldBe(visible);
    }

    public void isLogoutButtonVisible(){
        logoutButton.shouldBe(Condition.visible);
    }

}
