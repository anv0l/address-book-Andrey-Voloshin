package ru.rt.client.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.rt.client.model.GroupData;

public class GroupHelper extends HelperBase {
    private static final String GROUP_NEW_SUBMIT = "submit";     // element name for 'new group submit'
    private static final String GROUPS_NEW = "new";              // element name for 'add new group'
    private static final String GROUP_NEW_NAME = "group_name";   // element name for 'new group name'
    private static final String GROUP_NEW_FOOTER = "group_footer"; // element name for 'new group footer'
    private static final String GROUPS_SELECTED_FIRST = "(//span[@class='group']/input[@name='selected[]'])[1]";// element xpath for 'selected group', will always select first element
    private static final String GROUPS_DELETE = "delete";        // element name for 'delete selected group'

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name(GROUP_NEW_NAME), groupData.getName());
        type(By.name(GROUP_NEW_HEADER), groupData.getHeader());
        type(By.name(GROUP_NEW_FOOTER), groupData.getFooter());
    }

    public void initAddGroup() {
        click(By.name(GROUPS_NEW));
    }

    public void deleteSelectedGroup() {
        click(By.name(GROUPS_DELETE));
    }

    public void selectGroup() {
        click(By.xpath(GROUPS_SELECTED_FIRST));
    }

    public void submitAddGroup() {
        click(By.name(GROUP_NEW_SUBMIT));
    }
}
