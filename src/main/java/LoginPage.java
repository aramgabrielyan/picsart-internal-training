import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By usernameFieldLocation = By.name("username");
    private final By passwordFieldLocation = By.name("password");
    private final By loginButtonLocation = By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']");
    private final By signInButtonLocation = By.cssSelector("[class*='pa-uiLib-authentication-btn primary']");
    private final By avatarLocation = By.className("pa-uiLib-headerProfileInfo-avatarBlock");

    public LoginPage() {
        open("https://picsart.com/");
    }

    public void clickLoginButton(){
        click(loginButtonLocation);
        WaitHelper.getInstance().waitForElementDisplayed(usernameFieldLocation);
    }

    public void typeUsername(String username){
        type(usernameFieldLocation, username);
    }

    public void typePassword(String password) {
        type(passwordFieldLocation, password);
    }

    public void clickSignInButton(){
        click(signInButtonLocation);
    }

    public boolean isUserLoggedIn(){
        WaitHelper.getInstance().waitForElementDisplayed(avatarLocation);
        return isDisplayed(avatarLocation);
    }


    @Override
    public String getUrl() {
        return BASE_URL;

    }
}
