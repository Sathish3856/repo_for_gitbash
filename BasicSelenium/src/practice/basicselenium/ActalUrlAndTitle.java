package practice.basicselenium;

public class ActalUrlAndTitle {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Resources/driver/chromedriver.exe");
		String browserName = "edge";
		
			WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.dassault-aviation.com/en/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		String actualTitle = driver.getTitle();
		System.out.println("actualTitle "+actualTitle);
		String actualUrl = driver.getCurrentUrl();
		System.out.println("actual Url "+actualUrl);
		String execptedTitle = "Dassault Aviation, a major player to aeronautics";
		if(actualTitle.equals(execptedTitle))
		{
			System.out.println("The actual title and excepted titles are same");
		}
		else
		{
			System.out.println("The titles are not same");
		}
		
		
		
		
		
		}

}
 