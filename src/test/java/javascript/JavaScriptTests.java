package javascript;
// AUTOMATIZAR SCROLL
// ESTE TEST ES PARA HACER SCROLL EN UNA PAGINA CUANDO SE VA EXTENDIENDO HACIA ABAJO
// A MEDIDA QUE VAMOS HACIENDO EL SCROLL (AUTOMATIZAR EL SCROLL)
import base.BaseTests;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JavaScriptTests  extends BaseTests {
    @Test
    public void testScrollToTable(){
        homePage.clickLargeAndDeepDom().scrollToTable();
    }

    @Test
    public void testScrollToFifthParagraph(){
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }

    // SELECCIONAR DOS OPCIONES AL MISMO TIEMPO EN EL DROPDOWN, (PAGINA DROPDOWN) USANDO JSCRIPT
    // en EL METODO addMultipleAttribute
    @Test
    public void testAddMultipleAttributeToDropdown() {

        var dropDownPage = homePage.clickDropDown();
        dropDownPage.addMultipleAttribute();

        var optionsToSelect = List.of("Option 1", "Option 2");
        optionsToSelect.forEach(dropDownPage::selectFromDropDown);

        var selectedOptions = dropDownPage.getSelectedOptions();
        assertTrue(selectedOptions.containsAll(optionsToSelect), "All options were not selected");
        assertEquals(selectedOptions.size(), optionsToSelect.size(), "Number of selected items");
    }
}
