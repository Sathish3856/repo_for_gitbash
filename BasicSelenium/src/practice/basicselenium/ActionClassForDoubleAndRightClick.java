package com.basic_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassForDoubleAndRightClick {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		
		WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me To See Alert')]"));
		action.doubleClick(button).build().perform();
		Thread.sleep(3000);
		
		WebElement right_click = driver.findElement(By.xpath("//span[contains(text(),'right click me')]")); 
		action.contextClick(right_click).build().perform();
		Thread.sleep(3000);
		
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Delete']"))).click().build().perform();
		Thread.sleep(2000);
		
		
		
		driver.quit();
	}

}
