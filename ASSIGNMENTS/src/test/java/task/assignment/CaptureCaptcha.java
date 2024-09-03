package task.assignment;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class CaptureCaptcha {

	public static void main(String[] args) throws IOException, TesseractException 
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//a[@class='search_btn loginText ng-star-inserted']")).click();
		WebElement captcha = driver.findElement(By.xpath("//img[@class='captcha-img']"));
		File source = captcha.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\sathi\\Eclipse-NewWorkspace\\ASSIGNMENTS\\screenshot\\captchaIMG.png");
		FileHandler.copy(source, destination);
		ITesseract tess = new Tesseract();
		tess.setDatapath("C:\\Users\\sathi\\Downloads\\Tess4J-3.4.8-src\\Tess4J\\tessdata");
		String text = tess.doOCR(destination) ;
		System.out.println(text);
		driver.findElement(By.xpath("//input[@id='captcha']")).sendKeys(text);
		driver.quit();

		
		
	}

}
