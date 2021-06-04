import pageobjects.CanvasPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CanvasRightClickTest extends TestBase {

    @Test
    public void CanvasRightClick() {
        CanvasPage canvasPage = new CanvasPage().open();
        canvasPage.rightClick();
        assertTrue(canvasPage.contextMenuDisplayed(), "Context menu is not opened");
    }
}

