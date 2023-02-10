package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends Page{
    public DropdownPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath="//*[@id=\"dropdown\"]")
    public WebElement dropdown;

    public int dropdownSelect(int data){
        Select select = new Select(dropdown);
        select.selectByIndex(data);
        return data+1;
    }

    public boolean checkSelected(WebElement webElement){
        return webElement.getAttribute("selected").equals("true");
    }
}
