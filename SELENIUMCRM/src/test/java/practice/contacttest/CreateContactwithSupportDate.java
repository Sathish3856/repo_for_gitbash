package practice.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactwithSupportDate {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\sathi\\WorkSpace-Tekpyramid\\Property files\\commondata.properties.txt");
		Properties pobj = new Properties();
		pobj.load(fis);
		//Read the common data from property file
		String browser = pobj.getProperty("browser");
		String url = pobj.getProperty("url");
		String username = pobj.getProperty("username");
		String password = pobj.getProperty("password");
		
		//Read testscript data from the excel file
		Random random = new Random();
		int randomNum = random.nextInt(1000);
		FileInputStream fis1 = new FileInputStream("C:\\Users\\sathi\\WorkSpace-Tekpyramid\\Excel\\testscriptdata.xlsx");
		Workbook wb= WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(1);
		String lastName = row.getCell(2).toString()+randomNum;
		wb.close();
		
		
		
		WebDriver driver = null;
		
		if(browser.equals("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		
		//step1:login to app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		//Step2:navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();
		
		//step3:click on create organization button
		driver.findElement(By.xpath("//img[contains(@title,'Create Contact...')]")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		//enter support date for start and end
		Date dateObj = new  Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String startDate = sim.format(dateObj);
		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 31);
		String endDate = sim.format(cal.getTime());
		System.out.println(startDate);
		System.out.println(endDate);
		
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		Thread.sleep(4000);
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		
		//verify contact name
		String actualStartDate=driver.findElement(By.name("support_start_date")).getText();
		String actualEndDate=driver.findElement(By.name("support_end_date")).getText();
		System.out.println(actualStartDate);
		System.out.println(actualEndDate);



		if(actualStartDate.equals(startDate)   )
		{
			System.out.println(startDate+" is displayed as Expected");
		}
		else
		{
			System.out.println(startDate+" is not displayed as Expected");
		}
		if(actualEndDate.equals(endDate)   )
		{
			System.out.println(endDate+" is displayed as Expected");
		}
		else
		{
			System.out.println(endDate+" is not displayed as Expected");
		}
		
		
		//step5:logout
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[(@src='themes/softed/images/user.PNG')]"))).perform();
		
		driver.findElement(By.partialLinkText("Sign Out")).click();
		driver.quit();
	}

}
