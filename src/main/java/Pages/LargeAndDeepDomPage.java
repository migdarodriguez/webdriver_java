package Pages;
// SCROLL EXAMPLE
// NOTA: PARA EJECUTAR JSCRIPT, SE DEBE CONVERTIR EL DRIVER A UN JAVASCRIPTEXECUTOR
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDomPage {

    private WebDriver driver;
    private By table = By.id("large-table");

    public LargeAndDeepDomPage(WebDriver driver){
        this.driver = driver;
    }

    public void scrollToTable(){
        WebElement tableElement = driver.findElement(table);
        //((JavascriptExecutor)driver).
        String script = "arguments[0].scrollIntoView();";
        //place this script variable inside of the executeScript call
        ((JavascriptExecutor)driver).executeScript(script, tableElement);
    }
}
