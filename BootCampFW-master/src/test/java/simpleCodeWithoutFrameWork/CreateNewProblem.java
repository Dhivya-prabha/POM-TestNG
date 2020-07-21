package simpleCodeWithoutFrameWork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateNewProblem {

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
			//	Thread.sleep(8000);

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
				//click on  Create New
				driver.findElementByXPath("(//div[text()='Create New'])[2]").click();
				
				// Switch to frame
				driver.switchTo().frame("gsft_main");
				
				//get problem number
				String probNumber = driver.findElementById("problem.number").getAttribute("value");
				
				//enter configuration item
				driver.findElementById("sys_display.problem.cmdb_ci").sendKeys("Oracle FLX");
				Thread.sleep(2000);
				//enter short description
				driver.findElementById("problem.short_description").sendKeys("oracle problem");
				
				//click submit
				driver.findElementById("sysverb_insert").click();
				
								
				//search the problem number
				driver.findElementByXPath("((//label[text()='Search'])[2]/following::input)[1]").sendKeys(probNumber,Keys.ENTER);
				
				if(driver.findElementByLinkText(probNumber).isDisplayed()) {
					System.out.println("problem created successfully");
				}
				else {
					System.out.println("problem not created");
				}

	}

}
