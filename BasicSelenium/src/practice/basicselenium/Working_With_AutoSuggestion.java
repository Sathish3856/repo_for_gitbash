package com.basic_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Working_With_AutoSuggestion {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
//		driver.get("https://demowebshop.tricentis.com/");
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
//		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("compu");
//		Thread.sleep(3000);
//		driver.findElement(By.partialLinkText("Build your own computer")).click();
//		driver.quit();
		
		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("puma");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='puma'])[1]")).click();
		driver.quit();
		
		
	}

}
