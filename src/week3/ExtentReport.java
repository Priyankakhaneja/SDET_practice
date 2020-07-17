package week3;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {
WebDriver driver;
    
    ExtentReports report;
    ExtentTest test;
    
    @BeforeClass
    public void takeReport() {
    	report = new ExtentReports(System.getProperty("user.dir") + "/reports/Extentreport.html");
        test = report.startTest("SDET Batch");
    }
    
    @AfterClass
    public void endReprot() {
        report.endTest(test);
        report.flush();
    }
    @Test(priority=1)
    public void openBrowser() {
    	 System.setProperty("webdriver.chrome.driver","C:\\Users\\PriyankaKhaneja\\Desktop\\selenium new\\chromedriver_win32 (2)\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.get("https://www.calculator.net");
        driver.findElement(By.partialLinkText("BMI")).click();
        test.log(LogStatus.PASS, "My Link is clciked");
    }
    
    @Test(priority=2)
    public void sendValue() {
        driver.findElement(By.id("gfhhf")).clear();
        //test.log(LogStatus.PASS, "Text is cleared");
        driver.findElement(By.id("gfhff")).sendKeys("34");
     //   test.log(LogStatus.PASS, "Text is Entered");
    }
    public static String takeScreenShot(WebDriver driver, String screenhotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/reports/test" + screenhotName +".png" ;
        File destiantionFile = new File(destination);
        FileUtils.copyFile(source, destiantionFile);
        return destination;
    }
    @AfterMethod
    public void getScrenResult(ITestResult result) throws IOException {
        if(result.getStatus()==ITestResult.FAILURE) {
            String screenShotPath = takeScreenShot(driver,result.getName());
            test.log(LogStatus.FAIL, "Testcase is failed for " + result.getName() + result.getThrowable() + test.addScreenCapture(screenShotPath));
        }
    }
  }

