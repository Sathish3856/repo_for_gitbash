package com.basic_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Working_With_ShadowRootElement {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/ui/shadow");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
//		SearchContext name=driver.findElement(By.xpath("//form/div[1]")).getShadowRoot();
//		name.findElement(By.cssSelector("input[type='text']")).sendKeys("Sathish");
		
		driver.findElement(By.xpath("//h1[text()='Login']")).click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("Sathish").perform();
		Thread.sleep(3000);
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("Sathish@123").perform();
		Thread.sleep(3000);
		driver.quit();
	}

}
