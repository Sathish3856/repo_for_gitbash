package com.basic_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWithRelativeXpath {

	public static void main(String[] args) throws InterruptedException 
	{

			WebDriver driver = new ChromeDriver();
			driver.get("https://demowebshop.tricentis.com/");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//input[@id='pollanswers-2']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//input[@type='button'])[2]")).click();
			driver.findElement(By.xpath("(//a[contains(text(),'Books')])[1]")).click();
			driver.findElement(By.xpath("(//span[contains(@class,'cart')])[3]")).click();
			driver.findElement(By.xpath("input[starts-with(value,'Subsc')]")).click();
			driver.findElement(By.xpath("//input[@type='button' or @id='vote-poll-1']")).click();
			
	}

}
