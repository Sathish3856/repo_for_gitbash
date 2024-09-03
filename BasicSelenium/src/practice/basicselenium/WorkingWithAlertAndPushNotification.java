package com.basic_selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithAlertAndPushNotification {

	public static void main(String[] args) throws InterruptedException 
	{
		
		WebDriver driver = new ChromeDriver();
//		driver.get("https://demowebshop.tricentis.com/");
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
//		Thread.sleep(3000);
//		Alert alert = driver.switchTo().alert();
//		alert.dismiss();
//		System.out.println("Alerts are created Successfully");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Dexter");
//		driver.quit();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("7502");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Alert ale=driver.switchTo().alert();
		Thread.sleep(3000);
		ale.dismiss();
		Thread.sleep(3000);
		driver.quit();
		
		
		
		
	}

}
