package tests;


import org.testng.Assert;
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
                {"", "", "edge", "Adresa de e-mail este obligatorie. Vă rugăm să introduceţi adresa Dvs. de email.",
                        ""},
                {"", "parola12", "edge", "Adresa de e-mail este obligatorie. Vă rugăm să introduceţi adresa Dvs. de email.", ""},
                {"lrusanescu@yahoo.com", "", "edge", "", "Vă rugăm să introduceţi parola Dvs."},
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
                {"lrusanescu@yahoo.com", "parola12", "edge", "Bine ai venit!"},
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
        Assert.assertEquals(myAccountPage.getWelcomeMessage(),welcomeMessage);
        System.out.println("Login succesfull: " + welcomeMessage);
       }
}
