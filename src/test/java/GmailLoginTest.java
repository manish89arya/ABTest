import base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GmailPageObjects;

public class GmailLoginTest extends TestBase {

    GmailPageObjects gmailPageObjects;
    @BeforeMethod
    public void setUp()
    {
        browserSetUp();
        gmailPageObjects = new GmailPageObjects();
    }



    @Test
    public void clickEmail() {
        driver.get("https://accounts.google.com/");
        gmailPageObjects.enterEmail("manish89aryatest001@gmail.com");
        gmailPageObjects.clickOnNext();
        gmailPageObjects.enterPassword("Test@1234");//Replace with your password
        gmailPageObjects.clickEmail("<EMAIL SUBJECT YOU WANT TO CLICK>");//Replace with email subject you want to click

    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }




}
