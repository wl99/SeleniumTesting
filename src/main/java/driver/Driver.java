package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by wwl on 2019/2/19.
 * @author wwl
 */
public class Driver {
    private static WebDriver driver;

    public static void start(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    public static void quit(){
        driver.quit();
    }

    public static WebDriver getCurrentDriver(){
        return driver;
    }

    /**
     * 刷新页面
     */
    public static void refresh(){
        Driver.getCurrentDriver().navigate().refresh();
    }


}
