package week3;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Parallelmethod {
WebDriver driver;
	
	@Parameters("browser")
	@Test(priority=1)
	public void doParalTest(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\PriyankaKhaneja\\Desktop\\selenium new\\chromedriver_win32 (2)\\chromedriver.exe" );
			driver = new ChromeDriver();
			driver.get("http://www.google.com");
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\PriyankaKhaneja\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe" );
			driver = new FirefoxDriver();
			driver.get("http://www.google.com");
		}
		
	}
	
	

    
}