package pages;

import base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static utils.TestUtils.waitForVisible;

public class GmailLogin extends TestBase {

//    @FindBy(id="identifierId")
    @FindBy(how= How.XPATH, xpath="//input[@id='identifierId']")
    WebElement txtFldEmail;

    @FindBy(how=How.XPATH, xpath="//*[@id='password']/div[1]/div/div[1]/input")
    WebElement txtFldPassword;

    @FindBy(how=How.XPATH, xpath="//span[@class='bog']")
    List<WebElement> listEmailThreads;

    @FindBy(how=How.XPATH, xpath="//span[@class='gb_bb gbii']")
    WebElement profileLogo;

    @FindBy(id="identifierId")
    private WebElement btnNext;

    public GmailLogin()
    {
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String emailID)
    {
//        waitForVisible(driver, txtFldEmail);
        txtFldEmail.sendKeys(emailID);
//        Actions actions=new Actions(driver);
//        actions.moveToElement(txtFldEmail);
//        actions.click();
//        actions.sendKeys(emailID + Keys.ENTER);
//        actions.build().perform();
//        System.out.println("Email entered");
    }

    public void clickOnNext() {
        btnNext.click();
    }

    public void enterPassword(String password)
    {
        waitForVisible(driver, txtFldPassword);
        Actions actions=new Actions(driver);
        actions.moveToElement(txtFldPassword);
        actions.click();
        actions.sendKeys(password + Keys.ENTER);
        actions.build().perform();
        System.out.println("Password entered");
    }

    public void clickEmail(String emailSubject)
    {
        waitForVisible(driver, profileLogo);

        for (int i = 0; i < listEmailThreads.size(); i++) {

            if (listEmailThreads.get(i).getText().contains(emailSubject)) {
                listEmailThreads.get(i).click();
                System.out.println("email clicked");
                break;
            }
        }
    }


}