package main.java.pageObject;

import main.java.config.BasePage;
import main.java.config.Driver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public String loginURL = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
    public String homeURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";

    public void navigateToLoginPage() {
        Driver.getInstance().getDriver().navigate().to(loginURL);
    }

    By usernameInput = By.id("txtUsername");
    By passwordInput = By.id("txtPassword");
    By submitButton = By.id("btnLogin");
    By errorMessage = By.id("spanMessage");

    public void enterUsername(){
        sendText(usernameInput, "Admin");
    }
    public void enterPassword(){
        sendText(passwordInput, "admin123");
    }
    public void clickOnSubmitButton(){
        click(submitButton);
    }
    public void enterInvalidUsername(){
        sendText(usernameInput, "dfsdfsffs@stagod.com");
    }
    public void enterInvalidPassword(){
        sendText(passwordInput, "fgfdgdgdfgdgdf");
    }
    public boolean errorMessageIsVisible () {
        return waitForElement(errorMessage, 3);
    }
    public String currentURL = getUrl();

}
