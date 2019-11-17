package tests.TestCasesFirstTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserWaitUtils;

public class TestCaseNum1 {
    /*
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
    Step 2. Click on “Sign Up For Mailing List”
    Step 3. Enter any valid name
    Step 4. Enter any valid email
    Step 5. Click on “Sign Up” button
    Expected result: Following message should be displayed:
    “Thank you for signing up. Click the button below to return to the
    home page.” Home button should be displayed.
     */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        BrowserWaitUtils.wait(2);
        WebElement SignUpToList = driver.findElement(By.linkText("Sign Up For Mailing List"));
        SignUpToList.click();
        WebElement ValidName = driver.findElement(By.name("full_name"));
        ValidName.sendKeys("Nurzat Shaltaeva");
        WebElement ValidEmail = driver.findElement(By.cssSelector("[type='email']"));
        ValidEmail.sendKeys("nshaltaeva@gmail.com");
        BrowserWaitUtils.wait(2);
        WebElement LoginButton = driver.findElement(By.name("wooden_spoon"));
        LoginButton.click();

        String ExpectedSignUpMessage = "Thank you for signing up. Click the button below to return to the home page.";
        WebElement SignUpMessage = driver.findElement(By.name("signup_message"));
        String ActualSignUpMessage = SignUpMessage.getText();
        System.out.println(ActualSignUpMessage);
        if(ActualSignUpMessage.equals(ExpectedSignUpMessage)){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        driver.quit();
    }
}
