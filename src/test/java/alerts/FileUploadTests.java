package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload(){

        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("/Users/Migda/Documents/TAU - Selenium WebDriver with Java/webdriver_java/resources/PRUEBA.txt");

        assertEquals(uploadPage.getUploadedFiles(), "PRUEBA.txt", "Uploaded files incorrect");
    }
}
