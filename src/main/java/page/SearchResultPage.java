package page;

import driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by wwl on 2019/2/19.
 * @author wwl
 */
public class SearchResultPage extends Navbar{
    @FindBy(css =".media-body")
    private WebElement result;

    SearchResultPage(){
        PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getCurrentDriver(),10),this);
    }

    @Step("获取搜索的结果关键字")
    public String getResultText(){
        return result.getText();
    }


}
