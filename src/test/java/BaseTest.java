package test.java;

import main.java.config.Driver;
import main.java.pageObject.LoginPage;

public class BaseTest {

    public void goToLoginPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
        loginPage.exist();
    }

    public void loginAsAdminBeforeTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnSubmitButton();
    }

    public void teardown() {
        Driver.getInstance().closeDriver();
    }

}

