package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.NestedFramePage;

import java.util.List;

public class FrameTest extends Tester {

    NestedFramePage nestedFramePage;

    public String getTextInFrame(WebDriver driver, String frameName) {
        driver.switchTo().frame(frameName);
        return nestedFramePage.getFrameContent();
    }

    @Test
    public void testGetTextFromFrame() {
        nestedFramePage = new NestedFramePage(getDriver());
        nestedFramePage.getPage(ConfProperties.getProperty("nestedFramePage"));
        List<WebElement> ele = nestedFramePage.getFrameList();
        getDriver().switchTo().defaultContent();
        for(WebElement el : ele){
            nestedFramePage.switchFrame();
            System.out.println(
                    getTextInFrame(getDriver(),el.getAttribute("name")));
            getDriver().switchTo().defaultContent();
        }
    }
}
