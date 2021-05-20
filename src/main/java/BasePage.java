import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static setup.DriverSetup.getDriver;

public abstract class BasePage {
    protected WebDriver driver;
    public static final String BASE_URL = "https://picsart.com/";

    public BasePage() {
        this.driver = getDriver();
    }

    public void changeTab(int tabIndex) {
        List<String> windowHandlers = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(windowHandlers.get(tabIndex));
    }

    public abstract String getUrl();

    public void open(String url) {
        System.out.println("Opening url ->" + url);
        driver.get(url);
    }

    public WebElement find(By location) {
        System.out.println("Finding element ->" + location.toString());
        return driver.findElement(location);
    }

    public List<WebElement> findAll(By location) {
        System.out.println("Finding elements -> " + location.toString());
        return driver.findElements(location);
    }

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
}
