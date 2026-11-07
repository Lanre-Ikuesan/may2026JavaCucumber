package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class homepage {

    public WebDriver driver;
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
        driver.findElement(By.className("login_logo")).isDisplayed();
        String logoText =  driver.findElement(By.className("login_logo")).getText();
        System.out.print(logoText);

    }

    @When("^i see the username and password field$")
    public void i_see_the_username_and_password_field() throws Throwable {
        driver.findElement(By.id("user-name")).isDisplayed();
        driver.findElement(By.name("password")).isDisplayed();

    }

    @Then("^I should see a login buttonj$")
    public void i_should_see_a_login_buttonj() throws Throwable {
        driver.findElement(By.id("login-button")).isDisplayed();
        driver.findElement(By.id("login-button")).isEnabled();

        driver.quit();
    }



}
