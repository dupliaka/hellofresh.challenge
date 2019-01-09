package pages.purchase;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class OrderSummaryPage implements Passable{
    @FindBy(xpath = "//*[@id='cart_navigation']/button")
    private SelenideElement confirmOrderBtn;

    public OrderConfirmationPage pass(){
        confirmOrderBtn.click();
        return page(OrderConfirmationPage.class);
    }

}
