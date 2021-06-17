import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import setup.DriverHelper;

import static org.testng.Assert.assertTrue;


public class FakeLoginTest {

    @BeforeMethod
    public void setup(){
    }

    @AfterMethod
    public void tearDown(){
    }

    @Test
    public void falseLoginTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.clickLoginButton();
        loginPage.typeUsername("fakelogin");
        loginPage.typePassword("fakepassword");
        loginPage.clickSignInButton();
        assertTrue(loginPage.isPopUpDisplayed(), "User is logged in");
    }

}
