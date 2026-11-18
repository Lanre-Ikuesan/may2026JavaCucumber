package step_definitions;

import Base.TestBase;
import Pages.page_Methods_And_locators;
import Pages.pages_locators_And_Methods;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class sortProduct extends TestBase {

    @Given("^i am logged in to the sauce demo app$")
    public void iAmLoggedInToTheSauceDemoApp() {
        page_Methods_And_locators pages = PageFactory.initElements(driver, page_Methods_And_locators.class);
        pages.iEnterTheCorrectUsername();
        pages.iEnterTheCorrectPassword();
        pages.clickloginButtonAtHomePage();
        pages.locateTheShoppingCardAtHomePage();}

    @When("^i locate the sort dropdown field$")
    public void iLocateTheSortDropdownField() {
        page_Methods_And_locators pages = PageFactory.initElements(driver, page_Methods_And_locators.class);
        pages.selectTheProductdropdown();}

    @And("^i choose the sort option$")
    public void iChooseTheSortOption() throws InterruptedException {
        page_Methods_And_locators pages = PageFactory.initElements(driver, page_Methods_And_locators.class);
        pages.selectTheSortOption();}

    @Then("^the products should be sorted accordingly$")
    public void theProductsShouldBeSortedAccordingly() {
        page_Methods_And_locators pages = PageFactory.initElements(driver, page_Methods_And_locators.class);
        pages.theProductsShouldBeSortedAccordingly();}
}
