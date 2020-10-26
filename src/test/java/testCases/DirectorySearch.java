package test.java.testCases;

import main.java.config.Driver;
import main.java.pageObject.DirectoryPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.java.BaseTest;

public class DirectorySearch extends BaseTest {

    DirectoryPage directory = new DirectoryPage();

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) throws Exception {
        Driver.getInstance().setDriver(browser);
        loginAsAdminBeforeTest();
    }

    @Test
    public void searchUsers() {

        directory.clickOnDirectoryTab();
        directory.clickOnJobTitleMenu();
        directory.selectJobOption();
        directory.clickOnLocationMenu();
        directory.selectLocationOption();
        directory.clickOnSearchBtn();

        String actualJob = directory.getFirstSelectedJob();
        System.out.println("Selected job: " + actualJob);

        String actualLocation = directory.getFirstSelectedLocation();
        System.out.println("Selected location: " + actualLocation);

        Assert.assertEquals("HR Manager", actualJob );
        Assert.assertEquals("    Texas R&D", actualLocation );


        Assert.assertTrue(directory.verifyAllJobsEqualAndCorrect());
        System.out.println("Listed jobs are: " + directory.getUsersJobs() + " and they are all equal and correct: "
                + directory.verifyAllJobsEqualAndCorrect() );

        Assert.assertTrue(directory.verifyAllLocationsEqualAndCorrect());
        System.out.println("Listed locations are: " + directory.getUsersLocations() + " and they are all equal and correct: "
                + directory.verifyAllLocationsEqualAndCorrect() );

    }

    @AfterMethod
    public void tearDown(){
        teardown();
    }
}
