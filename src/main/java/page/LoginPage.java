package page;

import driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
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
        PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getCurrentDriver(),config.timeout), this);
        new WebDriverWait(Driver.getCurrentDriver(), config.timeout).until(ExpectedConditions.titleContains("TesterHome"));
    }

    @Step("输入登录ID：{0}")
    public void inputLoginId(String id) {
        loginId.clear();
        loginId.sendKeys(id);
    }

    @Step("获取弹窗文本信息")
    public String getAlertText() {
        try {
            return alert.getText();
        } catch (StaleElementReferenceException e) {
            return alert.getText();
        }
    }


}
