package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage1 {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a/div[contains(text(), 'Contul meu')]")
    private WebElement loginPageBtn;

    @FindBy(xpath = "//*[@id=\"cookie-consent-local\"]/div/footer/button[3]")
    private WebElement cookiePermision;

    @FindBy(xpath = "//*[@id=\"loginEmail\"]")
    private WebElement inputMail;

    @FindBy(xpath = "//*[@id=\"loginPassword\"]")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@id=\"loginCommand\"]/div[1]/div[1]/div[2]/div/div")
    private WebElement mailError;

    @FindBy(xpath = "//*[@id=\"loginCommand\"]/div[1]/div[2]/div[2]/div/div")
    private WebElement passwordError;

    @FindBy(xpath = "//*[@id=\"loginCommand\"]/div[2]/button/span")
    private WebElement autentificationBtn;

    @FindBy(xpath = "//*[@id=\"loginCommand\"]/div[1]/div[1]/div[2]/div[1]/div/text()")
    private WebElement mailMessageInput;

    @FindBy(xpath = "//*[@id=\"loginCommand\"]/div[1]/div[2]/div[2]/div[1]/div")
    private WebElement passwordMessageInput;

    public LoginPage1(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void goToLoginPage() {
        cookiePermision.click();
        wait.until(ExpectedConditions.visibilityOf(loginPageBtn));
        loginPageBtn.click();
    }

    public void login(String mail, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(inputMail));
        inputMail.clear();
        inputMail.sendKeys(mail);
        inputPassword.clear();
        inputPassword.sendKeys(password);
        autentificationBtn.click();
    }

    public String getPasswordErr() {
        try {
            return passwordError.getText();
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    public String getMailErr() {
        try {
            return mailError.getText();
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

}

