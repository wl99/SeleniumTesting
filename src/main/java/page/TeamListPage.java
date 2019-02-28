package page;

import driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by wwl on 2019/2/19.
 *
 * @author wwl
 */
public class TeamListPage extends Navbar {

    @FindBy(css = "[data-name=\"霍格沃兹测试学院\"]")
    WebElement hogwarts;

    @FindBy(css = ".team-name")
    List<WebElement> teamList;

    public TeamListPage() {
        System.out.println("#########初始化团队列表页###########");
        PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getCurrentDriver(), 10), this);
        new WebDriverWait(Driver.getCurrentDriver(), 6).until(ExpectedConditions.titleContains("社团"));
    }

    @Step("点击‘霍格沃兹测试学院’，往社团页")
    public TeamPage gotoHogwarts() {
        System.out.println(hogwarts);
        hogwarts.click();
        return new TeamPage();
    }

    @Step("点击{0},跳转至{0}社团页面")
    public TeamPage gotoTeamPageByName(String teamName) {
        WebElement e = find(By.cssSelector("[data-name=\"" + teamName + "\"]"));
        System.out.println(e);
        e.click();
        return new TeamPage();
    }


}
