package ru.rt.client.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    private static final String GROUPS = ".//a[@href='group.php']"; // element xpath *link* for 'groups'
    private WebDriver driver;

    public NavigationHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void navToGroupPage() {
        driver.findElement(By.xpath(GROUPS)).click();
    }
}
