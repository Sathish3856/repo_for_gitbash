package com.basic_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Working_With_ClickAndHold {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		WebElement washington = driver.findElement(By.id("box3"));
		WebElement uns =driver.findElement(By.id("box103"));
		action.clickAndHold(washington).moveToElement(uns).release().perform();
		Thread.sleep(3000);
		driver.quit();
		
		
		
		
	}

}
