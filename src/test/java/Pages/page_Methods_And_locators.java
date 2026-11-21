package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class page_Methods_And_locators {
    public int random;

    // locators
    @FindBy(how = How.XPATH, using = "//input[@id='user-name']")
    public static WebElement userName;
    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    public static WebElement password;
    @FindBy(how = How.XPATH, using = "//input[@id='login-button']")
    public static WebElement loginButton;
    @FindBy(how = How.XPATH, using = "//a[@class='shopping_cart_link']")
    public static WebElement shoppingCard;
    @FindBy(how = How.XPATH, using = "//select[@class='product_sort_container']")
    public static WebElement dropdownfield;
    @FindBy(how = How.XPATH, using = "//a[@class='shopping_cart_link']")
    public static WebElement Option;
    @FindBy(how = How.XPATH, using = "//a[@id='item_3_title_link']")
    public static WebElement productSortAccordingly;

    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    public static WebElement correctPassword;
    @FindBy(how = How.XPATH, using = "//a[@class='shopping_cart_link']")
    public static WebElement successfullogin;
    @FindBy(how = How.XPATH, using = "//input[@id='user-name']")
    public static WebElement correctUserName;
    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    public static WebElement wrongPassword;
    @FindBy(how = How.XPATH, using = "//h3[@data-test='error']")
    public static WebElement loginErrorMessage;


    // methods

    public void inputUserNameAtHomepage() {userName.sendKeys("standard_user");}
    public void inputUserPasswordAtHomepage() {password.sendKeys("secret_sauce");}
    public void clickloginButtonAtHomePage() {loginButton.click();}

    public void locateTheShoppingCardAtHomePage() {shoppingCard.isDisplayed();}
    public void selectTheProductdropdown() {dropdownfield.isDisplayed();}
    public void selectTheSortOption() throws InterruptedException {
        Select dropdown = new Select(dropdownfield);dropdown.selectByIndex(2);
        Thread.sleep(4000);}


    public void iEnterTheCorrectUsername() {userName.sendKeys("standard_user");}
    public void iEnterTheCorrectPassword() {correctPassword.sendKeys("secret_sauce");}
    public void iClickTheLoginButton(){loginButton.click();}
    public void myLoginShouldBeSuccessful() {successfullogin.isDisplayed();

    }
    public void iEnterUsername(String username) {correctUserName.sendKeys(username);}
    public void iTypeThepassword(String password){wrongPassword.sendKeys(password);}
    public void iShouldGetTheCorrectErrMessage(String errorMessage) {
        String expectedErrorMesssage = errorMessage;
        String actualErrorMessage = loginErrorMessage.getText();
        Assert.assertEquals(expectedErrorMesssage, actualErrorMessage);
        System.out.println(actualErrorMessage);

    }

    public void theProductsShouldBeSortedAccordingly() {
        String  expectedTopListedProductAfterSorting = "Test.allTheThings() T-Shirt (Red)";
        String  ActualTopListedProductAfterSorting = productSortAccordingly.getText();
        Assert.assertEquals(ActualTopListedProductAfterSorting, expectedTopListedProductAfterSorting);
        System.out.println();
    }

}

