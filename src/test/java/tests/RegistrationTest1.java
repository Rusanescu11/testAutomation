package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.LoginPage1;
import pageObjects.RegistrationPage1;

public class RegistrationTest1 extends BaseTest {
    WebDriverWait wait;
    LoginPage1 loginPage1;
    RegistrationPage1 registrationPage1;


    @DataProvider(name = "registerPositive")
    public Object[][] registerPositive() {
        return new Object[][]{

                 {"chrome", "Daria","Manescu","Lalelelor","33","0784332232","dariadumitru1@yahoo.com","parola12234"}
        };
    }

    @Test(dataProvider = "registerPositive")
    public void registerPositive(String browser,String prenume,String nume,String strada, String nr,String telefon,String mail,String parola) {
        setUpDriver(browser);
        driver.get(baseUrl);
        loginPage1 = new LoginPage1(driver);
        loginPage1.goToLoginPage();
        System.out.println("Opened login page.");
        registrationPage1 = new RegistrationPage1(driver);
        registrationPage1.setGenderCheckBoxF();
       registrationPage1.setPrenumeInput(prenume);
        registrationPage1.setNumeInput(nume);
        registrationPage1.setStradaInput(strada);
        registrationPage1.setNrInput(nr);
        registrationPage1.setTelefonInput(telefon);
        registrationPage1.setMailInput(mail);
        registrationPage1.setJudetInput("Bihor");
        registrationPage1.setLocalitateInput("Albesti");
        registrationPage1.setParolaInput(parola);
        registrationPage1.setCheckBoxTermeneConditii();
        registrationPage1.clickRegisterBtn();
        Assert.assertEquals(registrationPage1.getWelcomeMsj(),"Bine ai venit!");
    }

    @DataProvider(name = "registerNegative")
    public Object[][] registerEmptyFirstName() {
        return new Object[][]{

                {"chrome", "","Manescu","Lalelelor","33","0784332232","dariadumitru1@yahoo.com","parola12234"}
        };
    }
    @Test(dataProvider = "registerNegative")
    public void registerEmptyFirstName(String browser,String prenume,String nume,String strada, String nr,String telefon,String mail,String parola) {
        setUpDriver(browser);
        driver.get(baseUrl);
        loginPage1 = new LoginPage1(driver);
        loginPage1.goToLoginPage();
        System.out.println("Opened login page.");
        registrationPage1 = new RegistrationPage1(driver);
        registrationPage1.setGenderCheckBoxF();
        registrationPage1.setPrenumeInput(prenume);
        registrationPage1.setNumeInput(nume);
        registrationPage1.setStradaInput(strada);
        registrationPage1.setNrInput(nr);
        registrationPage1.setTelefonInput(telefon);
        registrationPage1.setMailInput(mail);
        registrationPage1.setJudetInput("Bihor");
        registrationPage1.setLocalitateInput("Albesti");
        registrationPage1.setParolaInput(parola);
        registrationPage1.setCheckBoxTermeneConditii();
        registrationPage1.clickRegisterBtn();
        Assert.assertEquals(registrationPage1.getFirstnameErr(),"Nu ai introdus un prenume. Te rugăm să introduci prenumele tău");
    }
}
