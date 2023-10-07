package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.StartPage;

public class StartPageTest extends BaseTest {

    StartPage startPage;

    @DataProvider(name = "searchP")
    public Object[][] searchPositiveDataProvider() {
        return new Object[][]{
                {"chrome", "Balerini", "Căutare: \"Balerini\""}

        };
    }

    @Test(dataProvider = "searchP")
    public void searchPositive(String browser, String word, String searchMessage) {
        setUpDriver(browser);
        driver.get(baseUrl);
        startPage = new StartPage(driver);
        startPage.search(word);
        Assert.assertEquals(startPage.getSearchMessage(), searchMessage);

    }

    @DataProvider(name = "addP")
    public Object[][] addProduct() {
        return new Object[][]{
                {"chrome", "Balerini", "Articolul a fost adăugat în coșul de cumpărături"}

        };
    }

    @Test(dataProvider = "addP")
    public void addProduct(String browser, String word, String message) {
        setUpDriver(browser);
        driver.get(baseUrl);
        startPage = new StartPage(driver);
        startPage.addProductPositive(word);
        Assert.assertEquals(startPage.getSuccesAddMessage(), message);

    }

    @DataProvider(name = "addWishlist")
    public Object[][] addWishlist() {
        return new Object[][]{
                {"chrome"}

        };
    }

    @Test(dataProvider = "addWishlist")
    public void addWishList(String browser) {
        setUpDriver(browser);
        driver.get(baseUrl);
        startPage = new StartPage(driver);
        startPage.addToWishList(browser);
    }

    @DataProvider(name = "addFilterColor")
    public Object[][] addFilter() {
        return new Object[][]{
                {"chrome", "Îmbrăcăminte Alb"}

        };
    }

    @Test(dataProvider = "addFilterColor")
    public void addFilter(String browser, String message) {
        setUpDriver(browser);
        driver.get(baseUrl);
        startPage = new StartPage(driver);
        startPage.filterColor();
        Assert.assertEquals(startPage.getFilterMessageRezultat(), message);
    }
}
