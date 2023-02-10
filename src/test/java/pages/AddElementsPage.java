package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.ConfProperties;

import java.util.List;

public class AddElementsPage extends Page{
    public AddElementsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath="//*[@id=\"content\"]/div/button")
    public WebElement AddButton;

    @FindBy(xpath="//*[@id=\"elements\"]//*")
    public List<WebElement> elements;

    public void AddNElements(int n){
        while (elements.size() < n) {
            AddButton.click();
            System.out.println(elements.size());
        }
    }

    public void RemoveRandomElement(int rnd){
        elements.get(rnd).click();
    }
}
