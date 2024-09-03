package com.basic_selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {

	public static void main(String[] args)
	{
			WebDriver driver = new ChromeDriver();
			driver.get("https://demowebshop.tricentis.com/");
			driver.manage().window().maximize();
			//Get all the Links on the WebPage
			List<WebElement>links = driver.findElements(By.xpath("//a"));
			for(int i=0;i<links.size()-1;i++)
				{
					String linkText = links.get(i).getText();
//					System.out.println(links.get(i));
//					System.out.println(linkText);
				}
			
			for(WebElement element:links)
			{
				String link = element.getAttribute("href");
				System.out.println(link);
			}
			
			driver.quit();
			
			
	}

}
