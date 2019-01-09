package pages.purchase;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class SummaryPage implements Passable{
    @FindBy(xpath = "//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")
    SelenideElement proceed;

    public AddressesPage pass(){
        proceed.click();
        return page(AddressesPage.class);
    }
}
