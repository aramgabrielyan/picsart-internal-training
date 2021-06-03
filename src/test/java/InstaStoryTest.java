import org.openqa.selenium.Cookie;
import org.testng.annotations.*;
import pageobjects.EditorPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.getDriver;

public class InstaStoryTest extends TestBase {


    @Test
    public void InstaStoryTest() {
        Cookie cookie1 = new Cookie("we-editor-first-open", "true");
        getDriver().manage().addCookie(cookie1);
        getDriver().navigate().refresh();
        EditorPage editorPage = new EditorPage();
        editorPage.clickInstaStory();
        editorPage.changeTab(1);
        editorPage.clickFitIcon();
        assertEquals(editorPage.getItemsCount(), 28, "Items count in editor");
        // editorPage.clickSticker();
        // assertTrue(editorPage.isMyStickersDisplayed());


    }
}
