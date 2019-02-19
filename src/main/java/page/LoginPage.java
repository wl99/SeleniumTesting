package page;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by wwl on 2019/2/19.
 */
public class LoginPage {
    @FindBy(css = ".alert.alert-danger")
    WebElement alert;

    @FindBy(css = "#user_login")
    WebElement loginId;

    @FindBy(css = "#user_password")
    WebElement password;

    public LoginPage() {
        PageFactory.initElements(Driver.getCurrentDriver(), this);
    }

    public void inputLoginId(String id) {
        loginId.clear();
        loginId.sendKeys(id);
    }

    public String getAlertText() {
        return alert.getText();
    }


}
