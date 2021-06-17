package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage<LoginPage> {

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

    @Override
    public LoginPage open() {
        return openPage();
    }

    public LoginPage init(){
        return initPage();
    }

    @Override
    public String getUrl() {
        return "";

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
}
