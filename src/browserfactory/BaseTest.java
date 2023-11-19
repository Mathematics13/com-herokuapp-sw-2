package browserfactory;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BaseTest
{
    static String baseurl = "https://the-internet.herokuapp.com/login";
    public static WebDriver driver;

    static String browser = "Chrome";

    @BeforeClass
    public static void browserSetUp()
    {
        System.setProperty("webdriver.chrome.driver" , "chromedriver.exe");
        if(browser.equalsIgnoreCase("Chrome"))
        {
            driver= new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("Edge"))
        {
            driver = new EdgeDriver();
        }
        else if(browser.equalsIgnoreCase("Firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("Safari"))
        {
            driver = new SafariDriver();
        }
        else
        {
            System.out.println("Wrong browser");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(baseurl);
    }
    @AfterClass
    public static  void closeBrowser()
    {
        driver.quit();
    }

}
