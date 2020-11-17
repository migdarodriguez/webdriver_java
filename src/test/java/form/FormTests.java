package form;

import Pages.WebForm;
import base.BaseTests;
import org.testng.annotations.Test;

public class FormTests extends BaseTests {

    @Test
    public void testCompleteWebForm() {
        WebForm webformPage = homePage.complete_WebForm();
        webformPage.setfirstName("Migdalia");
        webformPage.setjobTitle("Ingeniero QA");
        webformPage.clickRadioButton();
        webformPage.clickCheckBox();

        //String textEscrito= webformPage.getFirstName(); NO LO TRAE XQ NO HA RENDERIZADO
    }
}
