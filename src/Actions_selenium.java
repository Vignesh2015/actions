import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class Actions_selenium {
	
	static WebDriver driver = null;
	
	
	@Test
	public void actionsTest() throws Exception {
		
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "D:\\Selenium\\Logs\\mozilla.log");
		
		driver = new FirefoxDriver();
		driver.get("https://www.americangolf.co.uk/");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		String pageTitle = driver.getTitle();
		System.out.println("Page title displayed "+"------->"+pageTitle);
		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'American Golf')]")));
		
	
		WebElement src = driver.findElement(By.xpath("//div[@id='header-navigation']/div/ul/li[1]/a"));
		Actions action = new Actions(driver);
		
		action.moveToElement(src).build().perform();
		
		WebDriverWait subMenuwait = new WebDriverWait(driver, 30);
		subMenuwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='CLUBS_1']/ul/li[2]/ul/li[2]/a/span[1]"))));
		
		//driver.findElement(By.xpath("//*[@id='CLUBS_1']/ul/li[2]/ul/li[2]/a/span[1]")).click();
		
		WebElement menuCount = driver.findElement(By.xpath("//*[@id='CLUBS_1']"));
		
		List<WebElement> total = menuCount.findElements(By.tagName("a"));
		System.out.println("Total menu are "+"-----"+total.size());
		
		 Random rm = new Random();
		 int size = rm.nextInt(total.size());
		 String text = total.get(size).getText();
		 total.get(size).click();
			
		}
		
    
	
	
		

	
	
	@AfterTest
	public void tearDown() throws Exception {
		
		Thread.sleep(10000);
		driver.quit();
	}
	

}
