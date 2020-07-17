package week3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testng2 {
	WebDriver driver;
	
    @BeforeSuite
    public void openSession() {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\PriyankaKhaneja\\Desktop\\selenium new\\chromedriver_win32 (2)\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.get("https://www.calculator.net/");
    }
    
   @BeforeMethod
  public void befmeth()
   {
	  System.out.println("before method"); 
   }
    
    @BeforeTest
    public void chkTitle() {
    String title =     driver.getTitle();
    System.out.println("Title is " + title);
    }
    
    
    @Test
    public void bmiClick() {
        driver.findElement(By.partialLinkText("BMI")).click();
        System.out.println("tst1");
    }
    
    @Test
    public void enterValue() {
        driver.findElement(By.name("cage")).clear();
        driver.findElement(By.name("cage")).sendKeys("78");
        System.out.println("tst2");
    }
    
    
    @AfterSuite
    public void closeSession() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
