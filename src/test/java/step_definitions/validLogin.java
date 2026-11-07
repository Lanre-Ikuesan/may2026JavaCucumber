package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class validLogin {

    //This step launches your specified browser, maximize it and enter the application url that loads the home page
    public WebDriver driver;
    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

    }
      //enter your correct username
    @When("^I enter the correct username$")
    public void iEnterTheCorrectUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

    }

    @And("^I enter the correct password$")
    public void iEnterTheCorrectPassword() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

    }

    @When("^I click the login button$")
    public void iClickTheLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("^my login should be successful$")
    public void myLoginShouldBeSuccessful() {
    driver.findElement(By.className("shopping_cart_link")).isDisplayed();

    driver.quit();
    }

    @When("^I enter the \"([^\"]*)\"$")
    public void iEnterThe(String username) throws Throwable {
        driver.findElement(By.id("user-name")).sendKeys(username);

    }

    @And("^I type the \"([^\"]*)\"$")
    public void iTypeThe(String password) throws Throwable {
        driver.findElement(By.name("password")).sendKeys(password);

    }

    @Then("^I should get the correct \"([^\"]*)\"$")
    public void iShouldGetTheCorrect(String errorMessage) throws Throwable {
        String expectedErrorMesssage = errorMessage;
        String actualErrorMessage = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")).getText();
        Assert.assertEquals(expectedErrorMesssage, actualErrorMessage);
        System.out.println(actualErrorMessage);
    }
}
