package page;

import driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by wwl on 2019/2/19.
 */
public class EventPage {
    EventPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getCurrentDriver(), 10), this);
    }

    @Step("获取页面的Title")
    public String getPageTitle() {
        return Driver.getCurrentDriver().getTitle();
    }

    /**
     * 关闭该页面，需返回至主页handle
     *
     * @return
     */
    @Step("通过handle：{0}，返回首页")
    public HomePage gotoHomePage(String handle) {
        Driver.getCurrentDriver().close();
        Driver.getCurrentDriver().switchTo().window(handle);
        return new HomePage();
    }
}
