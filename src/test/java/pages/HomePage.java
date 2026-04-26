package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import model.api.Advert;
import org.openqa.selenium.support.FindBy;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage extends BasePage{

    @Getter
    private ElementsCollection cards = $$x(".//div[@class = 'card']");

    @FindBy(xpath = ".//button[contains(@class, 'arrowButton-left')]")
    private SelenideElement navigateLeftArrow;

    @FindBy(xpath = ".//button[contains(@class, 'arrowButton-right')]")
    private SelenideElement navigateRightArrow;

    @FindBy(xpath = ".//input[@name = 'name']")
    private SelenideElement searchInput;

    @FindBy(xpath = ".//input[@name = 'price']")
    private SelenideElement priceInput;

    @FindBy(xpath = ".//button[@type = 'submit']")
    private SelenideElement submitButton;

    @FindBy(xpath = ".//div[@class = 'card']")
    private SelenideElement card;

    @FindBy(xpath = ".//div[@class='pagination_shell__c6Llq']/p")
    private SelenideElement pageCount;

    @FindBy(xpath = ".//div[input[@name='city']]/button[contains(@class, 'dropDownMenu_arrowDown__pfGL1')]")
    private SelenideElement cityDropdownButton;

    @FindBy(xpath = ".//div[input[@name='category']]/button[contains(@class, 'dropDownMenu_arrowDown__pfGL1')]")
    private SelenideElement categoryDropdownButton;

    @FindBy(xpath = ".//button[@class = 'editButton']")
    private SelenideElement editButton;

    public HomePage(){
        super();
    }

    public SelenideElement getCardByName(String name) {
        return cards.filterBy(text(name)).shouldHave(size(1)).first();
    }
    public void clickEditOnCard(String name){
        getCardByName(name).$x(".//button[@class = 'editButton']").click();
    }

    public void setSearchInput(String text) {
        searchInput.setValue(text);
    }

    public void setPriceInput(String price) {
        priceInput.setValue(price);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public void searchByName(String name){
        setSearchInput(name);
        clickSubmitButton();
    }

    public void chooseCategoryByName(String value){
        categoryDropdownButton.click();
        $$x(".//div[input[@name='category']]/parent::div//button").findBy(text(value)).click();
    }

    public void chooseCityByName(String value){
        cityDropdownButton.click();
        $$x(".//div[input[@name='city']]/parent::div//button").findBy(text(value)).click();
    }

    public void searchByAllOptions(Advert advert){
        setSearchInput(advert.getName());
        setPriceInput(String.valueOf(advert.getPrice()));
        System.out.println("выбираю категорию " + advert.getCategory());
        chooseCategoryByName(advert.getCategory());
        System.out.println("выбираю город " + advert.getCity());
        chooseCityByName(advert.getCity());
        clickSubmitButton();
    }

    public void checkCardNotExist(Advert advert){
        searchByAllOptions(advert);
        card.shouldNot(exist);
    }

    public void clickCard(){
        card.click();
    }

    public void checkThereOneCard(){
        pageCount.shouldHave(text("1 из 1"));
        int count = cards.size();
        assertEquals(1,count, "Найдено более одного объявления");
    }

    public void clickEditButton(){
        editButton.click();
    }
}
