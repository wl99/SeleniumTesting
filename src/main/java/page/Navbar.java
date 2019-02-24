package page;

import driver.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
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

    @FindBy(css = "#main-nav-menu .navbar-nav li")
    List<WebElement> nvbList;

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

    private boolean clickNvbByText(String name) {
        for (WebElement e : nvbList) {
            if (e.getText().trim().equalsIgnoreCase(name)) {
                try {
                    e.click();
                } catch (StaleElementReferenceException e1) {
                    e.click();
                    e1.printStackTrace();
                }
                return true;
            }
        }
        return false;
    }

    public TeamListPage gotoTeams2(){
        if (clickNvbByText("社团")) {
            return new TeamListPage();
        }
        return null;
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
