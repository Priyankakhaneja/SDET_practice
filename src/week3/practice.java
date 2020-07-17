package week3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class practice {
	WebDriver driver;
	
  @BeforeClass(groups= {"regression","smoke"})
public void openBrowser() 
  {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\PriyankaKhaneja\\Desktop\\selenium new\\chromedriver_win32 (2)\\chromedriver.exe" );
	driver= new ChromeDriver();
    driver.get("https://www.calculator.net/");

  }
  @Test(priority=1, groups= {"regression", "smoke"})
	public void chkTitle() {
		String title = driver.getTitle();
		System.out.println("Title is " + title);
	}
  @Test(priority=2, groups= {"regression"})
	public void bmiClick() {
	driver.findElement(By.partialLinkText("BMI")).click();
		
	}

  @Parameters({"age","height"})
  @Test(priority=3, dependsOnMethods="bmiClick", groups= {"regression"})
	public void enterValue(String age, String height) {
		driver.findElement(By.name("cage")).clear();
		driver.findElement(By.name("cage")).sendKeys(age);
		driver.findElement(By.id("cheightmeter")).clear();
		driver.findElement(By.id("cheightmeter")).sendKeys(height);
	}

  @Test(priority=4, dependsOnMethods="enterValue")
	public void test3() {
		System.out.println("Test");
  
}

}
