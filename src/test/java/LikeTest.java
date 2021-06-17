import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.BasePage;
import pageobjects.UserPage;
import setup.DriverHelper;

import static org.testng.Assert.assertTrue;

public class LikeTest {

    @BeforeTest
    public void setup() {
    }

    @AfterTest
    public void tearDown() {

    }

    @Test
    public void likeTest() {
        UserPage userPage = new UserPage();
      //  userPage.open(driver);
        Cookie cookieKey = new Cookie("user_key", "a524635b-49f3-401d-8fe0-cd982a456ea8");
        Cookie cookieSid = new Cookie("sid", "s%3AS0vB_oUQHKdOX0MWenwCu0I1GOcHqQA6.vBG1FBd2k4L66jDa6KVPS1zbVzVFDB2RXHgD5%2F257K8");
        DriverHelper.get().getDriver().manage().addCookie(new Cookie("OptanonAlertBoxClosed", "some_value"));
        DriverHelper.get().getDriver().manage().addCookie(new Cookie("we-editor-first-open", "true"));
        DriverHelper.get().getDriver().manage().addCookie(new Cookie("we-editor-photo-first-open", "true"));
        DriverHelper.get().getDriver().manage().addCookie(cookieKey);
        DriverHelper.get().getDriver().manage().addCookie(cookieSid);
        DriverHelper.get().getDriver().navigate().refresh();
        userPage.moveToImage();
        if(!userPage.isImageLiked()){
            userPage.moveToLikeButton();
        }
        assertTrue(userPage.isImageLiked(), "Image is not liked");
    }
}

