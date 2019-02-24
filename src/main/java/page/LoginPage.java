package page;

import driver.Driver;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by wwl on 2019/2/19.
 */
public class LoginPage extends Navbar {
    @FindBy(css = ".alert.alert-danger")
    WebElement alert;

    @FindBy(css = "#user_login")
    WebElement loginId;

    @FindBy(css = "#user_password")
    WebElement password;

    public LoginPage() {
        PageFactory.initElements(Driver.getCurrentDriver(), this);
        new WebDriverWait(Driver.getCurrentDriver(), 5).until(ExpectedConditions.titleContains("登录"));
    }

    public void inputLoginId(String id) {
        loginId.clear();
        loginId.sendKeys(id);
    }

    public String getAlertText() {
        try {
            return alert.getText();
        } catch (StaleElementReferenceException e) {
            return alert.getText();
        }
    }


}
