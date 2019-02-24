package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static page.HomePage.find;

/**
 * Created by wwl on 2019/2/19.
 *
 * @author wwl
 */
public class TeamListPage extends Navbar {

    @FindBy(css = "[data-name=\"霍格沃兹测试学院\"]")
//    @CacheLookup
    WebElement hogwarts;

    @FindBy(css = ".team-name")
    List<WebElement> teamList;

    public TeamListPage() {
        PageFactory.initElements(Driver.getCurrentDriver(), this);
        new WebDriverWait(Driver.getCurrentDriver(), 6).until(ExpectedConditions.titleContains("社团"));
    }

    public TeamPage gotoHogwarts() {
        hogwarts.click();
        return new TeamPage();
    }

    public TeamPage gotoTeamPageByName(String teamName) {
        find(By.cssSelector("[data-name=\"" + teamName + "\"]")).click();
        return new TeamPage();
    }


}
