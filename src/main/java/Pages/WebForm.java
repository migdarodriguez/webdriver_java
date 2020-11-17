package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebForm {
    private WebDriver driver;
    private By firstNameField = By.id("first-name");
    private By jobTitleField = By.id("job-title");
    private By radiobuttonField= By.id("radio-button-2");
    private By checkboxField= By.id("checkbox-1");

    public WebForm(WebDriver driver){
        this.driver = driver;
    }

    public void setfirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void setjobTitle(String jobTitle){
        driver.findElement(jobTitleField).sendKeys(jobTitle);
    }
    public void clickRadioButton(){
        driver.findElement(radiobuttonField).click();
    }
    public void clickCheckBox(){
        driver.findElement(checkboxField).click();
    }

    //public String getFirstName(){
    //    String fn= driver.findElement(firstNameField).getText();
    //    return fn;
    //}
}
