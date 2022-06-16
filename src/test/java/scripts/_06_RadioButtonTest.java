package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _06_RadioButtonTest extends Base{

 /*
Go to https://www.facebook.com/
Click on "Create New Account" link
Validate "Female", "Male" and "Custom" radio buttons are displayed, enabled and not selected
Select "Female" and validate it is selected
Select "Male" radio button and and validate "Male" is selected and "Female" is deselected
 */

    @Test(priority = 1, description = "TC234: Validate Facebook gender radio buttons")
    public void testFacebookGenderRadioButtons(){
        driver.get("https://www.facebook.com/");

        faceBookPage.createnewAccountLink.click();

        for(WebElement element : faceBookPage.genderRadioButtons){
            softAssert.assertTrue(element.isDisplayed(), "Element IS NOT displayed");
            softAssert.assertTrue(element.isEnabled(), "Element IS NOT enabled");
            softAssert.assertFalse(element.isSelected(), "Element IS selected");
        }
        faceBookPage.genderRadioButtons.get(0).click();
        Assert.assertTrue(faceBookPage.genderRadioButtons.get(0).isSelected(), "Element is not true");

        faceBookPage.genderRadioButtons.get(1).click();
        Assert.assertFalse(faceBookPage.genderRadioButtons.get(0).isSelected());
        Assert.assertTrue(faceBookPage.genderRadioButtons.get(1).isSelected());







    }
}
