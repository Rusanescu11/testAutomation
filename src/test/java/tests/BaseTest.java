package tests;

import Utils.BrowserUtils;
import Utils.ConfigUtils;
import Utils.ConstantUtils;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {
    public WebDriver driver;
    String baseUrl;

    @BeforeClass
    public void setUp() {
        baseUrl = ConfigUtils.getGenericElement(ConstantUtils.CONFIG_FILE, "hostname");
    }

    public void setUpDriver(String browserName) {
        String browser = browserName;
        if (browser.isEmpty())
            browser = ConfigUtils.getGenericElement(ConstantUtils.CONFIG_FILE, "browser");
        System.out.println("Set up webdriver for browser:" + browser);
        driver = BrowserUtils.getBrowser(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        if (driver != null)
            driver.quit();
    }
}
