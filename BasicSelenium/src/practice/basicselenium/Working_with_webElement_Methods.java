package com.basic_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Working_with_webElement_Methods {

	public static void main(String[] args) throws InterruptedException 
	{

		WebDriver driver = new ChromeDriver ();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("small-searchterms")).sendKeys("Sathish");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit' and @value='Search']")).submit();
		//WebElement Getter
	  	WebElement obj = driver.findElement(By.className("ico-register"));
	  	String text = obj.getText();
	  	System.out.println(text);
		String value = driver.findElement(By.xpath("(//input[@type='button'])[1]")).getAttribute("class");
		System.out.println(value);
		String valueAtCompileTime = driver.findElement(By.xpath("//input[@value='Search store']")).getAttribute("value");
		System.out.println(valueAtCompileTime);
	    driver.findElement(By.xpath("//input[@value='Search store']")).sendKeys("Sathish");
	    String valueAtRunTime = driver.findElement(By.xpath("//input[@value='Search store']")).getAttribute("value");
	    System.out.println(valueAtRunTime);
		String cssColor = driver.findElement(By.linkText("Register")).getCssValue("color");
		System.out.println(cssColor);
		if(	driver.findElement(By.id("small-searchterms")).isDisplayed())
		{
			driver.findElement(By.id("small-searchterms")).sendKeys("sk");
			
		}
		
		if(driver.findElement(By.xpath("//input[@value='Search']")).isEnabled());
			{
				driver.findElement(By.xpath("//input[@value='Search']")).submit();
			}
		
		//Check if the radio button is enabled
		
		driver.findElement(By.id("pollanswers-3")).click();
		
		if(driver.findElement(By.id("pollanswers-3")).isSelected());
		{
			System.out.println("Radio Button is Selected");
		}
		
			driver.quit();
		
		
	}


	
	}


