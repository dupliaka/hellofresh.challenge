package steps;

import cucumber.api.java.en.And;
import pages.PageManager;


public class HomePageSteps {
    @And("^start signing in$")
    public void startSigning() {
        PageManager.getHomePage().signIn();
    }

}
