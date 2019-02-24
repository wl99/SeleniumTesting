package page;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by wwl on 2019/2/19.
 * @author wwl
 */
public class TeamListPage extends Navbar {

    @FindBy(css = "[data-name=\"霍格沃兹测试学院\"]")
    WebElement hogwarts;

    @FindBy(css = ".row .team-name")
    List<WebElement> teamList;

    public TeamListPage() {
        PageFactory.initElements(Driver.getCurrentDriver(), this);
        new WebDriverWait(Driver.getCurrentDriver(),5).until(ExpectedConditions.titleContains("社团"));
    }

    public TeamPage gotoHogwarts() {
        hogwarts.click();
        return new TeamPage();
    }

    private boolean clickTeamName(String teamName){
        for(WebElement e:teamList){
            if(e.getText().equalsIgnoreCase(teamName)){
                System.out.println(e.getText());
                e.click();
                return true;
            }
        }
        return false;
    }

    public TeamPage gotoTeamPageByName(String teamName){
        if(clickTeamName(teamName)){
            return new TeamPage();
        }
        return null;
    }


}
