package com.debihiga.seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SeleniumTestBase {

    public WebDriver driver;
    public WebDriverWait wait;
    private String url = "http://localhost:8080";

    static {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver/81.0.4044.69/chromedriver.exe");
    }

    public SeleniumTestBase() {
        driver = new ChromeDriver();
        // Set 5 seconds as a time-out for WebDriver to wait for an element on the page to appea
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        // Navigate to application
        driver.get(url);
    }

    public WebElement findElement(By condition) {
        return driver.findElement(condition);
    }

    /**
     * Quit will:
     * + Close all the windows and tabs associated with that WebDriver session
     * + Close the browser process
     * + Close the background driver process
     * + Notify Selenium Grid that the browser is no longer in use so it can be used by another session
     * (if you are using Selenium Grid)
     * */
    public void quit() {
        driver.quit();
    }
}
