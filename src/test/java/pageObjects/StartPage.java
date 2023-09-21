package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StartPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"cookie-consent-local\"]/div/footer/button[3]")
    private WebElement cookiePermision;
    @FindBy(xpath = "//*[@id=\"autocomplete-search-input\"]")
    private WebElement inputSearch;

    @FindBy(xpath = "//*[@id=\"autocomplete-search\"]/button")
    private WebElement searchBtn;

    @FindBy(xpath = "//*[@id=\"page\"]/div[2]/p")
    private WebElement searchMessage;

    @FindBy(xpath = "//*[@id=\"00012301704628\"]/div[2]/a")
    private WebElement product;


    @FindBy(xpath = "//*[@id=\"content\"]/section[1]/section[2]/div[3]/a")
    private WebElement addProductBtn;


    @FindBy(xpath = "//*[@id=\"content\"]/section[1]/section[2]/section[1]/div/div/div/div/span")
    private WebElement selectMarime;

    @FindBy(xpath = "//*[@id=\"OverlayContentWrapper\"]/div/ul[3]/li[5]")
    private WebElement selectNumberMarime;


    @FindBy(xpath = " //*[@id=\"layer\"]/div[2]/div[2]/div/h3")
    private WebElement messageSuccesAddToCart;
    public StartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void search(String words) {
        cookiePermision.click();
        wait.until(ExpectedConditions.elementToBeClickable(inputSearch));
        inputSearch.clear();
        inputSearch.sendKeys(words);
        searchBtn.click();
    }

    public String getSearchMessage() {
        wait.until(ExpectedConditions.visibilityOf(searchMessage));
        return searchMessage.getText();
    }

    public void addProductPositive(String words) {
        cookiePermision.click();
        wait.until(ExpectedConditions.elementToBeClickable(inputSearch));
        inputSearch.clear();
        inputSearch.sendKeys(words);
        searchBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(product));
        product.click();
        selectMarime.click();
        addMarimeProdus();
        addProductBtn.click();
    }

    public void addMarimeProdus() {
        String searchText = "38";
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"OverlayContentWrapper\"]/div/ul[3]")));
        List<WebElement> options = dropdown.findElements(By.tagName("li"));
        for (WebElement option : options) {
            if (option.getText().equals(searchText)) {
                option.click();
                break;
            }
        }
    }
    public String getSuccesAddMessage() {
        wait.until(ExpectedConditions.visibilityOf(messageSuccesAddToCart));
        return messageSuccesAddToCart.getText();
    }
}
