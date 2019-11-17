package tests.TestCasesFirstTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;

import java.util.List;

public class TestCaseNum2 {
    /*
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
    Step 2. Verify that number of listed examples is equals to 48.
    Hint: use findElemnts() and size() methods.
     */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        List<WebElement> list = driver.findElements(By.className("list-group-item"));
        System.out.println(list.size());

        driver.quit();

    }
}
