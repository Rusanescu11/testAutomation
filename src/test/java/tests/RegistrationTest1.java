package tests;

import Utils.ConstantUtils;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage1;
import pageObjects.RegistrationPage1;

public class RegistrationTest1 extends BaseTest {
    WebDriverWait wait;
    LoginPage1 loginPage1;
    RegistrationPage1 registrationPage1;


    @DataProvider(name = "registerPositive")
    public Object[][] registerPositive() {
        return new Object[][]{

                {"chrome", "Daria", "Manescu", ConstantUtils.REGISTER_EMAIL, ConstantUtils.REGISTER_PASSWORD,"12.02.1990"}
        };
    }

    @Test(dataProvider = "registerPositive")
    public void registerPositive(String browser, String prenume, String nume, String mail, String parola,String dataNastere) {
        setUpDriver(browser);
        driver.get(baseUrl);
        loginPage1 = new LoginPage1(driver);
        loginPage1.goToLoginPage();
        registrationPage1 = new RegistrationPage1(driver);
        registrationPage1.clickOnButtonCreazaCont();
        registrationPage1.setPrenumeInput(prenume);
        registrationPage1.setNumeInput(nume);
        registrationPage1.setMailInput(mail);
        registrationPage1.setParolaInput(parola);
        registrationPage1.setDataNastereInput(dataNastere);
        registrationPage1.clickRegisterBtn();
        Assert.assertEquals(registrationPage1.getWelcomeMsj(),"Bun venit în contul tău. Aici poți gestiona comenzile tale");
    }

    @DataProvider(name = "registerNegative")
    public Object[][] registerEmptyFirstName() {
        return new Object[][]{

                {"chrome", "", "Manescu", ConstantUtils.REGISTERNEG_EMAIL, ConstantUtils.REGISTERNEG_PASSWORD,"12.02.1990"}
        };
    }

    @Test(dataProvider = "registerNegative")
    public void registerEmptyFirstName(String browser, String prenume, String nume, String mail, String parola,String dataNastere) {
        setUpDriver(browser);
        driver.get(baseUrl);
        loginPage1 = new LoginPage1(driver);
        loginPage1.goToLoginPage();
        registrationPage1 = new RegistrationPage1(driver);
        registrationPage1.clickOnButtonCreazaCont();
        registrationPage1.setPrenumeInput(prenume);
        registrationPage1.setNumeInput(nume);
        registrationPage1.setMailInput(mail);
        registrationPage1.setParolaInput(parola);
        registrationPage1.setDataNastereInput(dataNastere);
        registrationPage1.clickRegisterBtn();
        Assert.assertEquals(registrationPage1.getFirstnameErr(), "Prenume este obligatoriu");
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
