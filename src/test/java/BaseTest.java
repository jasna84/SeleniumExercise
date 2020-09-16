package test.java;

import main.java.config.Driver;
import main.java.pageObject.LoginPage;

public class BaseTest {

    public void setupDriver() {
        Driver.getInstance().setDriver();
    }

    public void goToLoginPage() {

        Driver.getInstance().setDriver();
        LoginPage login = new LoginPage();
        login.navigateToLoginPage();
        login.exist();

    }

    public void loginBeforeTest() {

        Driver.getInstance().setDriver();
        LoginPage login = new LoginPage();
        login.navigateToLoginPage();
        login.enterUsername();
        login.enterPassword();
        login.clickOnSubmitButton();
    }

    public void teardown() {
        Driver.getInstance().closeDriver();
    }

}

