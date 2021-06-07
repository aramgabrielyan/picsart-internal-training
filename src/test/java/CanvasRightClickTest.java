import helpers.WaitHelper;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.CanvasPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CanvasRightClickTest extends TestBase {

    @Test
    public void CanvasRightClick() {
        CanvasPage canvasPage = new CanvasPage().open();
        WaitHelper waitHelper = new WaitHelper();
        waitHelper.waitForPageReady();
        canvasPage.rightClick();
        assertTrue(canvasPage.contextMenuDisplayed(), "Context menu is not opened");
    }
}

