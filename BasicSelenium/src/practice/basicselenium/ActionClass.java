package com.basic_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		//Create an object for action Class
		Actions action = new Actions(driver);
		WebElement computer = driver.findElement(By.xpath("(//a[contains(text(),'Computer')])[1]"));
		action.moveToElement(computer).build().perform();
		WebElement desktop = driver.findElement(By.xpath("(//a[contains(text(),'Desktops')])[1]"));
		action.moveToElement(desktop).click().build().perform();
		
		driver.quit();
		
		
		
	}

}
