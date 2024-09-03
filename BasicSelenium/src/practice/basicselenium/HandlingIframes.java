package com.basic_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingIframes {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/sathi/OneDrive/Documents/iframe.html");
		driver.manage().window().maximize();
//		SwitchToframe
		driver.switchTo().frame(1);
		Thread.sleep(3000);
//		driver.switchTo().frame("frame1");
//		driver.findElement(By.id("small-searchterms")).sendKeys("computers");
//		driver.findElement(By.className("button-1 search-box-button")).click();
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.findElement(By.partialLinkText("Go to Google")).click();
		Thread.sleep(3000);
		driver.quit();
		
		
		
	}

}
