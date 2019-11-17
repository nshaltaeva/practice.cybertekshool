package tests.TestCases2_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserWaitUtils;

import java.util.List;

public class TestCasesFrom1to5 {
    /*
    Please create test scripts from 1 through 5 in the same class,
    with implementing @Before method for driver setup,
    and @After method for driver close.
     */
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
      driver = BrowserFactory.getDriver("chrome");
      driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. Click on “Registration Form”
        WebElement RegistrationForm = driver.findElement(By.linkText("Registration Form"));
        RegistrationForm.click();

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test(description = "Verify DOB")
    /*
    Step 3. Enter “wrong_dob” into date of birth input box.
    Step 4. Verify that warning message is displayed:
    “The date of birth is not valid”
     */
    public void VerifyDOB(){
    WebElement DOB = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/input"));
    DOB.sendKeys("wrong_dob");
    String ExpectedMessage = "The date of birth is not valid";
        BrowserWaitUtils.wait(2);
    String ActualMessage = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/small[2]")).getText();
    System.out.println(ActualMessage);
    Assert.assertEquals(ActualMessage,ExpectedMessage);
    }

    @Test(description = "Verify following options C++, Java, JavaScript")
    /*
    Step 3. Verify that following options for programming languages
    are displayed: c++, java, JavaScript
     */
    public void CJavaJavaScript(){
        //*[@class="form-check-label"]
        List<WebElement> ProgrammingLanguages = driver.findElements(By.xpath("//*[@class=\"form-check-label\"]"));
        for (WebElement FollowingOption: ProgrammingLanguages) {
            BrowserWaitUtils.wait(2);
            System.out.println("Select programming languages: "+FollowingOption.getText());

        }
    }

    @Test(description = "Verify that first name must be more than 2 and less than 64 characters long")
    /*
    Step 3. Enter only one alphabetic character into first name input box.
    Step 4. Verify that warning message is displayed:
    “first name must be more than 2 and less than 64 characters long”
     */
    public void FirstNameBox(){
        WebElement FirstNameBox = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/input"));
        FirstNameBox.sendKeys("a");
        String ExpectedWarning = "first name must be more than 2 and less than 64 characters long";
        String ActualWarning = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[2]")).getText();
        System.out.println(ActualWarning);
        if(ActualWarning.equals(ExpectedWarning)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }

    @Test(description = "Verify that last name must be more than 2 and less than 64 characters long")
    /*
    Step 3. Enter only one alphabetic character into last name input box.
    Step 4. Verify that warning message is displayed:
    “The last name must be more than 2 and less than 64 characters long”
     */
    public void LastNameBox(){
        WebElement LastNameBox = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/input"));
        LastNameBox.sendKeys("b");
        String ExpectedWarning = "The last name must be more than 2 and less than 64 characters long";
        String ActualWarning = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/small[2]")).getText();
        System.out.println(ActualWarning);
        Assert.assertEquals(ActualWarning,ExpectedWarning,"Failed");
       /* if(ActualWarning.equals(ExpectedWarning)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        */
    }

    @Test(description = "Verify that You've successfully completed registration! with valid info")
     public void ValidInfo(){
        // Step 3. Enter any valid first name.
        WebElement FirstNameBox = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/input"));
        FirstNameBox.sendKeys("John");
        //Step 4. Enter any valid last name.
        WebElement LastNameBox = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/input"));
        LastNameBox.sendKeys("Snow");
        //Step 5. Enter any valid user name.
        WebElement UserNameBox = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[3]/div/input"));
        UserNameBox.sendKeys("JohnSnow");
        //Step 6. Enter any valid email name.
        WebElement EmailBox = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/input"));
        EmailBox.sendKeys("johnsnow@gmail.com");
        //Step 7. Enter any valid password.
        WebElement Password = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[5]/div/input"));
        Password.sendKeys("johnsnow");
        //Step 7. Enter any valid phone number.
        WebElement PhoneNum = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[6]/div/input"));
        PhoneNum.sendKeys("555-111-4444");
        // Step 8. Select gender.
        List<WebElement> Genders = driver.findElements(By.xpath("//*[@id=\"registrationForm\"]/div[7]/div/div/label/input"));
        for (WebElement gender: Genders) {
            BrowserWaitUtils.wait(2);
            gender.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[7]/div/div[1]/label/input")).click();
        }
        //Step 9. Enter any valid date of birth.
        WebElement DOB = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/input"));
        DOB.sendKeys("01/01/2008");
       //Step 10. Select any department.
        WebElement Department = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[9]/div/select"));
        Department.click();
        BrowserWaitUtils.wait(2);
        Select select = new Select(Department);
        select.selectByVisibleText("Tourism Office");
        //Step 11. Enter any job title.
        WebElement JobTitle = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[10]/div/select"));
        JobTitle.click();
        BrowserWaitUtils.wait(2);
        Select select1 = new Select(JobTitle);
        select1.selectByVisibleText("Designer");
        //Step 12. Select java as a programming language.
        List<WebElement> ProgrammingLanguages = driver.findElements(By.xpath("//*[@class=\"form-check-label\"]"));
        for (WebElement FollowingOption: ProgrammingLanguages) {
            BrowserWaitUtils.wait(2);
            FollowingOption.findElement(By.xpath("//*[@id=\"inlineCheckbox2\"]")).click();
        }
        //Step 13. Click Sign up.
        WebElement SignInButton = driver.findElement(By.id("wooden_spoon"));
        SignInButton.click();
        //Step 14. Verify that following success message is displayed:
        //    “You've successfully completed registration!”
        String ExpectedMessage = "You've successfully completed registration!";
        WebElement SighUpMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/p"));
        String ActualMessage = SighUpMessage.getText();
        System.out.println(ActualMessage);
        if(ActualMessage.equals(ExpectedMessage)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }








}
