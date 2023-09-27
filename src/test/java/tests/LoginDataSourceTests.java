package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import objectModel.LoginModel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage1;
import pageObjects.MyAccountPage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LoginDataSourceTests extends BaseTest {
    String browser = "chrome";
    LoginPage1 loginPage1;
    MyAccountPage myAccountPage;
    LoginModel loginModel;


    @DataProvider(name = "jsonDp")
    public Iterator<Object[]> jsonDpCollection() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();
//      here we start json deserialization of json into LoginModel obj
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src\\test\\resources\\data\\testdata.json");

        LoginModel[] lms = objectMapper.readValue(file, LoginModel[].class);

        for (LoginModel lm : lms)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }

    @Test(dataProvider = "jsonDp")
    public void loginWithJsonAsDataSource(LoginModel lm) {
        loginLogM(lm);
    }

    private void loginLogM(LoginModel loginModel) {
        System.out.println(loginModel);
        login(loginModel.getAccount().getUsername(), loginModel.getAccount().getPassword(), loginModel.getUserError(), loginModel.getPasswordError());
    }

    private void login(String mail, String password, String erorMail, String errorPass) {
        System.out.println("Login with mail:" + mail + "/password:" + password);
        setUpDriver(browser);
        driver.get(baseUrl);
        loginPage1 = new LoginPage1(driver);
        loginPage1.goToLoginPage();
        loginPage1.login(mail, password);
        System.out.println("login terminat");
        Assert.assertEquals(loginPage1.getMailErr(), erorMail);
        Assert.assertEquals(loginPage1.getPasswordErr(), errorPass);
    }
}
