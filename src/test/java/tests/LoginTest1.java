package tests;


import Utils.ConstantUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage1;
import pageObjects.MyAccountPage;

public class LoginTest1 extends BaseTest {
    LoginPage1 loginPage1;
    MyAccountPage myAccountPage;

    @Test
    public void loginTest() {
        System.out.println(baseUrl);
    }

    @DataProvider(name = "loginDpN")
    public Object[][] loginNegativeDataProvider() {
        return new Object[][]{

                {"", "parola", "chrome", "Adresa ta de e-mail este obligatoriu", ""},
                {"mail@yahoo.com", "", "chrome", "", "Parola este obligatoriu"},
        };

    }

    @Test(dataProvider = "loginDpN")
    public void loginNegative(String mail, String password, String browser, String erorMail, String errorPass) {
        System.out.println("Login with mail:" + mail + "/password:" + password + "=> on browser:" + browser);
        setUpDriver(browser);
        driver.get(baseUrl);
        loginPage1 = new LoginPage1(driver);
        loginPage1.goToLoginPage();
        loginPage1.login(mail, password);
        System.out.println("login terminat");
        Assert.assertEquals(loginPage1.getMailErr(), erorMail);
        Assert.assertEquals(loginPage1.getPasswordErr(), errorPass);
    }


    @DataProvider(name = "loginDp")
    public Object[][] loginPositiveDataProvider() {
        return new Object[][]{
                {ConstantUtils.VALID_EMAIL, ConstantUtils.VALID_PASSWORD, "chrome", "Bun venit în contul tău. Aici poți gestiona comenzile tale"},
        };
    }

    @Test(dataProvider = "loginDp")
    public void loginPositive(String mail, String password, String browser, String welcomeMessage) {
        System.out.println("Login with mail:" + mail + "=> on browser:" + browser);
        setUpDriver(browser);
        driver.get(baseUrl);
        loginPage1 = new LoginPage1(driver);
        loginPage1.goToLoginPage();
        loginPage1.login(mail, password);
        myAccountPage = new MyAccountPage(driver);
        Assert.assertEquals(myAccountPage.getWelcomeMessage(), welcomeMessage);

    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
