package pageObjects;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StartPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//input[@type='search' and @placeholder='Caută' and @value='']")
    private WebElement inputSearch;

    @FindBy(xpath = "//i[@class='icon icon-search']")
    private WebElement searchBtn;

    @FindBy(xpath = "//*[@id=\"anchor_productGrid\"]/div[1]/h1")
    private WebElement searchMessageSucces;

    @FindBy(xpath = "//a[@aria-label='Graceland Balerini negru' and contains(@href, '/ro-ro/p/graceland-balerini-negru-18770')]\n")
    private WebElement product;

    @FindBy(xpath = "//div[@class='set-into-row']/deich-lib-button/button[contains(text(), 'Adaugă in coș')]")
    private WebElement addProductBtn;

    @FindBy(xpath = "//span[@class='select-size' and span/text()='Alege mărimea']")
    private WebElement selectMarime;

    @FindBy(xpath = "//ul[@class='size-system-list']")
    private WebElement selectNumberMarime;

    @FindBy(xpath = " //div[@_ngcontent-deichstorefront-c2072491025]//h2[contains(text(), 'Articolul a fost adăugat în coșul de cumpărături')]")
    private WebElement messageSuccesAddToCart;

    @FindBy(xpath = "//a[@class='routeactive']/span[text()='Femei']")
    private WebElement selectWomen;

    @FindBy(xpath = "//a[@href='/ro-ro/c/femei/imbracaminte-34']")
    private WebElement btnClothes;

//    @FindBy(xpath = " //button[contains(text(), '7 rezultat(e)')]")
//    private WebElement btnRezultat;

    @FindBy(xpath = "//h1[contains(text(), 'Îmbrăcăminte Alb')]")
    private WebElement messageFilterRezultat;

    public StartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void search(String words) {
        WebElement cmpwrapper = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cmpwrapper")));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement elementInShadowDOM = (WebElement) jsExecutor.executeScript(
                "return arguments[0].shadowRoot.querySelector('#cmpbntnotxt')",
                cmpwrapper
        );
        elementInShadowDOM.click();
        wait.until(ExpectedConditions.elementToBeClickable(inputSearch));
        inputSearch.clear();
        inputSearch.sendKeys(words);
        searchBtn.click();
    }

    public String getSearchMessage() {
        wait.until(ExpectedConditions.visibilityOf(searchMessageSucces));
        return searchMessageSucces.getText();
    }

    public void addProductPositive(String words) {
        WebElement cmpwrapper = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cmpwrapper")));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement elementInShadowDOM = (WebElement) jsExecutor.executeScript(
                "return arguments[0].shadowRoot.querySelector('#cmpbntnotxt')",
                cmpwrapper
        );
        elementInShadowDOM.click();
        wait.until(ExpectedConditions.elementToBeClickable(inputSearch));
        inputSearch.clear();
        inputSearch.sendKeys(words);
        searchBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(product));
        product.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='select-size' and span/text()='Alege mărimea']")));
        selectMarime.click();
        addMarimeProdus();
        addProductBtn.click();
    }

    public void addMarimeProdus() {
        wait.until(ExpectedConditions.elementToBeClickable(selectNumberMarime));
        WebElement dropdown = driver.findElement(By.xpath("//ul[@class='size-system-list']"));
        List<WebElement> options = dropdown.findElements(By.tagName("li"));
        String targetOptionText = "33";
        for (WebElement option : options) {
            if (option.getText().trim().equals(targetOptionText)) {
                option.click();
                break;
            }
        }
    }

    public String getSuccesAddMessage() {
        wait.until(ExpectedConditions.visibilityOf(messageSuccesAddToCart));
        return messageSuccesAddToCart.getText();
    }

    public void addToWishList(String browser) {
        WebElement cmpwrapper = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cmpwrapper")));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement elementInShadowDOM = (WebElement) jsExecutor.executeScript(
                "return arguments[0].shadowRoot.querySelector('#cmpbntnotxt')",
                cmpwrapper
        );
        elementInShadowDOM.click();
        WebElement selectWomen1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@src, 'k069aw23_blickfang5_catwalk_11109586_youngwomani_061')]")));
        selectWomen1.click();
        WebElement selectItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='Catwalk Pantofi cu toc argint' and contains(@href, '/ro-ro/p/catwalk-pantofi-cu-toc-argint-1269')]\n")));
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        selectItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//deich-lib-add-to-wish-list[@class='pos-upper-right']\n")));
        selectItem.click();
    }

    public void filterColor() {
        WebElement cmpwrapper = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cmpwrapper")));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement elementInShadowDOM = (WebElement) jsExecutor.executeScript(
                "return arguments[0].shadowRoot.querySelector('#cmpbntnotxt')",
                cmpwrapper
        );
        elementInShadowDOM.click();

        WebElement btnWomen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Femei')]")));
        btnWomen.click();
        // WebElement btnClothes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/ro-ro/c/femei/imbracaminte-34']")));
        // btnClothes.click();
        WebElement btnClothes = driver.findElement(By.xpath("//a[@href='/ro-ro/c/femei/imbracaminte-34']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", btnClothes);
        WebElement btnFilters = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(.)='Filtru']")));
        btnFilters.click();
        WebElement selectColour = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'radiooption') and .//span[@class='label' and text()='Alb']]")));
        selectColour.click();
        WebElement btnRezultat = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), '8 rezultat(e)')]")));
        btnRezultat.click();
    }

    public String getFilterMessageRezultat() {
        wait.until(ExpectedConditions.visibilityOf(messageFilterRezultat));
        return messageFilterRezultat.getText();
    }
}
