package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
@Getter
public class MyAccountPage {

    @FindBy(css = "h1")
    private SelenideElement heading;

    @FindBy(className = "info-account")
    private SelenideElement accountInfo;

    @FindBy(className = "account")
    private SelenideElement account;

    @FindBy(className = "logout")
    private SelenideElement logout;

    public void accountWasCreatedSuccessfully() {

        heading.shouldHave(Condition.text("MY ACCOUNT"));
        accountInfo.shouldHave(Condition.text("Welcome to your account."));
        logout.shouldBe(Condition.visible);
        //TODO:figure out account validation
        //TODO:figure out account validation
        //assert(url().contains("controller=my-account"));
    }
}
