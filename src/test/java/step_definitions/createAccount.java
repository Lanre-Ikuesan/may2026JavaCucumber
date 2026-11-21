package step_definitions;

import Base.TestBase;
import Pages.pages_locators_And_Methods;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class createAccount extends TestBase {


    @And("^I click button to continue$")
    public void iClickButtonToContinue() {
        pages_locators_And_Methods pages = PageFactory.initElements(driver, pages_locators_And_Methods.class);
        pages.clickContinueInLoginPage();
    }

    @When("^I enter all the required data$")
    public void iEnterAllTheRequiredData() throws InterruptedException {
        pages_locators_And_Methods pages = PageFactory.initElements(driver, pages_locators_And_Methods.class);
        pages.enterNewUserFirstName();
        pages.enterNewUserLastName();
        pages.enterNewUserEmail();
        pages.enterNewUserAddress();
        pages.enterNewUserCity();
        pages.selectNewUserCountry();
        pages.selectUserRegion();
        pages.enterNewUserPostCode();
        pages.enterNewUserLoginId();
        pages.enterNewUserLoginPassword();
        pages.enterNewUseronfirmPass();
        pages.selectNewsletterOption();
    }

    @And("^I agree to privacy policy$")
    public void iAgreeToPrivacyPolicy() {
        pages_locators_And_Methods pages = PageFactory.initElements(driver, pages_locators_And_Methods.class);
        pages.selectPrivacyPolicy();
    }

    @When("^I click on continue button$")
    public void iClickOnContinueButton() {
        pages_locators_And_Methods pages = PageFactory.initElements(driver, pages_locators_And_Methods.class);
        pages.clickContinueInLoginPage();
    }

    @Then("^my new account should be created$")
    public void myNewAccountShouldBeCreated() {
        pages_locators_And_Methods pages = PageFactory.initElements(driver, pages_locators_And_Methods.class);
        pages.assertWelcomeMessage();
    }
}
