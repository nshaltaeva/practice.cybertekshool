package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;

public class TestCaseNum5 {
    /*
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
    Step 2. Click on “Registration Form”
    Step 3. Enter “123” into last name input box.
    Step 4. Verify that warning message is displayed:
    “The last name can only consist of alphabetical letters and dash”
     */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        //Step 1. Go to https://practice-cybertekschool.herokuapp.com
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. Click on “Registration Form”
        WebElement RegistrationForm = driver.findElement(By.linkText("Registration Form"));
        RegistrationForm.click();
        //Step 3. Enter “123” into last name input box.
        WebElement LastNameBox = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/input"));
        LastNameBox.sendKeys("123");
        //Step 4. Verify that warning message is displayed:
        //    “The last name can only consist of alphabetical letters and dash”
        String ExpectedWarning = "The last name can only consist of alphabetical letters and dash";
        String ActualWarning = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/small[3]")).getText();
        System.out.println(ActualWarning);
        if(ActualWarning.equals(ExpectedWarning)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.quit();










    }
}
