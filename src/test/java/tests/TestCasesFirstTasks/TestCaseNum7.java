package tests.TestCasesFirstTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;

public class TestCaseNum7 {
    /*
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
    Step 2. Click on “Registration Form”
    Step 3. Enter “testers@email” into email input box.
    Step 4. Verify that warning message is displayed:
    “email address is not a validEmail format is not correct”
     */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        //Step 1. Go to https://practice-cybertekschool.herokuapp.com
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. Click on “Registration Form”
        WebElement RegistrationForm = driver.findElement(By.linkText("Registration Form"));
        RegistrationForm.click();
        //Step 3. Enter “testers@email” into email input box.
        WebElement EmailBox = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/input"));
        EmailBox.sendKeys("testers@email");
        //Step 4. Verify that warning message is displayed:
        //    "email address is not a valid
        //    Email format is not correct”

        String ExpectedWarning1 = "email address is not a valid";
        String ExpectedWarning2 = "Email format is not correct";
        String ActualWarning1 = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/small[2]")).getText();
        String ActualWarning2 = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/small[3]")).getText();

        System.out.println(ActualWarning1);
        System.out.println(ActualWarning2);

        if(ActualWarning1.equals(ExpectedWarning1) && ActualWarning2.equals(ExpectedWarning2)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.quit();










    }
}
