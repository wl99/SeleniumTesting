package page;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by wwl on 2019/2/19.
 */
public class HomePage extends Navbar {

    private static final String URL = "https://testerhome.com/";
    @FindBy(css = ".content img")
    WebElement banner;

    HomePage(){
        PageFactory.initElements(Driver.getCurrentDriver(), this);
    }
    public static HomePage start() {
        Driver.start();
        Driver.getCurrentDriver().get(URL);
        return new HomePage();
    }

    public static void qiut(){
        Driver.qiut();
    }

    /**
     * 获取最近的handle
     * 点击banner后，对比handle，不一致则切换窗口
     * @return EventPage
     */
    public EventPage clickBanner(){
        String handle1 = getCurrentWindowHandle();
        banner.click();
        for (String handle : getCurrentWindowHandles()) {
            if (!handle.equalsIgnoreCase(handle1)) {
                switchToWindow(handle);
            }
        }
        return new EventPage();
    }

    public HomePage sendKeysToSearchInput(String keyword){
        searchInput.clear();
        searchInput.sendKeys(keyword);
        return new HomePage();
    }



}
