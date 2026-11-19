package step_definitions;

import Base.TestBase;
import Pages.pages_Methods_And_Locators;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


 public class iframe_Prestashop extends TestBase{

    @Given("^I am on the prestashop home page$")
    public void iAmOnThePrestashopHomePage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.prestashop.com/#/en/front");
        Thread.sleep(10000);
    }

    @Then("^I should see the header buttons displayed correctly$")
    public void iShouldSeeTheHeaderButtonsDisplayedCorrectly() {
        pages_Methods_And_Locators pages = PageFactory.initElements(driver, pages_Methods_And_Locators.class);
        pages.switchToFrame();
        pages.contactInfoLink();
        pages.languageSelector();
        pages.customerSignIn();
        pages.setShoppingCart();

}

 }
