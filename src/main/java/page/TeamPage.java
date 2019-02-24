package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

/**
 * Created by wwl on 2019/2/19.
 */
public class TeamPage extends Navbar{
//    By topics = By.cssSelector("span.node");
    @FindBy(css = "div.title.media-heading")
    List<WebElement> topics;


    public TeamPage(){
        PageFactory.initElements(Driver.getCurrentDriver(), this);
    }

    public LoginPage clickFirstTopicFail(){

        try {
            Objects.requireNonNull(topics).get(0).click();
        } catch (StaleElementReferenceException e) {
            Objects.requireNonNull(topics).get(0).click();
            e.printStackTrace();
        }
        return new LoginPage();
    }





}
