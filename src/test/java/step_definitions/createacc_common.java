package step_definitions;

import Base.TestBase;
import Pages.pages_locators_And_Methods;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class createacc_common extends TestBase {

    @Before
    public void setup() throws IOException {
        initialize();
    }

    @Given("^I am on the application homepage$")
    public void iAmOnTheApplicationHomepage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(CONFIG.getProperty("uat_url"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
 //step to click the register button on the home page
    @When("^I click the login/register button$")
    public void iClickTheLoginRegisterButton() {
        pages_locators_And_Methods pages = PageFactory.initElements(driver, pages_locators_And_Methods.class);
        pages.clickloginRegisterLink();}
}
