package ru.rt.client;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class TestBase {
    public static final String LOGIN_USER_FIELD = "user";       // element name for 'user name' field login page
    public static final String LOGIN_PASS_FIELD = "pass";       // element name for 'user pass' field for login page
    public static final String GROUPS = ".//a[@href='group.php']"; // element xpath *link* for 'groups'
    public static final String GROUPS_NEW = "new";              // element name for 'add new group'
    public static final String GROUP_NEW_NAME = "group_name";   // element name for 'new group name'
    public static final String GROUP_NEW_HEADER = "group_header"; // element name for 'new group header'
    public static final String GROUP_NEW_FOOTER = "group_footer"; // element name for 'new group footer'
    public static final String GROUP_NEW_SUBMIT = "submit";     // element name for 'new group submit'

    public static final String GROUPS_SELECTED_FIRST = "(//span[@class='group']/input[@name='selected[]'])[1]";// element xpath for 'selected group', will always select first element
    public static final String GROUPS_DELETE = "delete";        // element name for 'delete selected group'

    protected WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost/addressbook/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
        login("admin", "secret");
    }

    private void login(String login, String password) {
        driver.findElement(By.name(LOGIN_USER_FIELD)).click();
        driver.findElement(By.name(LOGIN_USER_FIELD)).clear();
        driver.findElement(By.name(LOGIN_USER_FIELD)).sendKeys(login);
        driver.findElement(By.name(LOGIN_PASS_FIELD)).click();
        driver.findElement(By.name(LOGIN_PASS_FIELD)).clear();
        driver.findElement(By.name(LOGIN_PASS_FIELD)).sendKeys(password);
        driver.findElement(By.xpath(".//input[@value='Login']")).click();
    }

    protected void submitAddGroup() {
        driver.findElement(By.name(GROUP_NEW_SUBMIT)).click();
    }

    protected void fillGroupForm(GroupData groupData) {
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

    protected void initAddGroup() {
        driver.findElement(By.name(GROUPS_NEW)).click();
    }

    protected void navToGroupPage() {
        driver.findElement(By.xpath(GROUPS)).click();
    }

    protected void deleteSelectedGroup() {
        driver.findElement(By.name(GROUPS_DELETE)).click();
    }

    protected void selectGroup() {
        driver.findElement(By.xpath(GROUPS_SELECTED_FIRST)).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }


}
