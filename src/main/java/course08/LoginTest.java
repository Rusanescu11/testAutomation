package course08;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LoginTest {
    private WebDriver chromeDriver;

    @DataProvider(name = "LoginDataProvider")
    public Iterator<Object[]> loginDataProvider() {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[]{"", "", "Please enter your username", "Please enter your password", ""});
        dp.add(new String[]{"SomeUser", "somePassword", "", "", "Invalid username or password!"});
        return dp.iterator();
    }

    @AfterMethod
    public void quit() {
        chromeDriver.quit();
    }

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\TestareAutomata\\src\\test\\resources\\drives\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("http://86.121.249.151:4999/");
    }

    @Test
    public void loginWithInvalidUsername() {
        WebElement loginElement = chromeDriver.findElement(By.tagName("h2"));
        loginElement.click();
        WebElement usernameElement = chromeDriver.findElement(By.id("user"));
        usernameElement.sendKeys("lkajshdflkjhaukdsf");
        WebElement passwordElement = chromeDriver.findElement(By.id("pass"));
        passwordElement.sendKeys("zebrapassword");
        WebElement signInButtonElement = chromeDriver.findElement(By.tagName("button"));
        signInButtonElement.click();
        WebElement errorElement = chromeDriver.findElement(By.cssSelector("small.form-error"));
        Assert.assertTrue("Error message is not displayed", errorElement.isDisplayed());
        Assert.assertEquals("Error message text is incorrect", "Invalid username or password!",
                errorElement.getText());
    }

    @Test(dataProvider = "LoginDataProvider")
    public void loginTest(String username, String password, String userError, String passwordError, String generalError) {
        WebElement loginElement = chromeDriver.findElement(By.tagName("h2"));
        loginElement.click();

        WebElement usernameElement = chromeDriver.findElement(By.id("user"));
        usernameElement.clear();
        usernameElement.sendKeys(username);

        WebElement passwordElement = chromeDriver.findElement(By.id("pass"));
        passwordElement.clear();
        passwordElement.sendKeys(password);

        WebElement signInButtonElement = chromeDriver.findElement(By.tagName("button"));
        signInButtonElement.click();

        if (generalError.length() == 0) {
            WebElement userErrorElement = chromeDriver.findElement(By.xpath("//input[@id='user']/ancestor::div[1]/following-sibling::small"));
            String actualUserError = userErrorElement.getText();

            WebElement passwordErrorElement = chromeDriver.findElement(By.xpath("//input[@id='pass']/ancestor::div[1]/following-sibling::small"));
            String actualPasswordError = passwordErrorElement.getText();

            Assert.assertEquals("Incorrect user error message", userError, actualUserError);
            Assert.assertEquals("Incorrect password error message", passwordError, actualPasswordError);
        } else {
            WebElement generalErrorElement = chromeDriver.findElement(By.cssSelector("small.form-error"));
            String actualGeneralError = generalErrorElement.getText();

            Assert.assertEquals("Incorrect login error message", generalError, actualGeneralError);
        }
//        chromeDriver.quit();
    }
}
