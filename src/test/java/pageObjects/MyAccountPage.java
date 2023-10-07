package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//span[@class='small']")
    WebElement welcomeMessage;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public String getWelcomeMessage() {
        try {

            WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='small']")));
            System.out.println("Mesajul de bun venit este: " + welcomeMessage);
            return welcomeMessage.getText();

        } catch (NoSuchElementException ex) {
            System.out.println("Elementul cu mesajul de bun venit nu a fost găsit.");
            return "";
        }
    }
}
