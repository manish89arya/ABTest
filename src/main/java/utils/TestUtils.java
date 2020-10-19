package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils {
    public static long PAGE_LOAD_TIMEOUT=20;
    public static long IMPLICIT_WAIT=10;

    public static void waitForVisible(WebDriver driver, WebElement element) {
        try {
            Thread.sleep(1000);
            System.out.println("Waiting for element visibility");
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
