package tests;
import org.junit.Test;
import pages.LoggedPage;


public class LoginTest extends Tester{
    LoggedPage loggedPage;
    @Test
    public void loginTest() throws InterruptedException {
        loggedPage = new LoggedPage(getDriver());
        loggedPage.getPage(ConfProperties.getProperty("loginpage"));
        loggedPage.printText();
    }
}
