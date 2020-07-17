package week3;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertExample {
	
	Logger log = Logger.getLogger(AssertExample.class.getName());
	WebDriver driver;
    @Test(priority=1)
    public void openGoogle() {
        log.info("Thsi is 1st case");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\PriyankaKhaneja\\Desktop\\selenium new\\chromedriver_win32 (2)\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
        log.info("Testcase 1 done");
    }
	   
    @Test(priority=2)
    public void passValue() {
        
        String expTitle = "Googlehjfhdkfkd";
        String acttitle = driver.getTitle();
        
        //hard assert
       // Assert.assertEquals(acttitle, expTitle);
        //driver.findElement(By.name("q")).sendKeys("TEsting sample");
        
        /*SoftAssert sa = new SoftAssert();
        sa.assertEquals(acttitle, expTitle);
        driver.findElement(By.name("q")).sendKeys("TEsting sample");
        sa.assertAll();*/
        
        //assert not aborting
        try {
            Assert.assertEquals(acttitle, expTitle);
        } catch(Throwable t) {
System.out.println(" Exception is " + t);
        }
        driver.findElement(By.name("q")).sendKeys("TEsting sample");
        
        
        }
}
        
     
        