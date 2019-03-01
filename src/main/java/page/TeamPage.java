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

import java.util.HashMap;
import java.util.List;

/**
 * Created by wwl on 2019/2/19.
 */
public class TeamPage extends Navbar {
    @FindBy(css = "div.title.media-heading")
    List<WebElement> topics2;

    HashMap<String, String> teamPage = config.elementConfig.TEAM_PAGE;
    By topics = By.cssSelector(teamPage.get("topics"));


    public TeamPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getCurrentDriver(), config.timeout), this);
        new WebDriverWait(Driver.getCurrentDriver(), config.timeout).until(ExpectedConditions.titleIs("TesterHome"));
    }

    @Step("点击话题列表第一个话题")
    public LoginPage clickFirstTopicFail() {
        finds(topics).get(0).click();
//        topics2.get(0).click();
        return new LoginPage();
    }


}
