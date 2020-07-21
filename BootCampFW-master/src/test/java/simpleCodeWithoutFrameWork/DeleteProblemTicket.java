package simpleCodeWithoutFrameWork;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;


public class DeleteProblemTicket {
	

	public static void main(String[] args) throws InterruptedException {
		// setting up property
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		// Declaring object for Chrome driver
		ChromeDriver driver = new ChromeDriver();

		// Maximize window
		driver.manage().window().maximize();

		// add implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Launching url
		driver.get("https://dev77567.service-now.com/");

		// Wait
		// Thread.sleep(8000);

		// Switch to login frame
		driver.switchTo().frame(0);

		// entering user_name
		driver.findElementById("user_name").sendKeys("admin");

		// entering pass_word
		driver.findElementById("user_password").sendKeys("India@123");

		// Clicking Login button
		driver.findElementById("sysverb_login").click();

		// search for callers in filter
		driver.findElementById("filter").sendKeys("problem", Keys.ENTER);

		Thread.sleep(2000);
		// click on Open
		driver.findElementByXPath("(//div[text()='Open'])[2]").click();

		// Switch to frame
		driver.switchTo().frame("gsft_main");
		
		//sort problem number by descending order
		String sortOrder = driver.findElementByXPath("//a[text()='Number']").getAttribute("data-original-title");

		Thread.sleep(2000);
		if(sortOrder.equals("Sorted in ascending order")) {
			
			// sort in descending order
			driver.findElementByXPath("//a[text()='Number']").click();
		}
		
		
		Thread.sleep(4000);
		// get problem number
		String probNumber = driver.findElementByXPath("//table[@id='problem_table']//tr[1]/td[3]").getText();

		// click existing problem number
		driver.findElementByXPath("//table[@id='problem_table']//tr[1]/td[3]").click();

		//Click on delete
		driver.findElementById("sysverb_delete").click();
		
		//Accept alert
		driver.findElementByXPath("//button[@id='ok_button']").click();
		
		//search the problem number
		
		Thread.sleep(3000);
		driver.findElementByXPath("(//label[text()='Search'])[2]/following::input").sendKeys(probNumber,Keys.ENTER);
		
		
		
		
		if(driver.findElementByXPath("//td[text()='No records to display']").isDisplayed()) {
			System.out.println("delete is successful");
		}
		else {
			System.out.println("delete is not successful");
		}
	}

}
