package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;

public class TestCaseNum6 {
    /*
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
    Step 2. Click on “Registration Form”
    Step 3. Enter “user” into username input box.
    Step 4. Verify that warning message is displayed:
    “The username must be more than 6 and less than 30 characters long”
     */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        //Step 1. Go to https://practice-cybertekschool.herokuapp.com
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. Click on “Registration Form”
        WebElement RegistrationForm = driver.findElement(By.linkText("Registration Form"));
        RegistrationForm.click();
        //Step 3. Enter “user” into username input box.
        WebElement UserNameBox = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[3]/div/input"));
        UserNameBox.sendKeys("user");
        //Step 4. Verify that warning message is displayed:
    //    "The username must be more than 6 and less than 30 characters long”

        String ExpectedWarning = "The username must be more than 6 and less than 30 characters long";
        String ActualWarning = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[3]/div/small[2]")).getText();
        System.out.println(ActualWarning);
        if(ActualWarning.equals(ExpectedWarning)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.quit();










    }
}
