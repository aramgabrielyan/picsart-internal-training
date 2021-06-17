package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import setup.DriverHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static helpers.WaitHelper.getWait;
import static listeners.TestListener.LOGGER;


public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {

    public static final String BASE_URL = "https://picsart.com";

    public abstract T open();
    public abstract T init();
    
    private WebDriver driver;

    public BasePage() {
        driver = DriverHelper.get().getDriver();
    }

    public WebElement find(By location) {
        System.out.println("Finding element ->" + location.toString());
        return driver.findElement(location);
    }

    public List<WebElement> findAll(By location) {
        System.out.println("Finding elements -> " + location.toString());
        return driver.findElements(location);
    }

    public void changeTab(int tabIndex) {
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(tabIndex));

    }

    protected void clickByAction(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
    }

    protected T openPage() {
        PageFactory.initElements(driver, this);
        load();
        return get();
    }

    protected T initPage() {
        PageFactory.initElements(driver, this);
        return get();
    }

    @Override
    protected void load() {
        LOGGER.info("Opening url->" + BASE_URL + getUrl());
        driver.get(BASE_URL + getUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        getWait().waitForPageReady();
    }

    public abstract String getUrl();

    public void type(By location, String text) {
        find(location).sendKeys(text);
    }

    public void type(WebElement element, String text) {
        System.out.println("Typing ->" + text + "to field" + element.toString());
        element.sendKeys(text);
    }

    public void click(By location) {
        click(find(location));
    }

    public void click(WebElement element) {
        System.out.println("Clicking on element" + element.toString());
        element.click();
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isDisplayed(By location) {
        try {
            return find(location).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //    public void changeTabNew() {
//        String windowHandle = driver.getWindowHandle();
//        ArrayList tabs = new ArrayList(driver.getWindowHandles());
//        driver.switchTo().window((String) tabs.get(1));
//    }
}
