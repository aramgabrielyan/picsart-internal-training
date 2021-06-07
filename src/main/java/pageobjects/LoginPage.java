package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static setup.DriverSetup.getDriver;

public class LoginPage extends BasePage {

    @FindBy (name = "username")
    private WebElement usernameField;
    @FindBy (name = "password")
    private WebElement passwordField;
    @FindBy (css = "[data-test*='headerAuth-signInBtn']")
    private WebElement loginButton;
    @FindBy (css = "[class*='pa-uiLib-authentication-btn primary']")
    private WebElement signInButton;
    @FindBy (css = "pa-uiLib-headerProfileInfo-avatarBlock")
    private WebElement avatar;
    @FindBy (css = "[class*='pa-uiLib-modal-modalContent']")
    private WebElement loginPopUp;

    //[class*='pa-uiLib-modal-modalContent']

    public LoginPage(WebDriver driver){
        open("https://picsart.com");
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
        type(passwordField, password);
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
