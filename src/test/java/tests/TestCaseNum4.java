package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;

public class TestCaseNum4 {
    /*
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
    Step 2. Click on “Registration Form”
    Step 3. Enter “123” into first name input box.
    Step 4. Verify that warning message is displayed:
    “first name can only consist of alphabetical letters”
     */
    /*
    <input type="text" class="form-control" name="firstname" placeholder="first name" data-bv-field="firstname">
     */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        //Step 1. Go to https://practice-cybertekschool.herokuapp.com
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. Click on “Registration Form”
        WebElement RegistrationForm = driver.findElement(By.linkText("Registration Form"));
        RegistrationForm.click();
        //Step 3. Enter “123” into first name input box.
        WebElement FirstNameBox = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/input"));
        FirstNameBox.sendKeys("123");
        //Step 4. Verify that warning message is displayed:
        //    “first name can only consist of alphabetical letters”
        String ExpectedWarning = "first name can only consist of alphabetical letters";
        String ActualWarning = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[3]")).getText();
        System.out.println(ActualWarning);
        if(ActualWarning.equals(ExpectedWarning)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.quit();
    }
}
