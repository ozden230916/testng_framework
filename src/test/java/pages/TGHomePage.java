package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TGHomePage {

    public TGHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='comp-kh9s3kyz3']//span/span")
    public WebElement heading1;

    @FindBy(id = "dataItem-kuiqff9g-comp-kixnxkbc")
    public WebElement faceBookIcon;

    @FindBy(css = "#comp-kvjohd5t5>a")
    public WebElement registerForIntroLink;


}
