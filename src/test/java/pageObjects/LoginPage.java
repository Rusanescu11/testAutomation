package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(tagName = "h2")
    private WebElement loginPagebtn;

    @FindBy(id = "user")
    private WebElement usernameInput;

    @FindBy(how = How.ID, using = "pass")
    private WebElement passwordInput;

    @FindBy(tagName = "button")
    private WebElement loginBtn;

    private WebElement rememberMe;

    @FindBy(xpath = "//input[@id='user']/../..//small")
    private WebElement usernameErr;

    @FindBy(xpath = "//input[@id='pass']/../..//small")
    private WebElement passErr;

    @FindBy(xpath = "//a[contains(@href,'signup')]")
    private WebElement btnRegister;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }
    public void goToLoginPage() {
        wait.until(ExpectedConditions.visibilityOf(loginPagebtn));
        loginPagebtn.click();
    }

    public void login(String username, String pass) {
        wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(pass);
        loginBtn.click();
    }
    public String getPassErr() {
        try {
            return passErr.getText();
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    public String geUsernameErr() {
        try {
            return usernameErr.getText();
        } catch (NoSuchElementException ex) {
            return "";
        }
    }
    public void goToRegisterPage(){
        wait.until(ExpectedConditions.visibilityOf(btnRegister));
        btnRegister.click();
    }
}
