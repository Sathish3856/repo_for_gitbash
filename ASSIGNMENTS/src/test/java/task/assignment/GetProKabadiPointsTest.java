package task.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetProKabadiPointsTest {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.prokabaddi.com/");
		String team= "Tamil Thalaivas";
		String position=driver.findElement(By.xpath("//p[.='"+team+"']/../../../preceding-sibling::div[@class='table-data position']/p[@class='position']")).getText();
		String point = driver.findElement(By.xpath("//p[.='"+team+"']/../../../..//div[@class='table-data matches-play']")).getText();
		String matchWon = driver.findElement(By.xpath("//p[.='"+team+"']/../../../..//div[@class='table-data matches-won']")).getText();
		String matchLost = driver.findElement(By.xpath("//p[.='"+team+"']/../../../..//div[@class='table-data matches-lost']")).getText();
		String matchDraw = driver.findElement(By.xpath("//p[.='"+team+"']/../../../..//div[@class='table-data matches-draw']")).getText();
		String form = driver.findElement(By.xpath("//p[.='"+team+"']/../../../..//div[@class='table-data form']")).getText();
		String pts = driver.findElement(By.xpath("//p[.='"+team+"']/../../../..//div[@class='table-data points']")).getText();
		


		
		
		

		
		

		
		System.out.println("position:"+position+" points: "+point+" matchWon: "+matchWon+" match Lost: "+matchLost+" match Draw : "+matchDraw+" Match form: "+form+" match points: "+pts);
	//	driver.quit();
		
	}

}
