import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.driver;

public class FakeLoginTest {

    @BeforeMethod
    public void setup(){
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
        assertTrue(loginPage.isPopUpDisplayed(), "User is logged in");
    }

}
