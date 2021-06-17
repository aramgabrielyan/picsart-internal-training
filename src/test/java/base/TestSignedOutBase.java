package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import setup.DriverHelper;

public class TestSignedOutBase extends TestBase{

    @BeforeMethod
    @Override
    public void setup() {
        initiateDriver();
        setCookies();
    }

    @AfterMethod
    public void tearDown() {
        DriverHelper.get().quitDriver(DriverHelper.get().getDriver());
    }
}
