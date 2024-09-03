package com.basic_selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClass {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("Books")).click();
		Thread.sleep(3000);

		
		WebElement sort = driver.findElement(By.id("products-orderby"));
		Select obj = new Select(sort);
//		obj.selectByVisibleText("Price: Low to High");
//		Thread.sleep(3000);
		
//		WebElement dis = driver.findElement(By.id("products-pagesize"));
//		Select obj1 = new Select(dis);
//		obj1.selectByValue("https://demowebshop.tricentis.com/books?pagesize=12");
		
		
//		WebElement view = driver.findElement(By.id("products-viewmode"));
//		Select obj2 = new Select(view);
//		obj2.selectByIndex(1);
//	
		
		List<WebElement>list_values = obj.getOptions();
		
		for(WebElement display_value:list_values)
		{
				System.out.println(display_value.getText());	
		}
		
//		System.out.println(obj1.isMultiple());
//		obj1.deselectByVisibleText("Price: Low to High");
//		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
