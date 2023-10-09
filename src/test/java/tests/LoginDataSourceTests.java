package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import objectModel.LoginModel;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage1;
import pageObjects.MyAccountPage;
import Utils.Tools;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LoginDataSourceTests extends BaseTest {
    private String browser = "chrome";
    private LoginPage1 loginPage1;


    @DataProvider(name = "jsonDp")
    public Iterator<Object[]> jsonDpCollection() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();
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


    @DataProvider(name = "mysql")
    public Iterator<Object[]> mysqlDpCollection() throws Exception {

        System.out.println("Use dbHostname:" + dbHostname);
        System.out.println("Use dbUser:" + dbUser);
        System.out.println("Use dbPort:" + dbPort);
        System.out.println("Use dbSchema:" + dbSchema);
        Collection<Object[]> dp = new ArrayList<>();
        Connection connection = DriverManager.getConnection("jdbc:mysql://" + dbHostname + ":" + dbPort +
                "/" + dbSchema, dbUser, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM login_negative");
        while (resultSet.next()) {
            LoginModel lm = new LoginModel(getEscapedElement(resultSet, "username"),
                    getEscapedElement(resultSet, "password"),
                    getEscapedElement(resultSet, "usernameErr"),
                    getEscapedElement(resultSet, "passwordErr"));
            dp.add(new Object[]{lm});
        }
        return dp.iterator();
    }

    @Test(dataProvider = "mysql")
    public void loginWithSQLAsDataSource(LoginModel lm) {
        loginLogM(lm);
    }

    private String getEscapedElement(ResultSet resultSet, String element) throws SQLException {
        return Tools.replaceElements(resultSet.getString(element), "''", "");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
