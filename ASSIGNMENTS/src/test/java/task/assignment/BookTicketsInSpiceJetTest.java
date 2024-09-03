package task.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class BookTicketsInSpiceJetTest {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		
	
		driver.findElement(By.xpath("//div[text()='From']")).click();
		
	
		driver.findElement(By.xpath("//div[text()='From']/..//input")).sendKeys("Kol");
		
		
		driver.findElement(By.xpath("//div[text()='To']/..//input")).sendKeys("bho");
		
		
		driver.findElement(By.xpath("//div[text()='July ' and text()='2024']/../..//div[text()='30']")).click();
		
		driver.findElement(By.xpath("//div[text()='Return Date']")).click();
		
		
		for (; ;) {
			try {
				driver.findElement(By.xpath("//div[text()='September ' and text()='2024']/../..//div[text()='20']")).click();
				break;
			} 
			catch (Exception e) 
			{
				driver.findElement(By.cssSelector("g[transform='translate(1 1)']")).click();
			}
			
		}
		
	
		driver.findElement(By.xpath("//div[text()='Passengers']/..")).click();
		
	
		WebElement plusAdult = driver.findElement(By.cssSelector("div[data-testid='Adult-testID-plus-one-cta']"));
		WebElement plusChildren = driver.findElement(By.cssSelector("div[data-testid='Children-testID-plus-one-cta']"));
		int count= 0;
		while (count < 4) 
		{
			if(count<3) 
			{
				plusAdult.click();

			}
			plusChildren.click();
			count++;
		}
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[text()='Search Flight']/..")).click();
		driver.quit();
		
	}

}
