package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by wwl on 2019/2/19.
 *
 * @author wwl
 */
public class Driver {
    private static WebDriver driver;

    public static void start(String url) {
        ChromeOptions chromeOptions = new ChromeOptions();
        // chrome_options.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--lang=zh_cn");
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        capability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        try {
            driver = new RemoteWebDriver(new URL(url), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }

    public static void quit() {
        driver.quit();
    }

    public static WebDriver getCurrentDriver() {
        return driver;
    }

    /**
     * 刷新页面
     */
    public static void refresh() {
        Driver.getCurrentDriver().navigate().refresh();
    }


}
