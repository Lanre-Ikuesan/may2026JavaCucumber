package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class iframe_Prestashop {
    public WebDriver driver;
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
        driver.switchTo().frame("framelive");
        driver.findElement(By.xpath("//div[@id='_desktop_ps_contactinfo']")).isDisplayed();
        driver.findElement(By.xpath("//div[@id='_desktop_ps_languageselector']")).isDisplayed();
        driver.findElement(By.xpath("//div[@id='_desktop_ps_customersignin']")).isDisplayed();
        driver.findElement(By.id("_desktop_ps_shoppingcart")).isDisplayed();
        driver.switchTo().defaultContent();
    }
}
