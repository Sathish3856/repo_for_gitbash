package task.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PriceOfFirstElement {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/?tag=msndeskstdin-21&ref=pd_sl_1hedhu36ah_e&adgrpid=1324913168722107&hvadid=82807336663554&hvnetw=o&hvqmt=e&hvbmt=be&hvdev=c&hvlocint=&hvlocphy=149966&hvtargid=kwd-82808009057386:loc-90&hydadcr=5620_2377278&msclkid=1bbad751d5cd109e842bb1f0e118170a");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.name("field-keywords")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		WebElement element=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		String price=element.getText();
		System.out.println(price);
		Thread.sleep(50000);
		driver.quit();
		

	}

}
