package test.java.testCases;

import main.java.pageObject.SystemUserPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class SystemUsers extends BaseTest {

    SystemUserPage home = new SystemUserPage();

    @BeforeMethod
    public void setUp() {
        loginBeforeTest();
    }

    @Test
    public void deleteUsers() {

        home.clickOnAdminMenu();
        home.clickOnUserManagement();
        home.clickOnViewUsers();

        List<String> usernamesAll = home.getUsernames();
        System.out.println(usernamesAll);

        home.clickThreeCheckboxes();

        Assert.assertTrue(home.isChecked().get(0));
        Assert.assertTrue(home.isChecked().get(1));
        Assert.assertTrue(home.isChecked().get(2));

        List<String> usernamesChecked = home.getCheckedUsernames();
        System.out.println(usernamesChecked);

        home.clickOnDelete();
        home.clickOnConfirmDelete();

        List<String> actualUserList = home.getUsernames();
        System.out.println(actualUserList);

        List<String> expectedUserList = new ArrayList<>(usernamesAll);
        System.out.println(expectedUserList);

        Assert.assertEquals(actualUserList, expectedUserList);

    }

    @Test
    public void editUsers() {

        home.clickOnAdminMenu();
        home.clickOnUserManagement();
        home.clickOnViewUsers();

        List<String> userDetailsDataBefore = home.getUserDetailsData();
        System.out.println(userDetailsDataBefore);

        home.clickOnUser();
        home.clickOnEdit();
        home.clickOnEditStatus();
        home.changeStatus();
        home.clickOnSaveStatus();

        List<String> userDetailsDataAfter = home.getUserDetailsData();
        System.out.println(userDetailsDataAfter);

        Assert.assertNotEquals(userDetailsDataBefore, userDetailsDataAfter);

    }

    @AfterMethod
    public void tearDown(){
        teardown();
    }

}
