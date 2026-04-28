package pages;

import com.codeborne.selenide.SelenideElement;
import model.api.Advert;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static java.awt.SystemColor.text;


public class AdvertPage extends BasePage{

    @FindBy(xpath = ".//button[text() = 'Удалить']")
    private SelenideElement deleteButton;

    @FindBy(xpath = ".//button[text() = 'Редактировать объявление']")
    private SelenideElement editButton;

    @FindBy(xpath = ".//div[@class = 'description_shell__T6J3Y listing_exDescription__pHaIQ']/h1")
    private SelenideElement name;

    @FindBy(xpath = ".//div[@class = 'description_shell__T6J3Y listing_exDescription__pHaIQ']/p")
    private SelenideElement description;

    @FindBy(xpath = ".//div[@class = 'listing_adressPrice__Oct0z']/h1")
    private SelenideElement price;

    @FindBy(xpath = "//div[@class = 'listing_adressPrice__Oct0z']//h3[@class='subtitle']")
    private SelenideElement city;

    public AdvertPage(){
        super();
    }

    public void clickEditButton() {
        editButton.click();
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public String getAdvertName(){
        return name.getText();
    }

    public String getAdvertDescription(){
        return description.getText();
    }

    public String getAdvertPrice(){
        return  price.getText();
    }

    public String getAdvertCity(){
        return city.getText();
    }
}
