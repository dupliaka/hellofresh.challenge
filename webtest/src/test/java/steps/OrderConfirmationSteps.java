package steps;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.Then;
import pages.purchase.OrderConfirmationPage;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.url;
import static junit.framework.TestCase.assertTrue;

public class OrderConfirmationSteps {

    OrderConfirmationPage orderConfirmationPage = page(OrderConfirmationPage.class);

    @Then("^order is confirmed$")
    public void confirm(){
        orderConfirmationPage.getDoneStep().isDisplayed();
        orderConfirmationPage.getHeading().has(Condition.text("ORDER CONFIRMATION"));
        orderConfirmationPage.getCurrentStep().isDisplayed();
        orderConfirmationPage.getOrderConfirmMessage().has(Condition.text("Your order on My Store is complete."));
        assertTrue(url().matches("(.*)controller=order-confirmation(.*)"));
    }
}
