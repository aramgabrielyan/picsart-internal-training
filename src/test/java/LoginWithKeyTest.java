import org.openqa.selenium.Cookie;
import org.testng.annotations.*;
import pageobjects.BasePage;
import pageobjects.LoginPage;
import setup.DriverHelper;

import static org.testng.Assert.assertTrue;

public class LoginWithKeyTest {

    @BeforeTest
    public void setup() {
    }

    @AfterTest
    public void tearDown() {

    }

    @Test
    public void loginWithKeyTest() {
        LoginPage loginPage = new LoginPage();
        Cookie cookie = new Cookie("user_key", "a524635b-49f3-401d-8fe0-cd982a456ea8");
        DriverHelper.get().getDriver().manage().addCookie(new Cookie("OptanonAlertBoxClosed", "some_value"));
        DriverHelper.get().getDriver().manage().addCookie(new Cookie("we-editor-first-open", "true"));
        DriverHelper.get().getDriver().manage().addCookie(new Cookie("we-editor-photo-first-open", "true"));
        DriverHelper.get().getDriver().manage().addCookie(cookie);
        DriverHelper.get().getDriver().navigate().refresh();

        assertTrue(loginPage.isUserLoggedIn(), "User is logged in");
    }
}
