package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;

public class HomePage extends BasePage{

    @Getter
    private ElementsCollection cards = $$x(".//div[@class = 'card']");

    @FindBy(how =How.XPATH, using = ".//button[contains(@class, 'arrowButton-left')]")
    private SelenideElement navigateLeftArrow;

    @FindBy(how =How.XPATH, using = ".//button[contains(@class, 'arrowButton-right')]")
    private SelenideElement navigateRightArrow;

    @FindBy(how = How.XPATH, using = ".//input[@name = 'name']")
    private SelenideElement searchInput;

    @FindBy(how = How.XPATH, using = ".//input[@name = 'price']")
    private SelenideElement priceInput;

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
}
