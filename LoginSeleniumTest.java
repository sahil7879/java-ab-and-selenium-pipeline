package com.example.loginapp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSeleniumTest {

    @Test
    public void testLoginPage() throws MalformedURLException {
        // Set up WebDriver with Selenium Grid
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());

        // Navigate to login page
        driver.get("http://localhost:8080/login");

        // Find the username and password fields
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        // Enter test credentials
        usernameField.sendKeys("testuser");
        passwordField.sendKeys("password");

        // Submit the form
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        // Wait for the success page and verify
        WebElement successMessage = driver.findElement(By.tagName("h2"));
        assertEquals("Welcome, you have successfully logged in!", successMessage.getText());

        // Close the browser
        driver.quit();
    }
}
