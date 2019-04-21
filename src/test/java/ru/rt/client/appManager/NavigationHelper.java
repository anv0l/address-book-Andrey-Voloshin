package ru.rt.client.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {
    private static final String GROUPS = ".//a[@href='group.php']"; // element xpath *link* for 'groups'

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void navToGroupPage() {
        click(By.xpath(GROUPS));
    }
}
