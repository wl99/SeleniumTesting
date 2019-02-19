package page;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by wwl on 2019/2/19.
 * @author wwl
 */
public class TeamListPage extends Navbar {

    @FindBy(css = "[data-name=\"霍格沃兹测试学院\"]")
    WebElement hogwarts;

    public TeamListPage() {
        PageFactory.initElements(Driver.getCurrentDriver(), this);
    }

    public TeamPage gotoHogwarts() {
        hogwarts.click();
        return new TeamPage();
    }


}
