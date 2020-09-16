package main.java.pageObject;

import main.java.config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SystemUserPage extends BasePage {

    By adminMenu = By.id("menu_admin_viewAdminModule");
    By userManagement = By.id("menu_admin_UserManagement");
    By viewUsers = By.id("menu_admin_viewSystemUsers");
    By tableCheckboxes = By.xpath("//input[@type='checkbox']");
    By usernameCells = By.xpath("//tbody//descendant::a");
    By deleteButton = By.id("btnDelete");
    By deleteModal = By.id("deleteConfModal");
    By dialogDeleteButton = By.id("dialogDeleteBtn");
    By userRoleCell = By.xpath("//tbody//descendant::a/following::td[1]");
    By employeeNameCell = By.xpath("//tbody//descendant::a/following::td[2]");
    By statusCell = By.xpath("//tbody//descendant::a/following::td[3]");
    By editBtn = By.id("btnSave");
    By editStatus = By.id("systemUser_status");
    By statusDisabled = By.cssSelector("@value = '0'");
    By statusEnabled = By.cssSelector("@value = '1'");

    public void clickOnAdminMenu() {
        click(adminMenu);
    }

    public void clickOnUserManagement() {
        click(userManagement);
    }

    public void clickOnViewUsers() {
        click(viewUsers);
    }

    public void clickOnDelete() {
        click(deleteButton);
    }

    public void clickOnEdit() {
        click(editBtn);
    }

    public void clickOnEditStatus() {
        click(editStatus);
    }

    public void clickOnSaveStatus() {
        click(editStatus);
    }

    public void clickOnDisabled() { click(statusDisabled); }

    public void clickOnEnabled() { click(statusEnabled); }

    public void clickOnConfirmDelete() {
        waitForElement(deleteModal, 2);
        click(dialogDeleteButton);
    }

    public List<WebElement> getCheckboxes() {
        return getListElements(tableCheckboxes);
    }

    public List<WebElement> getUsernameLinks() {
        return getListElements(usernameCells);
    }

    public List<String> getUsernames() { return getListOfStrings(usernameCells); }

    public String getUsername() { return getElementText(usernameCells); }

    public List<String> getUserRoles() {
        return getListOfStrings(userRoleCell);
    }

    public List<String> getEmployeeNames() {
        return getListOfStrings(employeeNameCell);
    }

    public List<String> getUserStatus() {
        return getListOfStrings(statusCell);
    }

    public String getFirstSelectedStatus() {
        return getFirstOption(editStatus);
    }


    public List<String> getUserDetailsData() {

       List<String> usernames = getUsernames();
       List<String> userRoles = getUserRoles();
       List<String> userStatuses = getUserStatus();
       List<String> empNames = getEmployeeNames();
       List<String> userDetails = new ArrayList<>();

       for (String username : usernames) {
            if(username.equals("jasmine.morgan")) {
                int index = usernames.indexOf("jasmine.morgan");
                userDetails.add(userRoles.get(index));
                userDetails.add(empNames.get(index));
                userDetails.add(userStatuses.get(index));
            }
       }
       return userDetails;
    }

    public void clickOnUser() {

        List<WebElement> userLinks = getUsernameLinks();

        for (WebElement userLink : userLinks) {
            if(userLink.getText().equals("jasmine.morgan")) {
                userLink.click();
            }
        }
    }

    public List<String> getCheckedUsernames() {

        List<WebElement> usernameLinks = getUsernameLinks();
        List<String> usernames = new ArrayList<>();

        for (WebElement usernameLink : usernameLinks) {
            if (usernameLink == usernameLinks.get(2)) {
                usernames.add(getUsername());
            } else if (usernameLink == usernameLinks.get(3)) {
                usernames.add(getUsername());
            } else if (usernameLink == usernameLinks.get(6)) {
                usernames.add(getUsername());
            }
        }
        return usernames;
    }

    public void clickThreeCheckboxes() {

        List<WebElement> checkboxes = getCheckboxes();

        for (WebElement checkbox : checkboxes) {
            if (checkbox == checkboxes.get(2)) {
                checkbox.click();
            } else if (checkbox == checkboxes.get(3)) {
                checkbox.click();
            } else if (checkbox == checkboxes.get(6)) {
                checkbox.click();
            }
        }
    }

    public List<Boolean> isChecked() {

        List<WebElement> checkboxes = getCheckboxes();
        List<Boolean> checkboxStatus = new ArrayList<>();

        for (WebElement checkbox : checkboxes) {
            if (checkbox == checkboxes.get(2)) {
                checkboxStatus.add(checkbox.isSelected());
            } else if (checkbox == checkboxes.get(3)) {
                checkboxStatus.add(checkbox.isSelected());
            } else if (checkbox == checkboxes.get(6)) {
                checkboxStatus.add(checkbox.isSelected());
            }
        }
        return checkboxStatus;
    }

    public void changeStatus() {

        String selected = getFirstSelectedStatus();

        if(selected.equals("Disabled")){
            clickOnEnabled();
        } else {
            clickOnDisabled();
        }
    }
}
