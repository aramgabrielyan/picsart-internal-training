package base;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import helpers.ApiHelper;
import helpers.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.BasePage;
import setup.DriverHelper;


import java.io.IOException;


public class TestBase {

    private static final Logger LOGGER = Logger.getLogger(TestBase.class);
    private WebDriver driver;
    private String key;

    @BeforeMethod
    public void setup() {
        initiateDriver();
        setUser();
        setCookies();
    }

    protected void initiateDriver() {
        driver = DriverHelper.get().getDriver();
        driver.get(BasePage.BASE_URL);
        WaitHelper.getWait().waitForPageReady();
    }
    private void setUser() {
        JsonObject user = null;
        try {
            user = ApiHelper.createUser();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonElement response = user.get("response");
        if (response != null) {
            JsonElement keyElement = response.getAsJsonObject().get("key");
            if (keyElement != null) {
                key = keyElement.getAsString();
                LOGGER.info("User created, user_key:" + key);
                Cookie cookie = new Cookie("user_key", key);
                DriverHelper.get().getDriver().manage().addCookie(cookie);
            }
        }
        else
            LOGGER.info("Could not create user, response is null");

    }

    protected void setCookies() {
        driver.manage().addCookie(new Cookie("OptanonAlertBoxClosed", "some_value"));
        driver.manage().addCookie(new Cookie("we-editor-first-open", "true"));
        driver.manage().addCookie(new Cookie("we-editor-photo-first-open", "true"));
    }


    @AfterMethod
    public void tearDown() {
        DriverHelper.get().quitDriver(DriverHelper.get().getDriver());
    }

    public String getUserKey() {
        return key;
    }
}