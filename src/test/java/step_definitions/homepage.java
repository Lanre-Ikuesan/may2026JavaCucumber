package step_definitions;

import Base.TestBase;
import Pages.pages_Methods_And_Locators;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class homepage extends TestBase {


    @Given("^I have launched my browser$")
    public void i_have_launched_my_browser() throws Throwable {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
     }

    @When("^I enter the application url$")
    public void i_enter_the_application_url() throws Throwable {
    driver.navigate().to("https://www.saucedemo.com/");

    }

    @When("^I see the application logo$")
    public void i_see_the_application_logo() throws Throwable {
        pages_Methods_And_Locators pages = PageFactory.initElements(driver, pages_Methods_And_Locators.class);
        pages.login_logo();
        
    }

    @When("^i see the username and password field$")
    public void i_see_the_username_and_password_field() throws Throwable {
        pages_Methods_And_Locators pages = PageFactory.initElements(driver, pages_Methods_And_Locators.class);
        pages.username();
        pages.password();

    }
    @Then("^I should see a login buttonj$")
    public void i_should_see_a_login_buttonj() throws Throwable {
        pages_Methods_And_Locators pages = PageFactory.initElements(driver, pages_Methods_And_Locators.class);
        pages.loginbutton();

    }
}
