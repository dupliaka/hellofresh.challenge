package pages.purchase;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class OrderConfirmationPage {

    @FindBy(css = "h1")
    private SelenideElement heading;

    @FindBy(xpath = "//li[@class='step_done step_done_last four']")
    private SelenideElement doneStep;

    @FindBy(xpath = "//li[@id='step_end' and @class='step_current last']")
    private SelenideElement currentStep;

    @FindBy(xpath = "//*[@class='cheque-indent']/strong")
    private SelenideElement orderConfirmMessage;

}
