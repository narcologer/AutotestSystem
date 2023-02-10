package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddElementsPage;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AddElementsTest extends Tester {
    Random random = new Random();
    private static AddElementsPage addElementsPage;
    int elementNum = 5;
    int randomNum = random.nextInt(elementNum);
    @Test
    public void addTest() throws InterruptedException {
        addElementsPage = new AddElementsPage(getDriver());
        addElementsPage.getPage(ConfProperties.getProperty("addelementspage"));
        addElementsPage.AddNElements(elementNum);
        addElementsPage.RemoveRandomElement(randomNum);
        assert (getDriver().findElements(By.xpath(ConfProperties.getProperty("addElementsElements"))).size() < elementNum);
        }
    }
