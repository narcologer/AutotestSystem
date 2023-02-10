package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import pages.DropdownPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownTest extends Tester {
    DropdownPage dropdownPage;

    @DataProvider
    public Object[][] dropdownProvider(){
        return new Object[][]{{1},{2}};
    }

    @Test(dataProvider = "dropdownProvider")
    public void dropdownTestByProvide(Integer data){
        dropdownPage = new DropdownPage(getDriver());
        dropdownPage.getPage(ConfProperties.getProperty("dropdownpage"));
        Integer foundData=dropdownPage.dropdownSelect(data);
        assert dropdownPage.checkSelected(getDriver().findElement(new By.ByCssSelector("#dropdown > option:nth-child(" + foundData + ")")));
    }
}
