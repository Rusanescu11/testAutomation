package tests;

import Utils.BrowserUtils;
import Utils.ConfigUtils;
import Utils.ConstantUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

//clasa care va fi extinsa de alte clase
//aici se creeaza metode de citire a url ului  browserului
public class BaseTest {

    public WebDriver driver;
    String baseUrl;

    //metoda de citire a baseurl-ului(url paginii web)
    @BeforeClass
    public void setUp() {
        baseUrl = ConfigUtils.getGenericElement(ConstantUtils.CONFIG_FILE, "hostname");
    }
    //setare driver browser
    public void setUpDriver(String browserName) {
        String browser = browserName;
        if (browser.isEmpty())
            browser = ConfigUtils.getGenericElement(ConstantUtils.CONFIG_FILE, "browser");
        System.out.println("Set up webdriver for browser:" + browser);
        driver = BrowserUtils.getBrowser(browser);
    }

//    @AfterMethod(alwaysRun = true)
//    public void cleanUp() {
//        if (driver != null)
//            driver.quit();
//    }
}
