import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class Homework_3 {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/Users/aramgabrielyan/IdeaProjects/picsart-internal-training/src/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://picsartstage2.com/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void falseLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.typeUsername("fakelogin");
        loginPage.typePassword("fakepassword");
        loginPage.clickSignInButton();
        assertTrue(loginPage.isSuccess(), "User is logged in");
    }
}
