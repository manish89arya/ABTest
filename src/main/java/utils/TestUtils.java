package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class TestUtils {
    public static long PAGE_LOAD_TIMEOUT=20;
    public static long IMPLICIT_WAIT=10;

    private static final String PREFS = "prefs";
    private static final String JAVASCRIPT_SETTINGS =
            "profile.managed_default_content_settings.javascript";
    private static final short DISABLED = 2;


    public WebDriver newWebDriver() {
        return new ChromeDriver(getChromeOptions());
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption(PREFS, getChromePrefs());
        return options;
    }

    public static Map<String, Object> getChromePrefs() {
        Map<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put(JAVASCRIPT_SETTINGS, DISABLED);
        return chromePrefs;
    }

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
