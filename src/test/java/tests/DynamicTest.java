package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

public class DynamicTest extends Tester {
    private WebDriverWait wait;
    @Test
    public void testCheckbox(){
        getDriver().get(ConfProperties.getProperty("dynamicpage"));
        getDriver().findElement(By.xpath(ConfProperties.getProperty("dynamicCheckboxButton"))).click();
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf
                (getDriver().findElement(By.xpath
                        (ConfProperties.getProperty("dynamicCheckbox")))));
        System.out.println("Чекбокса нет");
        getDriver().findElement(By.xpath(ConfProperties.getProperty("dynamicCheckboxButton"))).click();
        wait.until(ExpectedConditions.visibilityOf
                (getDriver().findElement(By.xpath
                        (ConfProperties.getProperty("dynamicCheckboxReturned")))));
        System.out.println("Чекбокс есть");
    }

    @Test
    public void testTextfield(){
        getDriver().findElement(By.xpath
                (ConfProperties.getProperty("dynamicTextfieldButton"))).click();
        wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(ConfProperties.getProperty("dynamicTextfield"))));
        getDriver().findElement(By.xpath(ConfProperties.getProperty("dynamicTextfield"))).sendKeys("abc");
        getDriver().findElement(By.xpath
                (ConfProperties.getProperty("dynamicTextfieldButton"))).click();
        wait.until(ExpectedConditions.not
                (ExpectedConditions.elementToBeClickable
                        (By.xpath(ConfProperties.getProperty("dynamicTextfield")))));
        assert Objects.equals(getDriver().findElement
                (By.xpath(ConfProperties.getProperty("dynamicTextfield"))).getAttribute("value"), "abc");
    }
}
