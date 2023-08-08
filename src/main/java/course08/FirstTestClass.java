package course08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class FirstTestClass {
    @Test
    public void htmlUnitDriverTest() {
        WebDriver htmlUnitDriver = new HtmlUnitDriver(); //porneste o pagina goala
        htmlUnitDriver.get("https://www.google.com/");//navigheaza catre url
        System.out.println(htmlUnitDriver.getTitle());//afiseaza titlu
        htmlUnitDriver.quit();

    }
    @Test
    public void chromeDriverTest() {
        //path catre chromedriver.exe al fiecaruia dintre voi
        System.setProperty("webdriver.chrome.driver",
                "C:\\TestareAutomata\\src\\test\\resources\\drives\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.google.com/");
        System.out.println("Page title: " + chromeDriver.getTitle());
        chromeDriver.navigate().to("https://www.facebook.com/");
        System.out.println("Page title after navigate to facebook page: "
                + chromeDriver.getTitle());
        chromeDriver.navigate().back();
        System.out.println("Page title after back method: " + chromeDriver.getTitle());
        chromeDriver.navigate().forward();
        System.out.println("Page title after forward method: " + chromeDriver.getTitle());
        chromeDriver.navigate().refresh();
        chromeDriver.quit();
    }

    @Test
    public void switchWindowHandles() {
        //path catre chromedriver.exe al fiecaruia dintre voi
        System.setProperty("webdriver.chrome.driver",
                "C:\\TestareAutomata\\src\\test\\resources\\drives\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://www.google.com/");
        for (String currentBrowserTab : chromeDriver.getWindowHandles()) {
            chromeDriver.switchTo().window(currentBrowserTab);
            System.out.println("Current tab title: " + chromeDriver.getTitle());
        }
        //close inchide browser tab-ul curent
        //quit inchide browserul cu totul, indiferent de nr de tab-uri deschise
//        chromeDriver.close();
 //       chromeDriver.quit();
    }
    @Test
    public void webElementTestGetText() {
        //path catre chromedriver.exe al fiecaruia dintre voi
        System.setProperty("webdriver.chrome.driver",
                "C:\\TestareAutomata\\src\\test\\resources\\drives\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("http://86.121.249.151:4999/");
        WebElement titleElement = chromeDriver.findElement(By.tagName("h1"));
        System.out.println(titleElement.getText());
        chromeDriver.quit();
    }

    @Test
    public void webElementTestSendTextToField() {
        //path catre chromedriver.exe al fiecaruia dintre voi
        System.setProperty("webdriver.chrome.driver",
                "C:\\TestareAutomata\\src\\test\\resources\\drives\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("http://86.121.249.151:4999/");
        WebElement loginElement = chromeDriver.findElement(By.tagName("h2"));
        loginElement.click();
        WebElement usernameElement = chromeDriver.findElement(By.id("user"));
        usernameElement.sendKeys("zebra");
        System.out.println("username field content: " + usernameElement.getAttribute("value"));
        Assert.assertEquals("Incorrect username", "zebra",
                usernameElement.getAttribute("value"));
        usernameElement.clear();
        Assert.assertEquals("Username was not deleted", "", usernameElement.getAttribute("value"));
        chromeDriver.quit();
    }
}
