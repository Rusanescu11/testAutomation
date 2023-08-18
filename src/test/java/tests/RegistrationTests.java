package tests;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;

public class RegistrationTests extends BaseTest {
    RegistrationPage registrationPage;
    LoginPage loginPage;
    AccountPage accountPage;


    @DataProvider(name = "register")
    public Object[][] registerDataProvider() {
        return new Object[][]{
                {"chrome", "dingo", "dingopassword", "dingopassword", "Username already exists!"},

        };
    }

    @Test(dataProvider = "register")
    public void alreadyRegistred(String browser, String username, String password, String confirmPassword, String existingUser) {
        setUpDriver(browser);
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.goToRegisterPage();
        registrationPage = new RegistrationPage(driver);
        registrationPage.setUsername(username);
        registrationPage.setPassword(password);
        registrationPage.setConfirmPassword(confirmPassword);
        registrationPage.clickOnCheckBoxTerms();
        registrationPage.clickRegisterPageBtn();

        Assert.assertEquals(registrationPage.getExistingUserErr(), existingUser);
        System.out.println("Tested message: Username already exists!");
    }

    @DataProvider(name = "shortAndLongUsername")
    public Object[][] shortAndLongUsernameLenght() {
        return new Object[][]{

                {"chrome", "ana", "Please choose a longer username"},

                {"chrome", "analiaanaliaanalihhhhhhhiaanaliaaniaanaliaan", "Please choose a shorter username"}
        };
    }

    @Test(dataProvider = "shortAndLongUsername")
    public void shortAndLongUsernameLenght(String browser,
                                              String username,
                                              String usernameErr) {

        System.out.println("Login with short or long username:" + username + " => on browser:" + browser);

        setUpDriver(browser);
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.goToRegisterPage();
        registrationPage = new RegistrationPage(driver);
        registrationPage.setUsername(username);
        if (username.length() < 4) {
            System.out.println("Username prea scurt");
         org.testng.Assert.assertEquals(registrationPage.getUsernameErr(), usernameErr);
        } if (username.length() > 35) {
            System.out.println("Username prea lung");
            org.testng.Assert.assertEquals(registrationPage.getUsernameErr(), usernameErr);
        }
    }
}
