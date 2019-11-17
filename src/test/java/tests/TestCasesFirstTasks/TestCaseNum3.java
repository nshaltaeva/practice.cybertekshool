package tests.TestCasesFirstTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.BrowserFactory;
import utilities.BrowserWaitUtils;

public class TestCaseNum3 {
    /*
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
    Step 2. Click on “Multiple Buttons”
    Step 3. Click on “Button 1”
    Verify that result message is displayed: “Clicked on button one!”
     */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement MultipleButtons = driver.findElement(By.linkText("Multiple Buttons"));
        MultipleButtons.click();
       // BrowserWaitUtils.wait(2);
        WebElement Button1 = driver.findElement(By.xpath("//*[text()='Button 1']"));
        Button1.click();
        BrowserWaitUtils.wait(1);
        System.out.println(Button1.getText());

        String ExpectedResultMessage = "Clicked on button one!";
        String ActualResultMessage = driver.findElement(By.cssSelector("#result")).getText();
        System.out.println(ActualResultMessage);
        Assert.assertEquals(ActualResultMessage,ExpectedResultMessage,"Wrong result");

        driver.quit();
    }
}
