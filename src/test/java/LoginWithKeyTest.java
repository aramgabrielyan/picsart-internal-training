import org.openqa.selenium.Cookie;
import org.testng.annotations.*;
import pageobjects.LoginPage;

import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.driver;
import static setup.DriverSetup.getDriver;

public class LoginWithKeyTest {

    @BeforeTest
    public void setup() {
    }

    @AfterTest
    public void tearDown() {
        getDriver().quit();
    }

    @Test
    public void loginWithKeyTest() {
        LoginPage loginPage = new LoginPage(driver);
        Cookie cookie = new Cookie("user_key", "a524635b-49f3-401d-8fe0-cd982a456ea8");
        getDriver().manage().addCookie(new Cookie("OptanonAlertBoxClosed", "some_value"));
        getDriver().manage().addCookie(new Cookie("we-editor-first-open", "true"));
        getDriver().manage().addCookie(new Cookie("we-editor-photo-first-open", "true"));
        getDriver().manage().addCookie(cookie);
        getDriver().navigate().refresh();

        assertTrue(loginPage.isUserLoggedIn(), "User is logged in");
    }
}
