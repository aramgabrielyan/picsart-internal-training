import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private final By usernameFieldLocation = By.name("username");
    private final By passwordFieldLocation = By.name("password");
    private final By loginButtonLocation = By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']");
    private final By signInButtonLocation = By.cssSelector("[class*='pa-uiLib-authentication-btn primary']");
    private final By avatarLocation = By.className("pa-uiLib-headerProfileInfo-avatarBlock");

    public LoginPage() {
        open("https://picsartstage2.com/");
    }

    public void clickLoginButton(){
        click(loginButtonLocation);
        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(usernameFieldLocation));
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
        WebElement avatarIcon = new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfElementLocated(avatarLocation));
        return avatarIcon.isDisplayed();
    }


    @Override
    public String getUrl() {
        return BASE_URL;

    }
}
