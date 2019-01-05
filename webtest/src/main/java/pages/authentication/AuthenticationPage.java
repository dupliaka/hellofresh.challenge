package pages.authentication;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class AuthenticationPage {

    @FindBy(id = "email_create")
    private SelenideElement emailInput;

    @FindBy(id = "SubmitCreate")
    private SelenideElement emailSubmit;

    public AccountCreationPersonalInformationPage createAnAccount(String email) {
        emailInput.sendKeys(email);
        emailSubmit.click();
        return page(AccountCreationPersonalInformationPage.class);
    }


}
