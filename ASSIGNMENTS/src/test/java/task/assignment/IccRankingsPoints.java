package task.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccRankingsPoints {

	public static void main(String[] args) throws InterruptedException 
	{

		WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver.get("https://www.icc-cricket.com/rankings/team-rankings/mens/test");
		  String team="Australia";
		  String position=driver.findElement(By.xpath("//span[.='"+team+"']/../../../preceding-sibling::div[@class='si-table-data si-pos']")).getText();
		  String tym=driver.findElement(By.xpath("//span[text()='"+team+"']")).getText();
		  String points=driver.findElement(By.xpath("//span[.='"+team+"']/../../../following-sibling::div[@class='si-table-data si-pts']")).getText();

		  System.out.println(tym+" :"+position+" :"+points);
		  Thread.sleep(5000);
		  driver.quit();
		
		
	}

}
