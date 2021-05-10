import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lesson2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://picsartstage2.com/");
        WebElement signUpButton = driver.findElement(By.cssSelector("[data-test='headerAuth-signUpBtn pa-uiLib-headerAuth-authBtn']"));
        if (signUpButton.isEnabled()) {
            signUpButton.click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.name("email"))));
            WebElement userNameField = driver.findElement(By.name("email"));
            WebElement passwordField = driver.findElement(By.name("password"));
            WebElement createAccountBttn = driver.findElement(By.cssSelector("[type='submit']"));
            userNameField.sendKeys("testuser@testuser.com");
            passwordField.sendKeys("TUewq99!g@");
            createAccountBttn.click();
            WebElement element = driver.findElement(By.cssSelector(".pa-uiLib-authentication-banner-header"));
            if (element.isDisplayed()){
                System.out.println("User has not been registered!");
            } else {
                System.out.println("User has been registered!");
            }
        }else {
            System.out.println("Sign Up Button is Disabled");
        }
        driver.quit();
    }
}
