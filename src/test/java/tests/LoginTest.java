package tests;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    AccountPage accountPage;

    @DataProvider(name = "loginDp")
    public Object[][] loginDataProvider() {
        return new Object[][]{
                //    {"test", "", "chrome", "Please enter your username", "Please enter your password"},
           //     {"dingo", "dingopassword", "edge"},
                //   {"test", "", "chrome", "", "Please enter your password"},
                  {"zebra", "zebrapassword", "edge","Please enter your username", "Please enter your password"}
        };
    }

    @Test(dataProvider = "loginDp")
    public void login(String username, String password, String browser, String usernameErr, String passErr) {
        System.out.println("Login with username:" + username + "/password:" + password + "=> on browser:" + browser);
        setUpDriver(browser);
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.login(username, password);
        System.out.println("login terminat");
        Assert.assertEquals(loginPage.geUsernameErr(), usernameErr);
        Assert.assertEquals(loginPage.getPassErr(), passErr);
    }

    @Test(dataProvider = "loginDp")
    public void loginPositive(String username, String password, String browser) {
        System.out.println("Login with username:" + username + "/password:" + password + "=> on browser:" + browser);
        setUpDriver(browser);
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.login(username, password);
        System.out.println("login terminat");
        accountPage = new AccountPage(driver);
        Assert.assertTrue(username, accountPage.getName().contains(username));
    }

    @Test(dataProvider = "loginDp")
    public void loginNegative(String username, String password, String browser, String userNameError, String passEror) {
        System.out.println("Login with username:" + username + "/password:" + password + "=> on browser:" + browser);
        setUpDriver(browser);
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.login(username, password);
        System.out.println("login terminat");
        accountPage = new AccountPage(driver);
        Assert.assertEquals(loginPage.geUsernameErr(), userNameError);
        Assert.assertEquals(loginPage.getPassErr(), passEror);
    }
}
