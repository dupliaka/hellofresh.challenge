package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import pages.authentication.AuthenticationPage;

import static com.codeborne.selenide.Selenide.page;

public class HomePage{
    @FindBy(className = "login")
    private SelenideElement signIn;

    public AuthenticationPage signIn(){
        signIn.click();
        return page(AuthenticationPage.class);
    }

}
