package steps;

import com.google.gson.Gson;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entity.PersonProfile;
import helpers.ResourceLoader;
import pages.PageManager;

import java.util.Date;

import static java.lang.String.format;

public class AuthenticationPageSteps {

    private static final String profilePathFileMask = "users/%s.json";

    @When("^signIn with new account$")
    public void signinWithNewAccount() {
        //TODO: add dynamic email generation
        String timestamp = String.valueOf(new Date().getTime());
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
        PageManager.getAuthenticationPage().createAnAccount(email);
    }


    @And("^fill (\\w+) profile$")
    public void fillJohnProfile(String profileFileName) {
        String personProfile = ResourceLoader.getResourceAsString(format(profilePathFileMask, profileFileName));
        PersonProfile profile = new Gson().fromJson(personProfile, PersonProfile.class);
        PageManager.getAccountCreationPersonalInformation().fillPersonalInfo(profile);
    }


    @Then("^success sign in$")
    public void successLogin() {
        PageManager.getMyAccountPage().accountWasCreatedSuccessfully();
    }


}
