package steps;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import enums.Page;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.OutputType.BYTES;

public class CommonSteps {
    private static Logger logger = LoggerFactory.getLogger(CommonSteps.class);

    private final String regexpForPossiblePages = "(HOME)";

    @Given("^open page " + regexpForPossiblePages + "$")
    public void openPage(String pageName) {
        Page page = Page.valueOf(pageName);
        open(page.toString());
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
