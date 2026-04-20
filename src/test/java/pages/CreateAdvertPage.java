package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateAdvertPage extends BasePage{

    @FindBy(how = How.XPATH, using = ".//input[@name = 'name']")
    private SelenideElement titleInput;

    @FindBy(how = How.XPATH, using = ".//input[@name = 'price']")
    private SelenideElement priceInput;

    @FindBy(how = How.XPATH, using = ".//textarea[@name = 'description']")
    private SelenideElement descriptionInput;

    @FindBy(how = How.XPATH, using = ".//button[@type = 'submit']")
    private SelenideElement submitButton;


}
