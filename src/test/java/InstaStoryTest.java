import helpers.WaitHelper;
import org.openqa.selenium.Cookie;
import org.testng.annotations.*;
import pageobjects.EditorPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.driver;
import static setup.DriverSetup.getDriver;

public class InstaStoryTest {

    @BeforeMethod
    public void setup(){
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void InstaStoryTest() {
        EditorPage editorPage = new EditorPage().open();
        getDriver().manage().addCookie(new Cookie("we-editor-first-open", "true"));
        getDriver().manage().addCookie(new Cookie("OptanonAlertBoxClosed", "some_value"));
        getDriver().navigate().refresh();
        editorPage.clickInstaStory();
        editorPage.changeTab(1);
        editorPage = editorPage.init();
        editorPage.clickFitIcon();
        assertEquals(editorPage.getItemsCount(), 28, "Items count in editor");
        // editorPage.clickSticker();
        // assertTrue(editorPage.isMyStickersDisplayed());


    }
}
