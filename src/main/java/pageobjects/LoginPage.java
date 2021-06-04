package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static setup.DriverSetup.getDriver;

public class LoginPage extends BasePage {

    @FindBy (css = "username")
    private WebElement usernameField;
    @FindBy (css = "password")
    private WebElement passwordField;
    @FindBy (css = "[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']")
    private WebElement loginButton;
    @FindBy (css = "[class*='pa-uiLib-authentication-btn primary']")
    private WebElement signInButton;
    @FindBy (css = "pa-uiLib-headerProfileInfo-avatarBlock")
    private WebElement avatar;
    @FindBy (css = "[class|='modal']")
    private WebElement loginPopUp;

    public LoginPage(WebDriver driver){
        open("https://picsart.com/");
        PageFactory.initElements(getDriver(), this);
    }

    public LoginPage init(){
        PageFactory.initElements(getDriver(), this);
        return this;
    }


    public void clickLoginButton(){
        init();
        click(loginButton);
        //new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(usernameField));
    }

    public void typeUsername(String username){
        type(usernameField, username);
    }

    public void typePassword(String password) {
        type(usernameField, password);
    }

    public void clickSignInButton(){
        init();
        click(signInButton);
    }

    public boolean isUserLoggedIn(){
        //WebElement avatarIcon = new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfElementLocated(avatar));
        return avatar.isDisplayed();
    }
    public boolean isPopUpDisplayed(){
        return loginPopUp.isDisplayed();
    }

    @Override
    public String getUrl() {
        return BasePage.BASE_URL;

    }
}
