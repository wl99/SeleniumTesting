package page;

import driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by wwl on 2019/2/19.
 */
public class TeamPage extends Navbar{
    // By topics = By.cssSelector("span.node");
    @FindBy(css = "div.title.media-heading")
    List<WebElement> topics2;


    public TeamPage(){
        System.out.println("#########初始化团队话题列表页###########");
        PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getCurrentDriver(),10), this);
        new WebDriverWait(Driver.getCurrentDriver(), 6).until(ExpectedConditions.titleIs("TesterHome"));
    }

    @Step("点击话题列表第一个话题")
    public LoginPage clickFirstTopicFail(){
        topics2.get(0).click();
        return new LoginPage();
    }





}
