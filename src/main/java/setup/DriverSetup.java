package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class DriverSetup {
    public static WebDriver driver;
    private static ChromeOptions options;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            options = new ChromeOptions();
            List<String> arguments = new ArrayList<>();
            arguments.add("--disable-notifications");
            arguments.add("--window-size=1920,1080");
            options.addArguments(arguments);
            driver = new ChromeDriver(options);
        }
        return driver;
    }
}
