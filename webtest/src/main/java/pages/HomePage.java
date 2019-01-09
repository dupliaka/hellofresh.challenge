package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pages.authentication.AuthenticationPage;
import pages.purchase.CataloguePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
@Getter
public class HomePage{
    @FindBy(className = "login")
    private SelenideElement signIn;

    @FindBy(linkText = "Woman")
    private SelenideElement womanFilter;

    public AuthenticationPage signIn(){
        signIn.click();
        return page(AuthenticationPage.class);
    }
    public CataloguePage getCatalog(String targetGroup){
        $(By.linkText(targetGroup)).click();
        return page(CataloguePage.class);
    }

}
