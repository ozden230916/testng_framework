package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _11_FileUpload extends Base{
    /*
    Create a txt file in your project called “myFile.txt”
    Go to http://the-internet.herokuapp.com/
    Click on “File Upload” link
    Choose created file to be uploaded to the page
    Click on “Upload” button
    Validate “File Uploaded!” heading3 text
    Validate ”myFile.docx” in the uploaded file list

     */
    @Test(priority = 1, description = "File Upload")
    public void testFileUpload1(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("File Upload");
        heroAppPage.chooseFileInputBox.sendKeys("/Users/atillafirat/IdeaProjects/testng_framework/myFileOzden2.xls");
        heroAppPage.uploadFileButton.click();

        Assert.assertEquals(heroAppPage.fileUploadedH3.getText(), "File Uploaded!");
        Assert.assertEquals(heroAppPage.uploadedFileText.getText(), "myFileOzden2.xls" );
    }
    @Test
    public void testFileDownLoad(){
        driver.get("http://the-internet.herokuapp.com/");

        heroAppPage.clickOnLink("File Download");

        heroAppPage.downloadFileLink.click();

        Assert.assertEquals(heroAppPage.downloadFileLink.getText(), "myFileOzden2.xls");
    }

}
