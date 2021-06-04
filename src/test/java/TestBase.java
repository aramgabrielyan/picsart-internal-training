
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import helpers.ApiHelper;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.BasePage;


import java.io.IOException;

import static setup.DriverSetup.getDriver;

public class TestBase {

    protected String key;

    @BeforeMethod
    public void setup() throws IOException {
        getDriver().get(BasePage.BASE_URL);
        JsonObject user = ApiHelper.createUser();
        JsonElement response = user.get("response");
        key = user.get("response").getAsJsonObject().get("key").getAsString();
        Cookie cookie = new Cookie("user_key", key);
        getDriver().manage().addCookie(new Cookie("OptanonAlertBoxClosed", "some_value"));
        getDriver().manage().addCookie(new Cookie("we-editor-first-open", "true"));
        getDriver().manage().addCookie(new Cookie("we-editor-photo-first-open", "true"));
        getDriver().manage().addCookie(cookie);
        getDriver().navigate().refresh();

    }


//        if (response != null) {
//            JsonElement keyElement = response.getAsJsonObject().get("key");
//            if (keyElement != null) {
//                key = keyElement.getAsString();
//                Cookie cookie = new Cookie("user_key", key);
//                getDriver().manage().addCookie(cookie);
//                getDriver().navigate().refresh();
//            }
//        }


    @AfterMethod
    public void tearDown() throws IOException {
        if (key != null) {
            helpers.ApiHelper.deleteUser(key);
        }
        getDriver().quit();
    }
}