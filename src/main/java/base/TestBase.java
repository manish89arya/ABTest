package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.TestUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

public static WebDriver driver;
public static Properties prop;

public TestBase()
{
    try {
        prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src\\main\\resources\\config.properties");
        prop.load(fileInputStream);
    } catch (IOException e) {
        e.printStackTrace();
    }

}

    public void browserSetUp() {
        String driverPath = System.getProperty("user.dir");
        if(prop.getProperty("browserName").equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else
        {
            System.out.println("Please set your browser property!");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("URL"));
        driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);

    }
    

}
