package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedPage extends Page{
    public LoggedPage(WebDriver webDriver){
        super(webDriver);
    }

    @FindBy(xpath="//*[@id=\"content\"]/div/p")
    public WebElement text;

    public void printText(){
        System.out.println(text.getText());
    }
}
