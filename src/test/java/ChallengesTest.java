import org.testng.annotations.Test;
import pageobjects.ChallengePage;

import static org.testng.Assert.assertTrue;

public class ChallengesTest  {

    @Test
    public void challengesTest() {
        ChallengePage challengePage = new ChallengePage().open();
        challengePage.goToDiscoverButton();
        challengePage.challengesClick();
        challengePage.selectChallenge();
        challengePage.participateClick();

        assertTrue(challengePage.qrCodeIsVisible(), "QR Code was not appeared");
    }
}

