package main.java.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static Driver instance = null;

    private final ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    private Driver() {

    }

    public static Driver getInstance() {
        if (instance == null) {
            instance = new Driver();
        }
        return instance;
    }

    public void setDriver() {

        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\chromedriver.exe");

        webDriver.set(new ChromeDriver());
        getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }

    public WebDriver getDriver() {
        return webDriver.get();
    }

    public void closeDriver() {
        try {
            getDriver().quit();
        } catch (Exception e) {
            System.out.println("Driver could not be closed!");
        }
    }
}
