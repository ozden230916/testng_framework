package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

import java.util.List;

public class _13_Tables extends Base{
    /*
    Go to http://the-internet.herokuapp.com/
    Click on “Sortable Data Tables” link
    Validate the table 1 headers to be displayed as below
    Last Name
    First Name
    Email
    Due
    Web Site
    Action

     */
    @Test(priority = 1, description = "Tables | headers" )
    public void testTableHeaders(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");

        String[] headersTable1List = {"Last Name", "First Name","Email", "Due", "Web Site", "Action"};

        for (int i = 0; i < heroAppPage.headerTable1.size(); i++) {
            Waiter.waitUntilTextToBePresentInElement(driver, 30, heroAppPage.headerTable1.get(i), headersTable1List[i]);
            Assert.assertEquals(heroAppPage.headerTable1.get(i).getText(), headersTable1List[i]);
        }
    }
    /*
    Go to http://the-internet.herokuapp.com/
    Click on “Sortable Data Tables” link
    Validate the table 1 row 1 to be displayed as below
    Smith
    John
    jsmith@gmail.com
    $50.00
    http://www.jsmith.com
    edit delete

     */
    @Test(priority = 2, description = "Tables | first row")
    public void testfirstRow(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");
        String[] row1Table1 = {"Smith", "John", "jsmith@gmail.com", "$50.00", "http://www.jsmith.com", "edit delete"};
        List<WebElement> row1List = driver.findElements(By.cssSelector("#table1>tbody>tr:nth-child(1)>td"));

        for (int i = 0; i < row1List.size(); i++) {
            Assert.assertEquals(row1List.get(i).getText(), row1Table1[i]);

        }

    }

    /*
    Go to http://the-internet.herokuapp.com/
    Click on “Sortable Data Tables” link
    Validate the table 1 column 2 (First Name) to be displayed as below
    John
    Frank
    Jason
    Tim
     */
    @Test(priority = 3, description = "Tables | 2nd column")
    public void testSecondColumn(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");
        List<WebElement> secondColumnList = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
        String[] secondColumn = {"John", "Frank", "Jason", "Tim"};


        for (int i = 0; i < secondColumnList.size(); i++) {
            Assert.assertEquals(secondColumnList.get(i).getText(), secondColumn[i]);

        }

    }

    /*
    Go to http://the-internet.herokuapp.com/
    Click on “Sortable Data Tables” link
    Validate each cell has value (not empty)
     */
    @Test(priority = 4, description = "Tables | all cells")
    public void testAllCell(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");
        List<WebElement> allCells = driver.findElements(By.cssSelector("#table1 td"));
        for (WebElement allCell : allCells) {
            Assert.assertNotEquals(allCell.getText(), "");
        }
    }


}
