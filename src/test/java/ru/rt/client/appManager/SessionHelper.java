package ru.rt.client.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper {
    private static final String LOGIN_USER_FIELD = "user";       // element name for 'user name' field login page
    private static final String LOGIN_PASS_FIELD = "pass";       // element name for 'user pass' field for login page
    private WebDriver driver;

    public SessionHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String login, String password) {
        driver.findElement(By.name(LOGIN_USER_FIELD)).click();
        driver.findElement(By.name(LOGIN_USER_FIELD)).clear();
        driver.findElement(By.name(LOGIN_USER_FIELD)).sendKeys(login);
        driver.findElement(By.name(LOGIN_PASS_FIELD)).click();
        driver.findElement(By.name(LOGIN_PASS_FIELD)).clear();
        driver.findElement(By.name(LOGIN_PASS_FIELD)).sendKeys(password);
        driver.findElement(By.xpath(".//input[@value='Login']")).click();
    }
}
