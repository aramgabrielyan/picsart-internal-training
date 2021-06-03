import org.openqa.selenium.Cookie;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;
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
        LoginPage loginPage = new LoginPage();
        Cookie cookie = new Cookie("user_key", "a524635b-49f3-401d-8fe0-cd982a456ea8");
        getDriver().manage().addCookie(cookie);
        getDriver().navigate().refresh();

        assertTrue(loginPage.isUserLoggedIn(), "User is logged in");
    }
}
