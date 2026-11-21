package step_definitions;

import Base.TestBase;
import Pages.page_Methods_And_locators;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class saucedemo_common extends TestBase {

    @Before
    public void setup() throws IOException {
        initialize();
    }

    @Given("^i am on the saucedemo homepage$")
    public void iAmOnTheSaucedemoHomepage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(CONFIG.getProperty("Saucedemo_url"));
    }
}
