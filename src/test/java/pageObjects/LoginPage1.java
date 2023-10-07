package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage1 {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[@class='account loggedin']/i[@class='icon icon-account']")
    private WebElement loginPageBtn;

    @FindBy(xpath = "//*[@id=\"cmpwelcomebtnno\"]/a")
    private WebElement cookiePermision;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement inputMail;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement inputPassword;

    @FindBy(xpath = "//div[@class='input-error-message' and text()='Adresa ta de e-mail este obligatoriu']\n")
    private WebElement mailError;

    @FindBy(xpath = "//div[@class='input-error-message' and text()='Parola este obligatoriu']")
    private WebElement passwordError;

    @FindBy(xpath = "//button[@data-test-id='login-submit']")
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
        WebElement cmpwrapper = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cmpwrapper")));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement elementInShadowDOM = (WebElement) jsExecutor.executeScript(
                "return arguments[0].shadowRoot.querySelector('#cmpbntnotxt')",
                cmpwrapper
        );
        elementInShadowDOM.click();
        wait.until(ExpectedConditions.visibilityOf(loginPageBtn));
        loginPageBtn.click();
    }

    public void login(String mail, String password) {
        WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("login")));
        driver.switchTo().frame(iframeElement);
        Duration durata = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, durata);
        WebElement inputMail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]")));
        inputMail.clear();
        inputMail.sendKeys(mail);
        WebElement inputPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
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

