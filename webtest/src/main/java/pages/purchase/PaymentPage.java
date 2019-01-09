package pages.purchase;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class PaymentPage implements Passable{
    @FindBy(className ="bankwire" )
    private SelenideElement bankwirePaymentMethod;

    public OrderSummaryPage pass(){
        bankwirePaymentMethod.click();
        return page(OrderSummaryPage.class);
    }


}
