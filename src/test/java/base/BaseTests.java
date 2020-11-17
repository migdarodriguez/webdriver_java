package base;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import Pages.HomePage;
import org.testng.annotations.BeforeMethod;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import com.google.common.io.Files;
import java.io.IOException;

import org.openqa.selenium.OutputType;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    //private EventFiringWebDriver driver1;
    //private EventFiringWebDriver driver= new EventFiringWebDriver(new ChromeDriver(getChromeOptions())); NO FUNCIONO

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver= new ChromeDriver();
        // PAGINA POR DONDE ARRANCA,se puso en el BeforeMethod para asegurar q cada metodo arrancará por ahi
        //driver.get("https://the-internet.herokuapp.com/");
        //driver.get("https://formy-project.herokuapp.com/form");

        homePage = new HomePage(driver);
    }

    /** ESTA CLASE ES PARA PROBAR EL LISTENER, LE CAMBIE EL NOMBRE al driver A driver1 para No cambiar el driver
    @BeforeClass
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver1 = new EventFiringWebDriver(new ChromeDriver());
        // AQUI INSTANCIAR LA CLASE QUE SE CREÓ EN LA CARPETA utils PARA EL LISTENER
        driver1.register(new EventReporter());

        goHome();
    }**/

    @BeforeMethod
    public void goHome(){           // SE HIZO PARA OBLIGAR A TODOS LOS TESTS A IR AL HOME antes de ejecutrase
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        //driver.quit();
    }

    //PARA MANEJAR las paginas en el navegador, atras, a una url, a traves de WebDriver.Navigator
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    /**  NO ME FUNCIONÓ
     * private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        // LA SIGUIENTE LINEA EJECUTA EL TEST SIN ABRIR EL NAVEGADOR
        // si está ejecutando en Selenium Grid o si está ejecutando en una nube, entonces ChromeOptions es muy útil
        options.setHeadless(true);

        return options;
    }   **/

    /**  TOMAR SCREENSHOT AL FINALIZAR UN TEST. PARA CORRERLO, IR POR EJP A KeyTest.java
    //  y EJECUTAR EL METODO testBackspace(), eso guardará el screenshot al final del test en la ruta de abajo
    // LO COMENTARÉ PORQUE SE EJECUTARÁ DESPUES DE CADA METODO QUE SE EJECUTE, PASE EL TEST O NO, YA QUE
    // ESTÁ EN EL @AfterMethod
    @AfterMethod
    public void takeScreenshot(){
        //The first thing that we need to do is to cast our driver to a Selenium class called TakesScreenshot which is in the Selenium package
        var camera = (TakesScreenshot)driver;
        //System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
        //save the screenshot as a file using the “java.io” package
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
       try{
            Files.move(screenshot, new File("resources/screenshots/test.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }**/

    /** TOMAR SCREENSHOT AL FINALIZAR EL TEST, en las pruebas FALLIDAS SOLAMENTE
    PARA CORRERLO, IR POR EJP A KeyTest.java y poner un * en la linea: "You entered: BACK_SPACE*", (eso fallará
    el test) EJECUTAR EL METODO testBackspace(), eso guardará el screenshot al final del test en la ruta de abajo
    LO COMENTARÉ PORQUE SE EJECUTARÁ DESPUES DE CADA METODO QUE FALLE
     @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            // EL result.getName() SE USA PARA GUARDAR EL SCREENSHOT CON EL NOMBRE DEL TEST que falló

            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }  **/

}
