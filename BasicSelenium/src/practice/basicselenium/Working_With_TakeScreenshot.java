package com.basic_selenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Working_With_TakeScreenshot {

	public static void main(String[] args) throws IOException 
	{
		
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");

		//Type Cast to get the capability of takescreenshot interface to the driver instance
		//TypeCasting
//		TakesScreenshot ts = (TakesScreenshot)driver;
		
		
		//Temporary location
		File srcfile=driver.getScreenshotAs(OutputType.FILE);
		//Destination File
		File destfile=new File("./screenshots/HomePage.png");
		FileHandler.copy(srcfile, destfile);
		
		//TakeScreenshot on Particular Webelement
		
		WebElement srchtxt = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		srchtxt.sendKeys("Sathish");
		
		File srcfile1 = srchtxt.getScreenshotAs(OutputType.FILE);
		File dst1 = new File("./screenshots/searchtextfield.png");
		FileHandler.copy(srcfile1, dst1);
		driver.close();
		
		
		
		
		
	}

	
}
