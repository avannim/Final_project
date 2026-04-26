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

    @FindBy(xpath = "")
    private SelenideElement price;

    @FindBy(xpath = "")
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

    public void checkAdvertAttributes(Advert advert){
        name.shouldHave(text(advert.getName()));
        description.shouldHave(text(advert.getDescription()));
        price.shouldHave(text(String.valueOf(advert.getPrice())));
        city.shouldHave(text(advert.getCity()));
    }
}
