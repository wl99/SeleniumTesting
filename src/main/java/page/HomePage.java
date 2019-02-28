package page;

import config.Config;
import driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by wwl on 2019/2/19.
 * @author wwl
 */
public class HomePage extends Navbar {
    @FindBy(css = ".content img")
    private WebElement banner;

    private static Config config = Config.load("/config/config.yaml");

    private static final String URL = config.url;


    HomePage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getCurrentDriver(),10), this);
        new WebDriverWait(Driver.getCurrentDriver(), 6).until(ExpectedConditions.titleContains("TesterHome"));
    }

    @Step("打开主页并最大化")
    public static HomePage start() {
        Driver.start();
        Driver.getCurrentDriver().get(URL);
        Driver.getCurrentDriver().manage().timeouts().implicitlyWait(config.time, TimeUnit.SECONDS);
        return new HomePage();
    }

    public static void quit() {
        Driver.quit();
    }



    /**
     * 获取最近的handle
     * 点击banner后，对比handle，不一致则切换窗口
     *
     * @return EventPage
     */
    @Step("点击Banner")
    public EventPage clickBanner() {
        String handle1 = getCurrentWindowHandle();
        banner.click();
        for (String handle : getCurrentWindowHandles()) {
            if (!handle.equalsIgnoreCase(handle1)) {
                switchToWindow(handle);
            }
        }
        return new EventPage();
    }

    @Step("输入{0}并搜索")
    public HomePage sendKeysToSearchInput(String keyword) {
        searchInput.clear();
        searchInput.sendKeys(keyword);
        return new HomePage();
    }


}
