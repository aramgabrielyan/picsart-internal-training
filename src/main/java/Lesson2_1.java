import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lesson2_1 {


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://picsartstage2.com/");
        WebElement loginButton = driver.findElement(By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']"));
        loginButton.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.name("username"))));
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("smart_offer");
        WebElement signInButton = driver.findElement(By.cssSelector("[class*='pa-uiLib-authentication-btn primary']"));
        boolean isDisabled = signInButton.getAttribute("class").contains("pa-uiLib-authentication-button-disabled");
        if (isDisabled) {
            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys("Lusin86");
            signInButton.click();
        }
        driver.quit();
    }
}
