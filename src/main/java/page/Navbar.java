package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;

/**
 * Created by wwl on 2019/2/19.
 */
public class Navbar {
    @FindBy(tagName = "input")
    WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"main-nav-menu\"]/ul/li[4]/a")
    WebElement teams;

    @FindBy(css = ".navbar-brand")
    WebElement index;

    /**
     * 获取最近窗口标题
     *
     * @return 标题
     */
    public String getCurrentWindowsTitle() {
        return Driver.getCurrentDriver().getTitle();
    }

    public String getCurrentWindowHandle() {
        return Driver.getCurrentDriver().getWindowHandle();
    }

    public Set<String> getCurrentWindowHandles() {
        return Driver.getCurrentDriver().getWindowHandles();
    }

    public void switchToWindow(String handles) {
        Driver.getCurrentDriver().switchTo().window(handles);
    }


    public TeamListPage gotoTeams() {
        teams.click();
        return new TeamListPage();
    }

    public HomePage gotoHomePage() {
        index.click();
        return new HomePage();
    }

    public SearchResultPage actionSendEnter() {
        Actions action = new Actions(Driver.getCurrentDriver());
        action.sendKeys(Keys.ENTER).perform();
        return new SearchResultPage();
    }


}
