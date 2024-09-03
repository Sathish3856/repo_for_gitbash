package task.assignment;

import java.time.Duration;

import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FileUpload {

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.orangehrm.com/en/book-a-free-demo/");
		
		driver.findElement(By.id("Form_getForm_FullName")).sendKeys("dinga");
		driver.findElement(By.id("Form_getForm_Email")).sendKeys("dinga@gmail.com");
		driver.findElement(By.id("Form_getForm_CompanyName")).sendKeys("qspiders");
		WebElement ele = driver.findElement(By.id("Form_getForm_Country"));
		Select dd = new Select(ele);
		dd.selectByVisibleText("India");
		driver.findElement(By.id("Form_getForm_Contact")).sendKeys("1234567890");
		driver.switchTo().frame(0);
		driver.findElement(By.className("recaptcha-checkbox-border")).click();
		driver.findElement(By.id("Form_getForm_action_submitForm")).submit();
		
		
	
		
		
		
	}

}
