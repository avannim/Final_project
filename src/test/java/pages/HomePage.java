package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage{

    @FindBy(how = How.XPATH, using = ".//div[@class = 'card']")
    private SelenideElement card;

    @FindBy(how =How.XPATH, using = ".//button[contains(@class, 'arrowButton-left')]")
    private SelenideElement navigateLeftArrow;

    @FindBy(how =How.XPATH, using = ".//button[contains(@class, 'arrowButton-right')]")
    private SelenideElement navigateRightArrow;
}
