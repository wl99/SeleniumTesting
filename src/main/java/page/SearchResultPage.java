package page;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by wwl on 2019/2/19.
 * @author wwl
 */
public class SearchResultPage extends Navbar{
    @FindBy(css =".media-body")
    private WebElement result;

    public SearchResultPage(){
        PageFactory.initElements(Driver.getCurrentDriver(),this);
    }

    public String getResultText(){
        return result.getText();
    }


}
