package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

    private WebDriver driver;
    // js alert - simple
    private By triggerAlertButton = By.xpath(".//button[text()='Click for JS Alert']");

    // confirm alert
    private By triggerConfirmButton = By.xpath(".//button[text()='Click for JS Confirm']");

    // prompt alert
    private By triggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");

    private By results = By.id("result");



    public AlertsPage(WebDriver driver){
        this.driver = driver;
    }

    public void triggerAlert(){         // dispara el alert haciendo click en el boton
        driver.findElement(triggerAlertButton).click();
    }

    public void acceptAlert(){  // hace click en el boton aceptar del alert, el switch es para q salga fuera del DOM
        driver.switchTo().alert().accept();
    }

    public String getResult(){
        return driver.findElement(results).getText();
    }

    public void triggerConfirm(){
        driver.findElement(triggerConfirmButton).click();
    }

    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }

    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }

    public void alert_setInput(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    public void alert_clickToDismiss(){
        driver.switchTo().alert().dismiss();
    }

    public void triggerPrompt(){
        driver.findElement(triggerPromptButton).click();
    }


}
