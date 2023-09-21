package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.LoginPage1;
import pageObjects.RegistrationPage1;

public class RegistrationTest1 extends BaseTest {
    WebDriverWait wait;
    LoginPage1 loginPage1;
    RegistrationPage1 registrationPage1;


    @DataProvider(name = "registerNegativeDpShortPassword1")
    public Object[][] registerNegativeDpShortPassword1() {
        return new Object[][]{
                //  {"adresare", "prenume", "nume", "strada", " nr", "Judet", "codPostal", "localitate", "nrTelefon", "mail", "parola"},
                //{"edge", "prenume", "nume", "strada", "nr","123456", "08656", "mail@yahoo.com", "Parola123453vfv4342"}
                {"chrome","123456"}
        };
    }

    @Test(dataProvider = "registerNegativeDpShortPassword1")
    public void registerNegativeShortPassword1(String browser,String codPostal) {
//        System.out.println("Login with nume:" + nume +
//                " / short password:" +
//                " => on browser :" + browser + " prenume: " + prenume + "nume: " + nume + " strada: " + strada + " nr: " + nr + "codpostal: "+codPostal+ " judet: " + " codPOstal: " +
//                " localitate: " + " telefon: " + telefon + " mail: " + mail);
        setUpDriver(browser);
        driver.get(baseUrl);
        loginPage1 = new LoginPage1(driver);
        loginPage1.goToLoginPage();
        System.out.println("Opened login page.");
        registrationPage1 = new RegistrationPage1(driver);
//        registrationPage1.setGenderCheckBoxF();
//        registrationPage1.setPrenumeInput(prenume);
//        registrationPage1.setNumeInput(nume);
//        registrationPage1.setStradaInput(strada);
//        registrationPage1.setNrInput(nr);
//        registrationPage1.setTelefonInput(telefon);
//        registrationPage1.setMailInput(mail);
          registrationPage1.setJudetInput("Bihor");
          registrationPage1.setCodPostalInput(codPostal);
          registrationPage1.setLocalitateInput("Albesti");
//        registrationPage1.setParolaInput(parola);
//        registrationPage1.setCheckBoxTermeneConditii();
        registrationPage1.clickResgisterBtn();
    }


}
