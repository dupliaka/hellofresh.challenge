package pages.authentication;

import com.codeborne.selenide.SelenideElement;
import entity.PersonProfile;
import org.openqa.selenium.support.FindBy;
import pages.MyAccountPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AccountCreationPersonalInformationPage {

    @FindBy(id = "id_gender1")
    private SelenideElement maleGender;

    @FindBy(id = "id_gender2")
    private SelenideElement femaleGender;

    @FindBy(id = "customer_firstname")
    private SelenideElement firstName;

    @FindBy(id = "customer_lastname")
    private SelenideElement lastName;

    @FindBy(id = "passwd")
    private SelenideElement password;

    @FindBy(id = "days")
    private SelenideElement days;

    @FindBy(id = "months")
    private SelenideElement months;

    @FindBy(id = "years")
    private SelenideElement years;

    @FindBy(id = "firstname")
    private SelenideElement adressFirstName;

    @FindBy(id = "lastname")
    private SelenideElement adressLastName;

    @FindBy(id = "company")
    private SelenideElement company;

    @FindBy(id = "id_country")
    private SelenideElement country;

    @FindBy(id = "address1")
    private SelenideElement address1;

    @FindBy(id = "address2")
    private SelenideElement address2;

    @FindBy(id = "city")
    private SelenideElement city;

    @FindBy(id = "id_state")
    private SelenideElement stateId;

    @FindBy(id = "postcode")
    private SelenideElement postcode;

    @FindBy(id = "other")
    private SelenideElement other;

    @FindBy(id = "phone")
    private SelenideElement phone;

    @FindBy(id = "phone_mobile")
    private SelenideElement phoneMobile;

    @FindBy(id = "alias")
    private SelenideElement alias;

    @FindBy(id = "submitAccount")
    private SelenideElement submitAccount;


    public void chooseGender(String elementId) {
        switch (elementId) {
            case "female":
                $(femaleGender).click();
                break;
            case "male":
                $(maleGender).click();
                break;
            default:
                throw new IllegalStateException("Gender undefined");
        }
    }



    public MyAccountPage fillPersonalInfo(PersonProfile profile) {

        if (profile == null) throw new IllegalStateException("profile is null");

        chooseGender(profile.getGender());
        chooseCustomerFirstName(profile.getFirstName());
        lastName.sendKeys(profile.getLastName());
        password.sendKeys(profile.getPassword());
        days.sendKeys(profile.getDob().getDay());
        months.sendKeys(profile.getDob().getMonth());
        years.sendKeys(profile.getDob().getYear());
        company.sendKeys(profile.getCompany());
        address1.sendKeys(profile.getAddress1());
        address2.sendKeys(profile.getAddress2());
        city.sendKeys(profile.getCity());
        country.selectOption(profile.getCountry());
        stateId.selectOption(profile.getStateId());
        postcode.sendKeys(profile.getPostcode());
        other.sendKeys(profile.getOther());
        phone.sendKeys(profile.getPhone());
        phoneMobile.sendKeys(profile.getPhoneMobile());
        alias.sendKeys(profile.getAlias());
        submitAccount.click();

        //TODO: add customer email, first and last name set
        return page(MyAccountPage.class);
    }

    private void chooseCustomerFirstName(String proFirstName) {
        firstName.sendKeys(proFirstName);
    }

}
