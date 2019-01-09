package pages.purchase;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class AddressesPage implements Passable {

    @FindBy(name = "processAddress")
    private SelenideElement submit;

    public ShippingPage pass(){
        submit.click();
        return page(ShippingPage.class);
    }

}
