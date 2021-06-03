import pageobjects.CanvasPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CanvasRightClickTest extends TestBase {

    @Test
    public void CanvasRightClick() throws InterruptedException {
        CanvasPage canvasPage = new CanvasPage();
        Thread.sleep(4000);
        canvasPage.rightClick();
        assertTrue(canvasPage.contextMenuDisplayed(), "Context menu is not opened");
    }
}

