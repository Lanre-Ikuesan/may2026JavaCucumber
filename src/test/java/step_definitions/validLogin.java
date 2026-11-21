package step_definitions;

import Base.TestBase;
import Pages.page_Methods_And_locators;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.PageFactory;

public class validLogin extends TestBase {
    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() {
        page_Methods_And_locators pages = PageFactory.initElements(driver, page_Methods_And_locators.class);
        WebDriverManager.chromedriver().setup();}
    @When("^I enter the correct username$")
    public void iEnterTheCorrectUsername() {
        page_Methods_And_locators pages = PageFactory.initElements(driver, page_Methods_And_locators.class);
        pages.iEnterTheCorrectUsername();}
    @And("^I enter the correct password$")
    public void iEnterTheCorrectPassword() {
        page_Methods_And_locators pages = PageFactory.initElements(driver, page_Methods_And_locators.class);
        pages.iEnterTheCorrectPassword();}
    @When("^I click the login button$")
    public void iClickTheLoginButton() {
        page_Methods_And_locators pages = PageFactory.initElements(driver, page_Methods_And_locators.class);
        pages.iClickTheLoginButton();}
    @Then("^my login should be successful$")
    public void myLoginShouldBeSuccessful() {
        page_Methods_And_locators pages = PageFactory.initElements(driver, page_Methods_And_locators.class);
        pages.myLoginShouldBeSuccessful();}
    @When("^I enter the \"([^\"]*)\"$")
    public void iEnterThe(String username) throws Throwable {
        page_Methods_And_locators pages = PageFactory.initElements(driver, page_Methods_And_locators.class);
        pages.iEnterUsername(username);}
    @And("^I type the \"([^\"]*)\"$")
    public void iTypeThe(String password) throws Throwable {
        page_Methods_And_locators pages = PageFactory.initElements(driver, page_Methods_And_locators.class);
        pages.iTypeThepassword(password);}
    @Then("^I should get the correct \"([^\"]*)\"$")
    public void iShouldGetTheCorrect(String errorMessage) throws Throwable {
        page_Methods_And_locators pages = PageFactory.initElements(driver, page_Methods_And_locators.class);
        pages.iShouldGetTheCorrectErrMessage(errorMessage);}
}
