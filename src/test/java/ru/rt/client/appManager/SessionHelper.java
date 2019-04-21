package ru.rt.client.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {
    private static final String LOGIN_USER_FIELD = "user";       // element name for 'user name' field login page
    private static final String LOGIN_PASS_FIELD = "pass";       // element name for 'user pass' field for login page
    private static final String LOGIN_BUTTON = ".//input[@value='Login']"; // element xpath for login button

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(String login, String password) {
        type(By.name(LOGIN_USER_FIELD), login);
        type(By.name(LOGIN_PASS_FIELD), password);
        click(By.xpath(LOGIN_BUTTON));
    }
}
