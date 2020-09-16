package main.java.pageObject;

import main.java.config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DirectoryPage extends BasePage {

    By directoryTab = By.id("menu_directory_viewDirectory");
    By jobTitleMenu = By.id("searchDirectory_job_title");
    By locationMenu = By.id("searchDirectory_location");
    By menuOptions = By.tagName("option");
    By searchBtn = By.id("searchBtn");
    By tableInfoJob = By.xpath("//tbody/descendant::ul/li[2]");
    By tableInfoLocation = By.xpath("//tbody/descendant::ul/li[4]");


    public void clickOnDirectoryTab() { click(directoryTab);}
    public void clickOnJobTitleMenu() { click(jobTitleMenu);}
    public void clickOnLocationMenu() { click(locationMenu);}
    public void clickOnSearchBtn() { click(searchBtn);}

    public List<WebElement> getOptions() { return getListElements(menuOptions); }
    public List<String> getUsersJobs() {
        return getListOfStrings(tableInfoJob);
    }
    public List<String> getUsersLocations() {
        return getListOfStrings(tableInfoLocation);
    }
    public String getFirstSelectedJob() {
        return getFirstOption(jobTitleMenu);
    }
    public String getFirstSelectedLocation() {
        return getFirstOption(locationMenu);
    }

    public void selectJobOption() {

        List<WebElement> options = getOptions();

        for (WebElement option : options) {
            if (option.getText().equals("HR Manager")){
                option.click();
            }
        }
    }

    public void selectLocationOption() {

        List<WebElement> options = getOptions();

        for (WebElement option : options) {
            if (option.getText().equals("    Texas R&D")) {
                option.click();
            }
        }
    }

    public boolean verifyAllJobsEqualAndCorrect() {

        List<String> jobs = getUsersJobs();

        for (String job : jobs) {
            if (!job.equals(jobs.get(0))) {
                return false;
            } else if(!job.equals("HR Manager")) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyAllLocationsEqualAndCorrect() {

        List<String> locations = getUsersLocations();

        for (String location : locations) {
            if (!location.equals(locations.get(0))){
                return false;
            } else if(!location.equals("Texas R&D")) {
                return false;
            }
        }
        return true;
    }


}
