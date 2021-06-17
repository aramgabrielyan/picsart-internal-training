package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;


public class DriverHelper {


    public static DriverHelper get() {
        DriverHelper driverHelper = new DriverHelper();
        return driverHelper;
    }
    private WebDriver driver;
    private static final String BROWSER = System.getProperty("selenium.browser", "chrome");
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public WebDriver getDriver() {
            if (driverThread.get() == null) {
                switch (BROWSER) {
                    case "chrome":
                        System.setProperty("webdriver.chrome.driver",
                                "src/main/resources/chromedriver");
                        driver = new ChromeDriver();
                        ChromeOptions options = new ChromeOptions();
                        List<String> arguments = new ArrayList<>();
                        arguments.add("--disable-notifications");
                        options.addArguments(arguments);
                        driver.manage().window().maximize();
                        driverThread.set(driver);
                        break;

                    case "firefox":
                        System.setProperty("webdriver.gecko.driver",
                                "./src/main/resources/drivers/geckodriver");
                        driver = new FirefoxDriver();
                        driverThread.set(driver);
                        break;
                }
            }
        return driverThread.get();
    }

    public void quitDriver(WebDriver driver) {
        driver.quit();
        driverThread.remove();
    }




}
