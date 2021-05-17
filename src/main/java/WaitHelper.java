import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static setup.DriverSetup.getDriver;

public class WaitHelper {
    private final static int DEFAULT_TIMEOUT = 10;

    public static WaitHelper getInstance() {
        return new WaitHelper();
    }

    public WaitHelper waitForElementDisplayed(By location){
        try {
            new WebDriverWait(getDriver(), DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(location));
            return this;
        } catch (WebDriverException e) {
            throw new Error ("Element with provided locator was not displayed" + location.toString());
        }

    }
}


//singleton design pattern