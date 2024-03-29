package tests.TestCasesFirstTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;

public class TestCaseNum8 {
    /*
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
    Step 2. Click on “Registration Form”
    Step 3. Enter “5711234354” into phone number input box.
    Step 4. Verify that warning message is displayed:
    “Phone format is not correct”
     */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        //Step 1. Go to https://practice-cybertekschool.herokuapp.com
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. Click on “Registration Form”
        WebElement RegistrationForm = driver.findElement(By.linkText("Registration Form"));
        RegistrationForm.click();
        //Step 3. Enter “5711234354” into phone number input box.
        WebElement UserNameBox = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[6]/div/input"));
        UserNameBox.sendKeys("5711234354");
        //Step 4. Verify that warning message is displayed:
        //    “Phone format is not correct”

        String ExpectedWarning = "Phone format is not correct";
        String ActualWarning = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[6]/div/small[2]")).getText();
        System.out.println(ActualWarning);
        if(ActualWarning.equals(ExpectedWarning)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.quit();










    }
}
