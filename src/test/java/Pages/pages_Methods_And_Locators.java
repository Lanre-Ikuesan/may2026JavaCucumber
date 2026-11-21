package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static Base.TestBase.driver;

public class pages_Methods_And_Locators {
    public int random;

    //Declare your locators here homepage

    @FindBy(how = How.CLASS_NAME,using = ("login_logo"))
    public static WebElement login_logo;

    @FindBy(how = How.ID,using = ("user-name"))
    public static WebElement username;

    @FindBy(how = How.NAME, using = ("password"))
    public static WebElement password;

    @FindBy(how = How.ID,using = ("login-button"))
    public static WebElement loginButtonIsDisplayed;

    @FindBy(how = How.ID,using = ("login-button"))
    public static WebElement loginButtonIsEnabled;



    //declare your locators here iframe

    @FindBy (how = How.ID,using = "framelive")
    public static WebElement frameLive;

    @FindBy (how = How.XPATH,using ="//div[@id='_desktop_ps_contactinfo']")
    public static WebElement contactInfoLink;

    @FindBy (how = How.XPATH,using = "//*[@id='_desktop_ps_languageselector']")
    public static WebElement languageSelector;

    @FindBy (how = How.XPATH,using ="//div[@id='_desktop_ps_customersignin']")
    public static WebElement signIn;

    @FindBy (how = How.ID,using ="_desktop_ps_shoppingcart")
    public static WebElement shoppingCart;


    //Declare your methods homepage

    public void login_logo (){login_logo.isDisplayed();}
    public void username (){username.isDisplayed();}
    public void password (){password.isDisplayed();}
    public void loginbutton(){loginButtonIsDisplayed.isDisplayed();
        loginButtonIsEnabled.isEnabled();
    }

    //Declare your methods iframe

    public void switchToFrame (){driver.switchTo().frame(frameLive);}
    public void contactInfoLink() {contactInfoLink.click();}
    public void languageSelector() {languageSelector.click();}
    public void customerSignIn () {signIn.click();}
    public void setShoppingCart () {shoppingCart.click();}
}

