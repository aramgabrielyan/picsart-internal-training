import org.testng.annotations.Test;
import pageobjects.ChallengePage;

import static org.testng.Assert.assertTrue;

public class ChallengesTest extends TestBase {

    @Test
    public void challengesTest() {
        ChallengePage challengePage = new ChallengePage();
        challengePage.goToDiscoveryButton();
        challengePage.challengesClick();
        challengePage.selectChallenge();
        challengePage.participateClick();
        challengePage.qrCodeIsVisible();
        assertTrue(challengePage.qrCodeIsVisible(), "QR Code was not appeared");
    }
}

