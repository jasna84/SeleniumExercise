package main.java.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

    public void setDriver(String browser) throws Exception {

        String path = System.getProperty("user.dir");

        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\drivers\\chromedriver.exe");
            webDriver.set(new ChromeDriver());
        } else if(browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", path + "\\src\\main\\resources\\drivers\\geckodriver.exe");
            webDriver.set(new FirefoxDriver());
        } else if(browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", path + "\\src\\main\\resources\\drivers\\msedgedriver.exe");
            webDriver.set(new EdgeDriver());
        } else {
            throw new Exception("Browser is not correct");
        }
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
