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
import org.openqa.selenium.support.ui.Select;

public class sortProduct {
    public WebDriver driver;
    @Given("^i am logged in to the sauce demo app$")
    public void iAmLoggedInToTheSauceDemoApp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.className("shopping_cart_link")).isDisplayed();
    }

    @When("^i locate the sort dropdown field$")
    public void iLocateTheSortDropdownField() {
        driver.findElement(By.className("product_sort_container")).isDisplayed();
    }

    @And("^i choose the sort option$")
    public void iChooseTheSortOption() throws InterruptedException {
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
                dropdown.selectByIndex(2);
                Thread.sleep(4000);
    }

    @Then("^the products should be sorted accordingly$")
    public void theProductsShouldBeSortedAccordingly() {
      String  expectedTopListedProductAfterSorting = "Test.allTheThings() T-Shirt (Red)";
      String  ActualTopListedProductAfterSorting = driver.findElement(By.id("item_3_title_link")).getText();
        Assert.assertEquals(ActualTopListedProductAfterSorting, expectedTopListedProductAfterSorting);
        System.out.println();
    }
}
