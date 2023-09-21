package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RegistrationPage {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;

    @FindBy(xpath = "//input[@id=\"username\"]")
    private WebElement username;

    @FindBy(xpath = "//input[@id=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//input[@id=\"password2\"]")
    private WebElement confirmPassword;
    @FindBy(xpath = "//*[@id=\"svelte\"]/div[1]/div[2]/div[2]/div/div/div/form/small")
    private WebElement existingUserErr;
    @FindBy(xpath = "//input[@id='username']/../..//small[2]")
    private WebElement usernameErr;
    @FindBy(xpath = "//input[@id='password']/../..//small[2]")
    private WebElement passErr;
    @FindBy(xpath = "//input[@id='password2']/../..//small[2]")
    private WebElement confirmPasswordErr;
    @FindBy(css = "button[class='btn btn-primary']")
    private WebElement registrationBtn;
    @FindBy(css = "input#terms+label")
    private WebElement checkBoxTerms;

    //WebElement checkBoxTerms = driver.findElement(By.cssSelector("input#terms+label"));
    public void clickOnCheckBoxTerms() {
        wait.until(ExpectedConditions.visibilityOf(checkBoxTerms));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", checkBoxTerms);
    }

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public Object setUsername(String usernameInput) {
        wait.until(ExpectedConditions.elementToBeClickable(username));
        username.clear();
        username.sendKeys(usernameInput);
        username.submit();
        return null;
    }

    public Object setPassword(String passwordInput) {
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.clear();
        password.sendKeys(passwordInput);
        password.submit();
        return null;
    }

    public Object setConfirmPassword(String confirmPasswordInput) {
        wait.until(ExpectedConditions.elementToBeClickable(confirmPassword));
        confirmPassword.clear();
        confirmPassword.sendKeys(confirmPasswordInput);
        confirmPassword.submit();
        return null;
    }

    public String getExistingUserErr() {
        try {
            return existingUserErr.getText();
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    public String getUsernameErr() {
        try {
            return usernameErr.getText();
        } catch (NoSuchElementException ex) {
            return "";
        }
    }



    public void clickRegisterPageBtn() {
        wait.until(ExpectedConditions.visibilityOf(registrationBtn));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", registrationBtn);
    }
}
