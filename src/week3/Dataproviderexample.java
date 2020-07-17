package week3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(week3.Logs_Listensers.class)
public class Dataproviderexample
{
	
	WebDriver driver;
    @BeforeSuite
    public void openSession() {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\PriyankaKhaneja\\Desktop\\selenium new\\chromedriver_win32 (2)\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.get("https://www.calculator.net/");
    }
    
    @Test(priority=1)
    public void clickBMI() {
        driver.findElement(By.partialLinkText("BMI")).click();
    }
	@Test(priority=2, dataProvider="getData")
    public void bmiOperation(String age, String height, String weight) {
        driver.findElement(By.name("cage")).clear();
        driver.findElement(By.name("cage")).sendKeys(age);
        driver.findElement(By.name("cheightmeter")).clear();
        driver.findElement(By.name("cheightmeter")).sendKeys(height);
        driver.findElement(By.name("ckg")).clear();
        driver.findElement(By.name("ckg")).sendKeys(weight);
        driver.findElement(By.xpath("//input[@alt='Calculate']")).click();
        String bmi = driver.findElement(By.xpath("//h2[contains(text(), 'Result')]//following::b")).getText();
    System.out.println("BMI is " + bmi);
    }

	@AfterSuite
    public void cloeSession() {
        driver.quit();
    }
    
    
    @DataProvider()
    public static Object[][] getData() {
        return new Object[][] {
            {"3", "56", "12"},
            {"17", "100", "54"},
            {"20", "164", "187"}
    };


}
}




