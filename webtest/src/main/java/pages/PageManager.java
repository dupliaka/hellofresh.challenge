package pages;


import pages.authentication.AccountCreationPersonalInformationPage;
import pages.authentication.AuthenticationPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.page;

public class PageManager {
    private static Logger log = LoggerFactory.getLogger(PageManager.class);

    private static final HomePage homePage = page(HomePage.class);
    private static final AuthenticationPage authenticationPage = page(AuthenticationPage.class);

    public static MyAccountPage getMyAccountPage() {
        return myAccountPage;
    }

    private static final MyAccountPage myAccountPage = page(MyAccountPage.class);

    public static AccountCreationPersonalInformationPage getAccountCreationPersonalInformation() {
        return accountCreationPersonalInformation;
    }

    private static final AccountCreationPersonalInformationPage accountCreationPersonalInformation = page(AccountCreationPersonalInformationPage.class);

    public static HomePage getHomePage() {
        return homePage;
    }

    public static AuthenticationPage getAuthenticationPage() {
        return authenticationPage;
    }

}
