package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BasePage;
import setup.DriverHelper;

public class WaitHelper {
    private static final int DEFAULT_TIMEOUT = 20;
    private WebDriver driver = DriverHelper.get().getDriver();
    public static WaitHelper getInstance() {
        WaitHelper waitHelper = new WaitHelper();
        return waitHelper;
    }

    public WaitHelper waitForElementDisplayed(WebElement element) {
        try {
            WebElement until = new WebDriverWait(driver, DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.visibilityOf((element)));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element with provided locator was not displayed" + element.toString());
        }
    }

    public WaitHelper waitForElementDisplay(By location) {
        try {
            WebElement until = new WebDriverWait(driver, DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.visibilityOfElementLocated((location)));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element with provided locator is not displayed" + location.toString());
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
            new WebDriverWait(DriverHelper.get().getDriver(), DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.invisibilityOf(element));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element with provided locator is visible: "
                    + element.toString());
        }
    }

    public WaitHelper waitForElementClickable(By location) {
        try {
            WebElement until = new WebDriverWait(driver, DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.elementToBeClickable((location)));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element with provided locator was not displayed" + location.toString());
        }
    }

    public WaitHelper waitForElementClickable(WebElement element) {
        try {
            new WebDriverWait(DriverHelper.get().getDriver(), DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.elementToBeClickable((element)));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element with provided locator not clickable "
                    + element.toString());
        }
    }

    public void waitForPageReady() {
        new WebDriverWait(DriverHelper.get().getDriver(), DEFAULT_TIMEOUT)
                .until((ExpectedConditions.jsReturnsValue("return document.readyState=='complete';")));
    }

    public static WaitHelper getWait() {
        WaitHelper waitHelper = new WaitHelper();
        return waitHelper;
    }
}
