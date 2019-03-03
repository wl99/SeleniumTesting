import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.impl.WebDriverContainer;
import com.codeborne.selenide.impl.WebDriverThreadLocalContainer;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class SeleniumGridTest {
    @Test
    void test() {

        ChromeOptions chrome_options = new ChromeOptions();
//        chrome_options.addArguments("--headless");
        chrome_options.addArguments("--no-sandbox");
        chrome_options.addArguments("--disable-gpu");
        chrome_options.addArguments("--disable-dev-shm-usage");

        WebDriverContainer webdriverContainer = new WebDriverThreadLocalContainer();
        Configuration.screenshots = false;
        webdriverContainer.clearBrowserCache();

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chrome_options);


        Configuration.browser = "chrome";
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = "http://192.168.2.104:5001/wd/hub";

        String baseUrl = "http://192.168.2.104:8099/";
        com.codeborne.selenide.Selenide.open(baseUrl);

        $(byText("Welcome Gaofei!")).should(Condition.visible);


        System.out.print("");
    }
}
