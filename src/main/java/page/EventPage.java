package page;

import driver.Driver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by wwl on 2019/2/19.
 */
public class EventPage {
    EventPage() {
        PageFactory.initElements(Driver.getCurrentDriver(), this);
    }

    public String getPageTitle() {
        return Driver.getCurrentDriver().getTitle();
    }

    /**
     * 关闭该页面，需返回至主页handle
     * @return
     */
    public HomePage gotoHomePage(String handle){
        Driver.getCurrentDriver().close();
        Driver.getCurrentDriver().switchTo().window(handle);
        return new HomePage();
    }
}
