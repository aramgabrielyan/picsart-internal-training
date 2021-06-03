import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private  WebDriver driver;

    private By usernameFieldLocation = By.name("username");
    private By passwordFieldLocation = By.name("password");
    private By loginButtonLocation = By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']");
    private By signInButtonLocation = By.cssSelector("[class*='pa-uiLib-authentication-btn primary']");
    private final By loginPopUp = By.cssSelector("[class|='modal']");

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton(){
        WebElement loginButton = driver.findElement(loginButtonLocation);
        loginButton.click();
        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(usernameFieldLocation));

    }

    public void typeUsername(String username){
        WebElement usernameField = driver.findElement(usernameFieldLocation);
        usernameField.sendKeys(username);
    }

    public void typePassword(String password){
        WebElement passwordField = driver.findElement(passwordFieldLocation);
        passwordField.sendKeys(password);
    }

    public void clickSignInButton(){
        WebElement signInButton = driver.findElement(signInButtonLocation);
        signInButton.click();
    }

    public boolean isPopUpDisplayed(){
        return driver.findElement(loginPopUp).isDisplayed();
    }






}
