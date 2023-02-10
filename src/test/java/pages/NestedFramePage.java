package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NestedFramePage extends Page{
    @FindBy(xpath="/html/body")
    public WebElement frameContent;

    public String getFrameContent(){
        return frameContent.getText();
    }

    public void switchFrame(){
        webDriver.switchTo().frame("frame-top");
    }

    public List<WebElement> getFrameList(){
        switchFrame();
        return webDriver.findElements(By.tagName("frame"));
    }



    public NestedFramePage(WebDriver webDriver) {
        super(webDriver);
    }
}
