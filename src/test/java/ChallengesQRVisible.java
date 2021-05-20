import org.openqa.selenium.Cookie;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.getDriver;

public class ChallengesQRVisible {

    @BeforeMethod
    public void setup() {
        LoginPage loginPage = new LoginPage();
        Cookie cookie = new Cookie("user_key", "a524635b-49f3-401d-8fe0-cd982a456ea8");
        Cookie cookie1 = new Cookie("we-editor-first-open", "true");
        getDriver().manage().addCookie(cookie);
        getDriver().manage().addCookie(cookie1);
        getDriver().navigate().refresh();
        assertTrue(loginPage.isUserLoggedIn(), "User does not logged in");
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    @Test
    public void challengesTest() {
        ChallengePage challengePage = new ChallengePage();
        challengePage.goToDiscoveryBttn();
        challengePage.challengesClick();
        challengePage.selectChallenge();
        challengePage.participateClick();
        challengePage.qrCodeIsVisible();
        assertTrue(challengePage.qrCodeIsVisible(), "QR Code was not appeared");
    }
}
