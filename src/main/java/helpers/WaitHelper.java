package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static setup.DriverSetup.getDriver;

public class WaitHelper {
    private final static int DEFAULT_TIMEOUT = 60;

    public static WaitHelper getInstance() {
        return new WaitHelper();
    }

    public WaitHelper waitForElementDisplayed(WebElement element) {
        try {
            new WebDriverWait(getDriver(), DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf((element)));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element with provided locator was not displayed: " + element.toString());
        }
    }

//    public WaitHelper waitForListElementDisplayed(List<WebElement> element) {
//        try {
//            new WebDriverWait(getDriver(), DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf((WebElement) element));
//            return this;
//        } catch (WebDriverException e) {
//            throw new Error("Element with provided locator was not displayed: " + element.toString());
//        }
//    }

    public WaitHelper waitForElementInvisible(WebElement element) {
        try {
            new WebDriverWait(getDriver(), DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.invisibilityOf(element));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element with provided locator is visible: "
                    + element.toString());
        }
    }

    public WaitHelper waitForElementClickable(By location) {
        try {
            new WebDriverWait(getDriver(), DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.elementToBeClickable((location)));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element with provided locator not clickable "
                    + location.toString());
        }
    }

    public WaitHelper waitForElementClickable(WebElement element) {
        try {
            new WebDriverWait(getDriver(), DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.elementToBeClickable((element)));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element with provided locator not clickable "
                    + element.toString());
        }
    }

    public void waitForPageReady() {
        new WebDriverWait(getDriver(), DEFAULT_TIMEOUT).until((ExpectedConditions.jsReturnsValue("return document.readyState=='complete';")));
    }
}
