package week3;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(week3.Logs_Listensers.class)

public class NewTest {
WebDriver driver;
    
    @BeforeClass
    public void openBrowser() {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\PriyankaKhaneja\\Desktop\\selenium new\\chromedriver_win32 (2)\\chromedriver.exe" );
         driver = new ChromeDriver();
            driver.get("https://www.calculator.net/");
    }
    
    @Test(priority=1)
    public void bmiClick() {
        driver.findElement(By.partialLinkText("BMI")).click();
        
    }
    
    @Test(priority=3,enabled=false) 
	public void atest3() {
		System.out.println("Test 3");
	}
	

    
    @Test(priority=2, dependsOnMethods="bmiClick")
    public void enterValue() {
        driver.findElement(By.name("cage")).clear();
        driver.findElement(By.name("cage")).sendKeys("78");
    }
    
   
  }

