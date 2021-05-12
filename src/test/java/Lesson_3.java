
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Lesson_3 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://picsartstage2.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void firstTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.typeUsername("smart_offer");
        loginPage.typePassword("Lusin86");
        loginPage.clickSignInButton();
        assertTrue(loginPage.isUserLoggedIn(), "User was not logged in");

    }

}

