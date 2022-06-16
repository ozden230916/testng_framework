package scripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DropdownHandler;
import utilities.Waiter;

public class _07_DropdownTest extends Base{
    /*
    Go to https://www.facebook.com/
    Click on "Create New Account" link
    Enter below information and click on Sign Up button
    First name = John
    Last Name = Doe
    Email address = johndoe55555@gmail.com
    Password = abcd1234
    Birthday = April 1, 1990
    Gender = Male
    Validate below error message is displayed with expected text
    Please choose a more secure password. It should be longer than 6 characters, unique to you, and difficult for others to guess.
     */

    @Test(priority = 1, description = "TC763 : Validate FaceBook sign in error message for password")
    public void testUnsecurePasswordErrorMesage(){
        driver.get("https://www.facebook.com/");

        faceBookPage.createnewAccountLink.click();

        faceBookPage.firstNameInputBox.sendKeys("John");
        faceBookPage.lastNameInputBox.sendKeys("Doe");
        faceBookPage.emailOrPhoneInputBox.sendKeys("johndoe55555@gmail.com");
        faceBookPage.emailReEnterInputBox.sendKeys("johndoe55555@gmail.com");
        faceBookPage.passwordInputBox.sendKeys("abcd1234");

        //To be able to select an option from dropdown we need an instance of Select class
        //Select monthSelector = new Select(facebookPage.monthDropdown);
        //monthSelector.selectByValue("4"); // selection by value
        //monthSelector.selectByVisibleText("Apr"); // selection by visible text
       // monthSelector.selectByIndex(3); // selection by index - index starts from zero
        DropdownHandler.selectOptionByIndex(faceBookPage.monthDropdown, 3);

        //Select day as 1
        //Select daySelector = new Select(facebookPage.dayDropdown);
        //daySelector.selectByVisibleText("1");
        DropdownHandler.selectOptionByVisibleText(faceBookPage.dayDropdown, "1");

        //Select year as 1990
        //Select yearSelector = new Select(facebookPage.yearDropdown);
        //yearSelector.selectByValue("1990");
        DropdownHandler.selectOptionByValue(faceBookPage.yearDropdown, "1990");

        faceBookPage.genderRadioButtons.get(1).click();
        faceBookPage.signUpButton.click();

        String expectedMessage = "Please choose a more secure password. It should be longer than 6 characters, unique to you, and difficult for others to guess.";
        //new WebDriverWait(driver, 30).until(ExpectedConditions.textToBePresentInElement(facebookPage.errorMessage, expectedMessage))
        Waiter.waitUntilTextToBePresentInElement(driver, 60, faceBookPage.errorMessage, expectedMessage);
        Assert.assertEquals(faceBookPage.errorMessage.getText(), expectedMessage, "Error message has issues");



        }
        /*
        Go to https://www.expedia.com
        Select “Flights” from “More travel” dropdown
        Select “Premium economy” from “Economy” dropdown
        Validate “Premium economy” is selected

         */
    @Test(priority = 2, description = "TC578: Validate Expedia dropdowns")
    public void textExpediaDropdowns(){
        driver.get("https://www.expedia.com");
        expediaPage.moreTravelDropdown.click();
        expediaPage.flights.click();

        Waiter.pause(60);
        expediaPage.flightTypesDropdown.click();
        expediaPage.flightOptions.get(1).click();

        Assert.assertEquals(expediaPage.flightTypesDropdown.getText(), "Premium economy");



    }
    @Test(priority = 3, description = "TC242:Validate Ebay dropdown")
    public void testEbayDropdown(){

    }

}
