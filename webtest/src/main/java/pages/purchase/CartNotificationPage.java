package pages.purchase;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class CartNotificationPage implements Passable {

    @FindBy(xpath = "//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")
    private SelenideElement proceedBtn;

    public SummaryPage pass() {
        proceedBtn.click();
        return page(SummaryPage.class);
    }
}
