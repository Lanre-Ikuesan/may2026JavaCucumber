package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class pages_locators_And_Methods {
    public int random;

    //delcare your locators here

    @FindBy (how = How.XPATH, using = "//ul[@id='customer_menu_top']")
    public static WebElement login_registerLink;

    @FindBy (how = How.XPATH, using = "//button[@title= 'Continue']")
    public static WebElement CreateAcc_Continue;

    @FindBy (how = How.XPATH, using = "//input[@name= 'firstname']")
    public static WebElement firstNameField;

    @FindBy (how = How.XPATH, using = "//input[@name= 'lastname']")
    public static WebElement lastName;

    @FindBy (how = How.XPATH, using = "//div[@class= 'form-group ']//input[@name= 'email']")
    public static WebElement emailField;

    @FindBy (how = How.XPATH, using = "//input[@name= 'address_1']")
    public static WebElement addressLine1;

    @FindBy (how = How.XPATH, using = "//input[@name= 'city']")
    public static WebElement city;

    @FindBy (how = How.XPATH, using = "//Select[@name= 'country_id']")
    public static WebElement selectCountry;

    @FindBy (how = How.XPATH, using = "//Select[@name= 'zone_id']")
    public static WebElement region;

    @FindBy (how = How.XPATH, using = "//input[@name= 'postcode']")
    public static WebElement postCode;

    @FindBy (how = How.XPATH, using = "//input[@name= 'loginname']")
    public static WebElement loginName;

    @FindBy (how = How.XPATH, using = "//input[@name= 'password']")
    public static WebElement loginPassword;

    @FindBy (how = How.XPATH, using = "//input[@name= 'confirm']")
    public static WebElement confirmPassword;

    @FindBy (how = How.XPATH, using = "//input[@id= 'AccountFrm_newsletter0']")
    public static WebElement newsletterNo;

    @FindBy (how = How.XPATH, using = "//input[@id= 'AccountFrm_agree']")
    public static WebElement accountPrivacy;

    @FindBy (how = How.XPATH, using = "//div[@class='menu_text']")
    public static WebElement welcomeMessage;

    //Declare your methods

    public void clickloginRegisterLink() {
        login_registerLink.click();
    }

    public void clickContinueInLoginPage() {
        CreateAcc_Continue.click();
    }

    public void enterNewUserFirstName() {
        firstNameField.sendKeys("Testing");
    }

    public void enterNewUserLastName() {
        lastName.sendKeys("Automation");
    }

    public void enterNewUserEmail() {
        random = 100 + (int)(Math.random()*((1000 - 1) + 1));
        emailField.sendKeys("testing123" + random + "@testing.com");
    }

    public void enterNewUserAddress() {
        addressLine1.sendKeys("234 testing avenue");
    }

    public void enterNewUserCity() {
        city.sendKeys("Pohjois Karjaila");
    }

    public void selectNewUserCountry() {
        Select Country = new Select(selectCountry);
        Country.selectByVisibleText("Finland");
    }

    public void selectUserRegion() {
        Select Region = new Select(region);
        Region.selectByVisibleText("Etela-Suomen Laani");
    }

    public void enterNewUserPostCode() {
        postCode.sendKeys("32211");
    }

    public void enterNewUserLoginId() {
        loginName.sendKeys("DorisTest" + random);
    }

    public void enterNewUserLoginPassword() {
        loginPassword.sendKeys("testing123");
    }

    public void enterNewUseronfirmPass() {
        confirmPassword.sendKeys("testing123");
    }

    public void selectNewsletterOption() {
        newsletterNo.click();
    }

    public void selectPrivacyPolicy() {
        accountPrivacy.click();
    }

    public void assertWelcomeMessage() {
        String  expectedAccCreatedMessage = "Welcome back Testing";
        String  ActualAccCreatedMessage = welcomeMessage.getText();
        Assert.assertEquals(ActualAccCreatedMessage, expectedAccCreatedMessage);
        System.out.println();
    }

}
