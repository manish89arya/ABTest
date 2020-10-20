import base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GmailLogin;

public class GmailLoginTest extends TestBase {

    GmailLogin gmailLogin;
    @BeforeMethod
    public void setUp()
    {
        browserSetUp();
        gmailLogin = new GmailLogin();
    }



    @Test
    public void clickEmail() {
        driver.get("https://accounts.google.com/");
        gmailLogin.enterEmail("manish89aryatest001@gmail.com");
        gmailLogin.clickOnNext();
        gmailLogin.enterPassword("Test@1234");
        gmailLogin.clickEmail("<EMAIL SUBJECT YOU WANT TO CLICK>");//Replace with email subject you want to click

    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }




}
