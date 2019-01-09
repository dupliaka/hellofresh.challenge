package steps;

import cucumber.api.java.en.And;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.page;


public class HomePageSteps {

    HomePage home = page(HomePage.class);

    @And("^start signing in$")
    public void startSigning() {
        home.signIn();
    }

    @And("^open catalog for (\\w+)$")
    public void passPurchaseSteps(String targetGroupFilter){
        home.getCatalog(targetGroupFilter)
        ;
    }
}
