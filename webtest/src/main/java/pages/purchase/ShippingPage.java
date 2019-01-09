package pages.purchase;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class ShippingPage implements Passable{
    @FindBy(id = "uniform-cgv")
    private SelenideElement terms;

    @FindBy(name = "processCarrier")
    private SelenideElement processCarrier;

    public PaymentPage pass(){
        terms.click();
        processCarrier.click();
        return page(PaymentPage.class);
    }
}
