package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CreateAdvertPage extends BasePage{

    @FindBy(how = How.XPATH, using = ".//input[@name = 'name']")
    private SelenideElement titleInput;

    @FindBy(how = How.XPATH, using = ".//input[@name = 'price']")
    private SelenideElement priceInput;

    @FindBy(how = How.XPATH, using = ".//textarea[@name = 'description']")
    private SelenideElement descriptionInput;

    @FindBy(how = How.XPATH, using = ".//button[@type = 'submit']")
    private SelenideElement submitButton;

    @FindBy(how = How.XPATH, using = ".//div[@class = 'createListing_shell__A5EA7']/h1[contains(@class, 'createListing_title__IFtFs')]")
    private SelenideElement title;

    @FindBy(xpath = ".//div[input[@name='city']]/button[contains(@class, 'dropDownMenu_arrowDown__pfGL1')]")
    private SelenideElement cityDropdownButton;

    @FindBy(xpath = ".//div[input[@name='category']]/button[contains(@class, 'dropDownMenu_arrowDown__pfGL1')]")
    private SelenideElement categoryDropdownButton;

    public CreateAdvertPage(){
        super();
    }

    public void waitToLoadPage(String value) {
        title.shouldHave(text(value));
    }

    public void setPriceInput(Integer prise) {
        priceInput.setValue(String.valueOf(prise));
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void setDescriptionInput(String description) {
        descriptionInput.setValue(description);
    }

    public void setTitleInput(String title){
        titleInput.setValue(title);
    }

    public void chooseCategory(String value) {
        categoryDropdownButton.click();
        $x(String.format(".//div[div[input[@name='category']]]//button[span[text()='%s']]", value)).click();
    }

    public void chooseCondition(String text){
        $x(String.format(".//input[@name = 'condition' and @value='%s']/following-sibling::div", text)).click();
    }

    public void chooseCity(String value){
        cityDropdownButton.click();
        $x(String.format(".//div[div[input[@name='city']]]//button[span[text()='%s']]", value)).click();
    }
}
