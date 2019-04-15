package ru.rt.client.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.rt.client.model.GroupData;

public class GroupHelper {
    private static final String GROUP_NEW_SUBMIT = "submit";     // element name for 'new group submit'
    private static final String GROUPS_NEW = "new";              // element name for 'add new group'
    private static final String GROUP_NEW_NAME = "group_name";   // element name for 'new group name'
    private static final String GROUP_NEW_HEADER = "group_header"; // element name for 'new group header'
    private static final String GROUP_NEW_FOOTER = "group_footer"; // element name for 'new group footer'
    private static final String GROUPS_SELECTED_FIRST = "(//span[@class='group']/input[@name='selected[]'])[1]";// element xpath for 'selected group', will always select first element
    private static final String GROUPS_DELETE = "delete";        // element name for 'delete selected group'
    private WebDriver driver;

    public GroupHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void fillGroupForm(GroupData groupData) {
        driver.findElement(By.name(GROUP_NEW_NAME)).click();
        driver.findElement(By.name(GROUP_NEW_NAME)).clear();
        driver.findElement(By.name(GROUP_NEW_NAME)).sendKeys(groupData.getName());
        driver.findElement(By.name(GROUP_NEW_HEADER)).click();
        driver.findElement(By.name(GROUP_NEW_HEADER)).clear();
        driver.findElement(By.name(GROUP_NEW_HEADER)).sendKeys(groupData.getHeader());
        driver.findElement(By.name(GROUP_NEW_FOOTER)).click();
        driver.findElement(By.name(GROUP_NEW_FOOTER)).clear();
        driver.findElement(By.name(GROUP_NEW_FOOTER)).sendKeys(groupData.getFooter());
    }

    public void initAddGroup() {
        driver.findElement(By.name(GROUPS_NEW)).click();
    }

    public void deleteSelectedGroup() {
        driver.findElement(By.name(GROUPS_DELETE)).click();
    }

    public void selectGroup() {
        driver.findElement(By.xpath(GROUPS_SELECTED_FIRST)).click();
    }

    public void submitAddGroup() {
        driver.findElement(By.name(GROUP_NEW_SUBMIT)).click();
    }
}
