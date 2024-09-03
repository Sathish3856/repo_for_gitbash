package com.basic_selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Working_With_JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demowebshop.tricentis.com/");
		//Typecasting of javascript executor with driver instance
		JavascriptExecutor js =  (JavascriptExecutor)driver;
//		js.executeScript("document.getElementById('small-searchterms').value='computers';")  ;
		WebElement search = driver.findElement(By.xpath("//input[@type='submit']"));
		WebElement vote = driver.findElement(By.xpath("(//input[@type='button'])[2]"));

		js.executeScript("arguments[0].click();", search,vote);
		
		
		
	}

}
