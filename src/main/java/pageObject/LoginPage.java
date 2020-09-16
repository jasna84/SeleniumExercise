package main.java.pageObject;

import main.java.config.BasePage;
import main.java.config.Driver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public String loginURL = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
    public String homeURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
    public String invalidCredentialsUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials";

    public void navigateToLoginPage() {
        Driver.getInstance().getDriver().navigate().to(loginURL);
    }

    By usernameInput = By.id("txtUsername");
    By passwordInput = By.id("txtPassword");
    By submitButton = By.id("btnLogin");
    By errorMessage = By.id("spanMessage");

    public void enterUsername(String username){
        sendText(usernameInput, username);
    }
    public void enterPassword(String password){
        sendText(passwordInput, password);
    }
    public void clickOnSubmitButton(){
        click(submitButton);
    }
    public boolean errorMessageIsVisible () {
        return waitForElement(errorMessage, 3);
    }

}
