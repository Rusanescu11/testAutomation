package pageObjects;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegistrationPage1 {

    WebDriver driver;
    WebDriverWait wait;


    @FindBy(xpath = "//div[@class='option-border' and @data-test-id='authOptions-register']")
    private WebElement btnCreeaza;

    @FindBy(xpath = "//*[@id=\"firstName\"]")
    private WebElement inputPrenume;

    @FindBy(xpath = "//*[@id=\"lastName\"]")
    private WebElement inputNumeFamilie;

    @FindBy(xpath = "//*[@id=\"birthDate\"]")
    private WebElement inputDataNastere;
    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement inputMail;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement inputParola;
    @FindBy(xpath = "//button[@data-test-id='register-submit']/div[@class='button__content']")
    private WebElement btnInregistrare;

    @FindBy(xpath = "//span[@class='small'][contains(text(),'Bun venit în contul tău. Aici poți gestiona comenzile tale')]\n")
    private WebElement welcomeMessageRegister;

    @FindBy(xpath = "//div[@class='input-error-message'][contains(text(),'Prenume este obligatoriu')]")
    private WebElement errorMsjFirstName;

    public RegistrationPage1(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void clickOnButtonCreazaCont() {
        WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("login")));
        driver.switchTo().frame(iframeElement);
        Duration durata = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, durata);
        WebElement btnCreeaza = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='option-border' and @data-test-id='authOptions-register']")));
        btnCreeaza.click();
    }

    public void setPrenumeInput(String prenume) {
        wait.until(ExpectedConditions.elementToBeClickable(inputPrenume));
        inputPrenume.clear();
        inputPrenume.sendKeys(prenume);
    }

    public void setNumeInput(String nume) {
        wait.until(ExpectedConditions.elementToBeClickable(inputNumeFamilie));
        inputNumeFamilie.clear();
        inputNumeFamilie.sendKeys(nume);
    }

    public void setMailInput(String mail) {
        wait.until(ExpectedConditions.elementToBeClickable(inputMail));
        inputMail.clear();
        inputMail.sendKeys(mail);
    }

    public void setParolaInput(String parola) {
        wait.until(ExpectedConditions.elementToBeClickable(inputParola));
        inputParola.clear();
        inputParola.sendKeys(parola);
    }
    public void setDataNastereInput(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(inputDataNastere));
        inputDataNastere.clear();
        inputDataNastere.sendKeys(data);
    }

    public String getFirstnameErr() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='input-error-message'][contains(text(),'Prenume este obligatoriu')]")));

            String errorText = errorMsjFirstName.getText();
            return errorText;
        } catch (NoSuchElementException ex) {
            return "nimic";
        }
    }

    public String getWelcomeMsj() {
        try {
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='small'][contains(text(),'Bun venit în contul tău. Aici poți gestiona comenzile tale')]")));
            return welcomeMessageRegister.getText();
        } catch (NoSuchElementException ex) {
            return "";
        }
    }


    public void clickRegisterBtn() {
        btnInregistrare.click();
    }
}