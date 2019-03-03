import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.impl.WebDriverContainer;
import com.codeborne.selenide.impl.WebDriverThreadLocalContainer;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
        // 本机IP :192.168.2.104
        Configuration.remote = "http://192.168.2.104:5001/wd/hub";

//        String baseUrl = "http://192.168.2.104:8099/";
        String baseUrl = "https://testerhome.com/";
        com.codeborne.selenide.Selenide.open(baseUrl);
        String result=$(By.cssSelector(".navbar-brand")).getText();
        assertThat(result, equalTo("TesterHome"));

//        $(byText("Welcome Gaofei!")).should(Condition.visible);


        System.out.print("");
    }
}
