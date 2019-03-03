import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.impl.WebDriverContainer;
import com.codeborne.selenide.impl.WebDriverThreadLocalContainer;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.WebDriverContainer;
import com.codeborne.selenide.impl.WebDriverThreadLocalContainer;
import org.openqa.selenium.JavascriptExecutor;


import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class SeleniumGridTest {
    @Test
    void test(){
        WebDriverContainer webdriverContainer = new WebDriverThreadLocalContainer();
        Configuration.screenshots = false;
        webdriverContainer.clearBrowserCache();
//
        Configuration.browser="chrome";
        Configuration.remote = "http://192.168.2.104:5001/wd/hub";

        String baseUrl = "http://192.168.2.104:8099/";

        open(baseUrl);

        $(byText("Welcome Gaofei!")).should(Condition.visible);


        System.out.print("");
    }
}
