package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicPage extends Page{
    public DynamicPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath="//*[@id=\"checkbox\"]/input")
    public WebElement checkbox;

    @FindBy(xpath="//*[@id=\"checkbox-example\"]/button")
    public WebElement checkboxButton;

    @FindBy(xpath="//*[@id=\"input-example\"]/input")
    public WebElement textfield;

    @FindBy(xpath="//*[@id=\"input-example\"]/button")
    public WebElement textfieldButton;
}
