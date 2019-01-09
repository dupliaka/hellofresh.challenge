package pages.authentication;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import pages.MyAccountPage;

import static com.codeborne.selenide.Selenide.page;

public class AuthenticationPage {

    @FindBy(id = "email_create")
    private SelenideElement emailInput;

    @FindBy(id = "SubmitCreate")
    private SelenideElement emailSubmit;

    @FindBy(id = "email")
    private SelenideElement emailIn;

    @FindBy(id = "passwd")
    private SelenideElement passwordIn;

    @FindBy(id = "SubmitLogin")
    private SelenideElement submitLoginBtn;

    public AccountCreationPersonalInformationPage createAnAccount(String email) {
        emailInput.sendKeys(email);
        emailSubmit.click();
        return page(AccountCreationPersonalInformationPage.class);
    }

    public MyAccountPage login(String username, String password) {
        emailIn.sendKeys(username);
        passwordIn.sendKeys(password);
        submitLoginBtn.click();
        return page(MyAccountPage.class);
    }


}
