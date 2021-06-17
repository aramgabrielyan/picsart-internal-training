import base.TestBase;
import base.TestSignedOutBase;
import org.openqa.selenium.Cookie;
import org.testng.annotations.*;
import pageobjects.EditorPage;
import setup.DriverHelper;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class InstaStoryTest extends TestSignedOutBase {

    @Test
    public void InstaStoryTest() {
        EditorPage editorPage = new EditorPage().open();
        editorPage.clickInstaStory();
        editorPage.clickFitIcon();
        assertEquals(editorPage.getItemsCount(), 28, "Items count in editor");
    }
}
