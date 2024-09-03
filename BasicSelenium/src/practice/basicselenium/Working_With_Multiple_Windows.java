package com.basic_selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Working_With_Multiple_Windows {

	public static void main(String[] args) throws InterruptedException 
	{
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		String parent_window = driver.getWindowHandle();
		System.out.println(parent_window);
		driver.findElement(By.partialLinkText("Open New Seperate Windows")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[contains(text(),'click')])[2]")).click();
		Set<String>window_handles = driver.getWindowHandles();
//		System.out.println(window_handles);
		
		for(String titles:window_handles)
		{
			driver.switchTo().window(titles);
			String title=driver.getTitle();
			System.out.println(title);
			driver.switchTo().window(parent_window);
			driver.close();
		}
		driver.quit();
		 
		
		
		
		
		
		
	}

}
