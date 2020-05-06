package com.debihiga.seleniumdemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class LoginTest extends SeleniumTestBase {

    // DOM nodes
    private WebElement inputUsername;
    private WebElement inputPassword;
    private WebElement buttonSignIn;

    private String USERNAME = "greg";
    private String PASSWORD = "turnquist";
    private String MESSAGE_ALERT = "Bad credentials";
    private String MESSAGE_TOOLTIP = "Completa este campo";

    @Before
    public void setup() {
        // Locate elements
        // https://www.selenium.dev/documentation/en/getting_started_with_webdriver/locating_elements/
        inputUsername = findElement(By.id("username"));
        inputPassword = findElement(By.id("password"));
        buttonSignIn = findElement(By.tagName("button")); // Only button in the page
    }

    @After
    public void tearDown() {
        quit();
    }

    /**
     * Checks that after a successful login
     * the username is displayed in the next page.
     * */
    @Test
    public void verifySuccessfulLogin() {
        // Run
        inputUsername.sendKeys(USERNAME);
        inputPassword.sendKeys(PASSWORD);
        buttonSignIn.click();
        // Test
        WebElement textManagerName = wait.until(driver -> driver.findElement(By.id("managerName")));
        assertEquals(USERNAME, textManagerName.getText());
    }

    /**
     * Checks that after trying to sign in with wrong credentials,
     * shows an alert.
     * */
    @Test
    public void verifyUnsuccessfulLogin() {
        // Run
        inputUsername.sendKeys(USERNAME);
        inputPassword.sendKeys(USERNAME);
        buttonSignIn.click();
        // Test
        WebElement textAlert = wait.until(driver -> driver.findElement(By.className("alert")));
        assertEquals(MESSAGE_ALERT, textAlert.getText());
    }

    /**
     * Checks that after missing one of the credentials,
     * shows a tooltip.
     * */
    @Test
    public void verifyMissingUsername() {
        // Run
        inputUsername.sendKeys("");
        inputPassword.sendKeys(PASSWORD);
        buttonSignIn.click();
        // Test
        /* TODO
        Actions act = new Actions(driver);
        WebElement tooltip = driver.findElement(By.className("tooltip"));
        act.moveToElement(tooltip).perform();
        String tooltiptextreal = tooltip.getText();
        System.out.println("Tooltip text is : "+tooltiptextreal);
        assertEquals(MESSAGE_TOOLTIP, tooltip.getText());
        */
    }
}