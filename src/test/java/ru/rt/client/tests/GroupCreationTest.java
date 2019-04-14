package ru.rt.client.tests;

import org.testng.annotations.Test;
import ru.rt.client.model.GroupData;

public class GroupCreationTest extends TestBase {

    @Test
    public void testAddGroup() throws Exception {
        app.getNavigationHelper().navToGroupPage();
        app.getGroupHelper().initAddGroup();
        app.getGroupHelper().fillGroupForm(new GroupData("Group name", "header test", "footer test"));
        app.getGroupHelper().submitAddGroup();
    }

}
