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
    LoginPage loginPage;
    @FindBy(xpath = "//*[@id=\"paymentAddress.gender_female\"]")
    private WebElement checkBoxGenderFemale;

    @FindBy(xpath = "//*[@id=\"paymentAddress.gender_male\"]")
    private WebElement checkBoxGenderMale;

    @FindBy(xpath = "//*[@id=\"paymentAddress.firstname\"]")
    private WebElement inputPrenume;

    @FindBy(xpath = "//*[@id=\"paymentAddress.lastname\"]")
    private WebElement inputNumeFamilie;

    @FindBy(xpath = "//*[@id=\"paymentAddress.dateofbirthDay\"]")
    private WebElement inputDataNastereZi;

    @FindBy(xpath = "//*[@id=\"paymentAddress.gender_male\"]")
    private WebElement inputDataNastereLuna;

    @FindBy(xpath = "//*[@id=\"paymentAddress.dateofbirthYear\"]")
    private WebElement inputDataNastereAn;

    @FindBy(xpath = "//*[@id=\"FpaymentAddress.firm\"]")
    private WebElement checkBoxTipClientPersFizica;

    @FindBy(xpath = "//*[@id=\"CpaymentAddress.firm\"]")
    private WebElement checkBoxTipClientCompanie;

    @FindBy(xpath = "//*[@id=\"paymentAddress.streetname\"]")
    private WebElement inputStrada;

    @FindBy(xpath = "//*[@id=\"paymentAddress.streetnumber\"]")
    private WebElement inputNr;

    @FindBy(xpath = "//*[@id=\"paymentAddress.appartment\"]")
    private WebElement inputBloc;

    @FindBy(xpath = "//label[contains(text(),'Județ:')]/../..//a/span[2]")
    private WebElement inputJudet;

    @FindBy(xpath = "//*[@id=\"paymentAddress.postalcode\"]")
    private WebElement inputCodPostal;

    @FindBy(xpath = "//label[contains(text(),'Localitate')]/../..//a/span[2]")
    private WebElement inputLocalitate;

    @FindBy(xpath = "//*[@id=\"registerCommand\"]/div[1]/div[11]/div[2]/a/span[1]")
    private WebElement inputTara;
    @FindBy(xpath = "//*[@id=\"paymentAddress.phone1\"]")
    private WebElement inputNrTelefon;
    @FindBy(xpath = "//*[@id=\"login\"]")
    private WebElement inputMail;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement inputParola;

    @FindBy(xpath = "//*[@id=\"privacyPolicyConfirmed\"]")
    private WebElement checkBoxTermeneConditii;

    @FindBy(xpath = "//button[contains(@class,'REGISTER')]")
    private WebElement btnInregistrare;


    @FindBy(xpath = "//*[@id=\"registerCommand\"]/div[1]/div[17]/div[2]/div/div")
    private WebElement messageErrorPassword;


    @FindBy(xpath = "/html/body/ul[1]")
    private WebElement dropdownListJudet;

    public RegistrationPage1(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void setPrenumeInput(String prenume) {
        wait.until(ExpectedConditions.elementToBeClickable(inputPrenume));
        inputPrenume.clear();
        inputPrenume.sendKeys(prenume);
        //usernameInput.sendKeys(Keys.ENTER);
        inputPrenume.submit();
    }

    public void setNumeInput(String nume) {
        wait.until(ExpectedConditions.elementToBeClickable(inputNumeFamilie));
        inputNumeFamilie.clear();
        inputNumeFamilie.sendKeys(nume);
        ;
        inputNumeFamilie.submit();
    }

    public void setGenderCheckBoxF() {
        wait.until(ExpectedConditions.visibilityOf(checkBoxGenderFemale));
        checkBoxGenderFemale.click();

    }

    public void setGenderCheckBoxM() {
        wait.until(ExpectedConditions.elementToBeClickable(checkBoxGenderMale));
        checkBoxGenderMale.clear();
        checkBoxGenderMale.isSelected();
    }

    public void setStradaInput(String strada) {
        wait.until(ExpectedConditions.elementToBeClickable(inputStrada));
        inputStrada.clear();
        inputStrada.sendKeys(strada);
        inputPrenume.submit();
    }

    public void setNrInput(String nr) {
        wait.until(ExpectedConditions.elementToBeClickable(inputNr));
        inputNr.clear();
        inputNr.sendKeys(nr);
        inputNr.submit();
    }

    public void setJudetInput(String searchJudet) {
        wait.until(ExpectedConditions.elementToBeClickable(inputJudet));
        inputJudet.click();

        String judetXpath="//ul[contains(@class, 'AREASELECT-selectBox-dropdown-menu')]/li/a[contains(text(),'" + searchJudet + "')]";
        WebElement selectJudet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(judetXpath)));
        selectJudet.click();
    }


    public void setCodPostalInput(String codPostal) {
        wait.until(ExpectedConditions.elementToBeClickable(inputCodPostal));
        inputCodPostal.clear();
        inputCodPostal.sendKeys(codPostal);
    }

    public void setLocalitateInput(String searchLocalitate) {
        wait.until(ExpectedConditions.elementToBeClickable(inputLocalitate));
        inputLocalitate.click();

        String localitateXpath="//ul[contains(@class, 'TOWNSELECT')]/li/a[contains(text(),'" + searchLocalitate + "')]";
        WebElement selectLocalitate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(localitateXpath)));
        selectLocalitate.click();
    }

    public void setTelefonInput(String telefon) {
        wait.until(ExpectedConditions.elementToBeClickable(inputNrTelefon));
        inputNrTelefon.clear();
        inputNrTelefon.sendKeys(telefon);
        //usernameInput.sendKeys(Keys.ENTER);
        inputNrTelefon.submit();
    }

    public void setMailInput(String mail) {
        wait.until(ExpectedConditions.elementToBeClickable(inputMail));
        inputMail.clear();
        inputMail.sendKeys(mail);
        //usernameInput.sendKeys(Keys.ENTER);
        inputMail.submit();
    }

    public void setParolaInput(String parola) {
        wait.until(ExpectedConditions.elementToBeClickable(inputParola));
        inputParola.clear();
        inputParola.sendKeys(parola);
        //usernameInput.sendKeys(Keys.ENTER);
        inputParola.submit();
    }

    public String getPassErr() {
        try {
            return messageErrorPassword.getText();
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    public void setCheckBoxTermeneConditii() {
        wait.until(ExpectedConditions.visibilityOf(checkBoxTermeneConditii));
        checkBoxTermeneConditii.click();
    }

    public void clickResgisterBtn() {
        btnInregistrare.click();
    }
}