package pages.purchase;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class ProductViewPage implements Passable {

    @FindBy(name = "Submit")
    private SelenideElement submit;

    public CartNotificationPage pass(){
        submit.click();
        return page(CartNotificationPage.class);
    }

}
