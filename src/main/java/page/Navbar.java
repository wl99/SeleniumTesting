package page;

import driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

/**
 * Created by wwl on 2019/2/19.
 */
public class Navbar {
    @FindBy(tagName = "input")
    WebElement searchInput;

    @FindBy(css = "#main-nav-menu .navbar-nav [href=\"/teams\"]")
    WebElement teams;

    @FindBy(css = "#main-nav-menu .navbar-nav [href=\"/questions\"]")
    WebElement questions;

    @FindBy(css = ".navbar-brand")
    WebElement index;

    @FindBy(css = "#main-nav-menu .navbar-nav li")
    List<WebElement> nvbList;

    Navbar() {
        PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getCurrentDriver(),10), this);
        new WebDriverWait(Driver.getCurrentDriver(), 6).until(ExpectedConditions.titleContains("TesterHome"));
    }

    @Step("查找元素：{0}")
    static WebElement find(By by){
        try {
            return Driver.getCurrentDriver().findElement(by);
        } catch (StaleElementReferenceException e) {
            Driver.refresh();
            return find(by);
        }
    }

    static List<WebElement> finds(By by){
        try {
            return Driver.getCurrentDriver().findElements(by);
        } catch (StaleElementReferenceException e) {
            Driver.refresh();
            return finds(by);
        }
    }

    /**
     * 获取最近窗口标题
     *
     * @return 标题
     */
    public String getCurrentWindowsTitle() {
        return Driver.getCurrentDriver().getTitle();
    }

    @Step("获取最近的操作的Handle")
    public String getCurrentWindowHandle() {
        return Driver.getCurrentDriver().getWindowHandle();
    }

    @Step("获取最近的操作的Handles")
    public Set<String> getCurrentWindowHandles() {
        return Driver.getCurrentDriver().getWindowHandles();
    }

    @Step("切换窗口至{0}")
    public void switchToWindow(String handles) {
        Driver.getCurrentDriver().switchTo().window(handles);
    }

    @Step("去往社团页面，返回社团列表页面")
    public TeamListPage gotoTeams() {
        teams.click();
        return new TeamListPage();
    }

    @Step("去往首页")
    public HomePage gotoHomePage() {
        index.click();
        return new HomePage();
    }

    @Step("去往问答页面")
    public void gotoQuestions(){
        questions.click();
    }

    @Step("执行ENTER操作，去搜索结果页")
    public SearchResultPage actionSendEnter() {
        Actions action = new Actions(Driver.getCurrentDriver());
        action.sendKeys(Keys.ENTER).perform();
        return new SearchResultPage();
    }


}
