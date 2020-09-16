package test.java.testCases;

import main.java.pageObject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.BaseTest;

public class UserLogin extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void setUp() {
        loginPage.navigateToLoginPage();
    }

    @Test
    public void isLoggedIn() {

        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickOnSubmitButton();

        Assert.assertEquals(loginPage.currentURL, loginPage.homeURL);

    }

    @Test
    public void isNotLoggedInWithInvalidAccount() {

        loginPage.enterInvalidUsername();
        loginPage.enterInvalidPassword();
        loginPage.clickOnSubmitButton();

        boolean errorMessageDisplayed = loginPage.errorMessageIsVisible();

        Assert.assertTrue(errorMessageDisplayed);
        Assert.assertEquals(loginPage.currentURL, loginPage.loginURL);
    }

    @Test
    public void isNotLoggedInWithInvalidPassword() {

        loginPage.enterUsername();
        loginPage.enterInvalidPassword();
        loginPage.clickOnSubmitButton();

        boolean errorMessageDisplayed = loginPage.errorMessageIsVisible();

        Assert.assertTrue(errorMessageDisplayed);
        Assert.assertEquals(loginPage.currentURL, loginPage.loginURL);
    }

    @Test
    public void isNotLoggedInWithoutCredentials() {

        loginPage.clickOnSubmitButton();
        boolean errorMessageDisplayed = loginPage.errorMessageIsVisible();

        Assert.assertTrue(errorMessageDisplayed);
        Assert.assertEquals(loginPage.currentURL, loginPage.loginURL);

    }

    @AfterMethod
    public void tearDown() {
        teardown();
    }

}
