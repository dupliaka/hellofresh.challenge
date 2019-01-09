package steps;

import com.codeborne.selenide.Condition;
import com.google.gson.Gson;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entity.PersonProfile;
import helpers.ResourceLoader;
import pages.MyAccountPage;
import pages.authentication.AccountCreationPersonalInformationPage;
import pages.authentication.AuthenticationPage;

import java.util.Date;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.url;
import static java.lang.String.format;
import static junit.framework.TestCase.assertTrue;

public class AuthenticationPageSteps {

    private static final MyAccountPage myAccountPage = page(MyAccountPage.class);
    private static final AuthenticationPage authenticationPage = page(AuthenticationPage.class);
    private static final AccountCreationPersonalInformationPage accountCreationPersonalInformationPage = page(AccountCreationPersonalInformationPage.class);
    private static final String profilePathFileMask = "users/%s.json";

    @When("^signIn with new account$")
    public void signinWithNewAccount() {
        //TODO: add dynamic email generation
        String timestamp = String.valueOf(new Date().getTime());
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
        authenticationPage.createAnAccount(email);
    }

    @When("^signIn as (\\w+)")
    public void signAs(String profile) {
        PersonProfile personProfile = getProfile(profile);
        authenticationPage.login(personProfile.getEmail(), personProfile.getPassword());
    }

    @And("^fill (\\w+) profile$")
    public void fillJohnProfile(String profileFileName) {
        PersonProfile profile =  getProfile(profileFileName);
        accountCreationPersonalInformationPage.fillPersonalInfo(profile);
    }

    @Then("^success sign in with (\\w+) profile$")
    public void successLogin(String profileName) {
        PersonProfile personProfile = getProfile(profileName);

        myAccountPage.getHeading().shouldHave(Condition.text("MY ACCOUNT"));
        myAccountPage.getAccountInfo().shouldHave(Condition.text("Welcome to your account."));
        myAccountPage.getLogout().shouldBe(Condition.visible);
        myAccountPage.getAccount().shouldHave(text(personProfile.getFirstName()+" "+ personProfile.getLastName()));
        assertTrue(url().matches("(.*)controller=my-account"));
    }

    private PersonProfile getProfile(String profileFileName){
        String personProfile = ResourceLoader.getResourceAsString(format(profilePathFileMask, profileFileName));
        return new Gson().fromJson(personProfile, PersonProfile.class);
    }

}
