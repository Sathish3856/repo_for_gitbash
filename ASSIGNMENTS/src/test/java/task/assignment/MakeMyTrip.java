package task.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		driver.findElement(By.xpath("//li[.='Round Trip']")).click();
		driver.findElement(By.id("fromCity")).sendKeys("chen");
		driver.findElement(By.xpath("//p[.='Chennai, India']")).click();
		driver.findElement(By.id("toCity")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//span[.='Bengaluru']")).click();
		//Traveling date
		String Tday="sun";
		String Tmonth="Jul";
		int date= 28;
		long year=2024;
		String TravelingDate=Tday+" "+Tmonth+" "+date+" "+year;
		driver.findElement(By.xpath("//div[@aria-label='"+TravelingDate+"']")).click();
		//Return date
		String Rday="Fri";
		String Rmonth="Sep";
		int Rdate= 20;
		long Ryear=2024;
		String ReturnDate=Rday+" "+Rmonth+" "+Rdate+" "+Ryear;
		for(;;)
		{
			try {
				driver.findElement(By.xpath("//div[@aria-label='"+ReturnDate+"']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}	
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Search']")).click();

		
		
	}

}
