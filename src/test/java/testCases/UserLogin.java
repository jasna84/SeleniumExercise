package test.java.testCases;

import main.java.config.BasePage;
import main.java.config.Driver;
import main.java.pageObject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;
import test.java.BaseTest;

public class UserLogin extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) throws Exception {
        Driver.getInstance().setDriver(browser);
        goToLoginPage();
    }

    @Test(dataProvider="ValidLoginProvider")
    public void isLoggedIn(String username, String password) {

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnSubmitButton();

        String currentURL = BasePage.getUrl();
        Assert.assertEquals(currentURL, loginPage.homeURL);

    }

    @Test(dataProvider="InvalidLoginProvider")
    public void isNotLoggedInWithInvalidCredentials(String username, String password) {

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnSubmitButton();

        boolean errorMessageDisplayed = loginPage.errorMessageIsVisible();

        Assert.assertTrue(errorMessageDisplayed);

        String currentURL = BasePage.getUrl();
        Assert.assertEquals(currentURL, loginPage.invalidCredentialsUrl);
    }

    @Test
    public void isNotLoggedInWithoutCredentials() {

        loginPage.clickOnSubmitButton();
        boolean errorMessageDisplayed = loginPage.errorMessageIsVisible();

        Assert.assertTrue(errorMessageDisplayed);

        String currentURL = BasePage.getUrl();
        Assert.assertEquals(currentURL, loginPage.loginURL);

    }

    @DataProvider(name="ValidLoginProvider")
    public Object[] getValidData() {

        Object[][] data = new Object[2][2];

        //admin user

        data[0][0] = "Admin";
        data[0][1] = "admin123";

        //non-admin user

        data[1][0] = "jasna.test";
        data[1][1] = "jasna123";

        return data;
    }

    @DataProvider(name="InvalidLoginProvider")
    public Object[] getInvalidData() {

        Object[][] data = new Object[3][2];

        data[0][0] = "dsfjoghroghwoghwoh";
        data[0][1] = "hdsjdhsjdshdshdjsd";

        data[1][0] = "Admin";
        data[1][1] = "bvbvcbvxnx";

        data[2][0] = "jasna.test";
        data[2][1] = "bvbvcbvxnx";

        return data;
    }

    @AfterMethod
    public void tearDown() {
        teardown();
    }

}
