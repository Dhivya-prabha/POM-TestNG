package simpleCodeWithoutFrameWork;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UpdateProblemTicket {
	

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

		// select impact
		WebElement impact = driver.findElementById("problem.impact");

		Select impDropDown = new Select(impact);
		impDropDown.selectByIndex(1);

		// select Urgency
		WebElement urgency = driver.findElementById("problem.urgency");

		Select urgDropDown = new Select(urgency);
		urgDropDown.selectByIndex(1);
		
		//Enter worknotes
		Thread.sleep(2000);
		driver.findElementById("activity-stream-work_notes-textarea").sendKeys("testing");
		
		//Click on update
		driver.findElementById("sysverb_update").click();
		
		//search the problem number
		driver.findElementByXPath("((//label[text()='Search'])[2]/following::input)[1]").sendKeys(probNumber,Keys.ENTER);
		
		String priority = driver.findElementByXPath("//table[@id='problem_table']//tr[1]/td[9]").getText();
		
		if(priority.contains("Moderate")) {
			System.out.println("update is successful");
		}
		else {
			System.out.println("update is not successful");
		}
	}

}
