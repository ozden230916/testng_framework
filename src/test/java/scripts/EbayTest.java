package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DropdownHandler;

public class EbayTest extends Base{
    @Test
    public void validateHeading(){
        driver.get("https://www.ebay.com/");
        ebayPage.allCategoriesDropdown.click();
        DropdownHandler.selectOptionByVisibleText(ebayPage.allCategoriesDropdown, "Art");
        ebayPage.searchButton.click();

        Assert.assertTrue(ebayPage.heading1.isDisplayed());
        Assert.assertEquals(ebayPage.heading1.getText(), "Welcome to eBay Art");

        Assert.assertTrue(ebayPage.heading2.isDisplayed());
        Assert.assertEquals(ebayPage.heading2.getText(), "Find Prints, Paintings, Posters, and More.");
    }
}
