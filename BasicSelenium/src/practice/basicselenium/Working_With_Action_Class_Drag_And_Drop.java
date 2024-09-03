package com.basic_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Working_With_Action_Class_Drag_And_Drop {

	public static void main(String[] args) throws InterruptedException 
	{
			WebDriver driver = new ChromeDriver();
			driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
			driver.manage().window().maximize();
			Actions action = new Actions(driver);
			WebElement source = driver.findElement(By.id("box7"));
			WebElement target = driver.findElement(By.id("box107"));
			Thread.sleep(2000);
			
			action.dragAndDrop(source, target).build().perform();
			Thread.sleep(3000);
			
			WebElement rome = driver.findElement(By.id("box6"));
			WebElement italy = driver.findElement(By.id("box106"));
			
			action.dragAndDrop(rome, italy).build().perform();
			Thread.sleep(3000);
			driver.quit();
	}

}
