package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtils {
    static WebDriver driver;

    public static WebDriver getBrowser(String browser) {
        switch (browser.toLowerCase()) {
            case ("chrome"): {
                //descărca și configureaza automat driverul Chrome WebDriver necesar pentru a controla browserul Google Chrome.
                //in functie de versiunea browserului
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                return driver;
            }
            case ("firefox"): {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                return driver;
            }
            case ("edge"): {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                return driver;
            }
            default: {
                System.out.println("Driver is not supported.");
                return null;
            }
        }
    }
}
