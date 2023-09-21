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
                {"edge", "Balerini","Căutarea Dvs. dupa Balerini a generat 60 rezultate"}

        };
    }

    @Test(dataProvider = "searchP")
    public void searchPositive(String browser, String word,String searchMessage) {
        setUpDriver(browser);
        driver.get(baseUrl);
        startPage=new StartPage(driver);
        startPage.search(word);
        Assert.assertEquals(startPage.getSearchMessage(),searchMessage);

    }
    @DataProvider(name = "addP")
    public Object[][] addProduct() {
        return new Object[][]{
                {"edge", "Balerini","Articolul a fost adăugat la coșul cu produse."}

        };
    }
    @Test(dataProvider = "addP")
    public void addProduct(String browser, String word,String message) {
        setUpDriver(browser);
        driver.get(baseUrl);
        startPage=new StartPage(driver);
        startPage.addProductPositive(word);
        Assert.assertEquals(startPage.getSuccesAddMessage(),message);

    }

}
