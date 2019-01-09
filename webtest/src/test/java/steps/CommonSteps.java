package steps;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import enums.Page;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.purchase.Passable;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static org.openqa.selenium.OutputType.BYTES;

public class CommonSteps {
    private static Logger logger = LoggerFactory.getLogger(CommonSteps.class);

    private final String regexpForPossiblePages = "(HOME|ProductViewPage|CartNotificationPage|SummaryPage|AddressesPage|ShippingPage|PaymentPage|OrderSummaryPage)";

    @Given("^open page " + regexpForPossiblePages + "$")
    public void openPage(String pageName) {
        Page page = Page.valueOf(pageName);
        open(page.toString());
    }

    @And("^pass "+regexpForPossiblePages+"$")
    public void pass(String className){
        try {
            Class myClass = Class.forName("pages.purchase."+ className);
            Passable obj = (Passable) page(myClass);
            obj.pass();
        }catch (Exception e){
            logger.error("Cannot pass page", e);
        }
    }


    @Before
    public void reset(){
        clearBrowserCache();
    }

    @After
    public void embedScreenshotOnFail(Scenario s) {
        if (s.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(BYTES);
                s.embed(screenshot, "image/png");
                s.write("URL at failure: " + WebDriverRunner.getWebDriver().getCurrentUrl());
            } catch (WebDriverException wde) {
                s.write("Embed Failed " + wde.getMessage());
            } catch (ClassCastException cce) {
                logger.error("Failed to make screen", cce);
            }
        }
    }

}
