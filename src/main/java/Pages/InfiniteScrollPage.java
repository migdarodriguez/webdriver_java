package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;

public class InfiniteScrollPage {

    private WebDriver driver;
    private By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        this.driver= driver;
    }

    /*** Scrolls until paragraph with index specified is in view
     * Esto es para hacer un scroll en un parrafo cuando No sabemos el indice del elemento q queremos ver
     * @param index 1-based
     * Puedo hacer scroll horizontal (eje X) o verticalmente (eje Y), si No me quiero desplazar horizontalmente,
     * el primer parametro será 0, como se puede ver abajo. Para hacer un scroll de usuario normal se usa:
     *              document.body.scrollHeight       */
    public void scrollToParagraph(int index){
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        var jsExecutor = (JavascriptExecutor)driver;

        while(getNumberOfParagraphsPresent() < index){
            jsExecutor.executeScript(script);
        }
    }

    /** Como No conozco el total de parrafos con el mismo nombre, los mando a contar:      */
    private int getNumberOfParagraphsPresent(){
        return driver.findElements(textBlocks).size();
    }
}
