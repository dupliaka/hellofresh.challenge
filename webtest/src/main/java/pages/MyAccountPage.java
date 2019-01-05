package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage {

    @FindBy(css = "h1")
    private SelenideElement heading;

    @FindBy(className = "info-account")
    private SelenideElement accouuntInfo;

    @FindBy(className = "logout")
    private SelenideElement logout;

    public void accountWasCreatedSuccessfully() {

        heading.shouldHave(Condition.hasText("MY ACCOUNT"));
        accouuntInfo.shouldHave(Condition.hasText("Welcome to your account."));
        logout.shouldBe(Condition.visible);
        //TODO:figure out account validation
        //TODO:figure out account validation
        //assert(url().contains("controller=my-account"));
    }
}
