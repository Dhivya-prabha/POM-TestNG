package simpleCodeWithoutFrameWork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChatQueueEntry {
	public static void main(String[] args) throws InterruptedException {
		// setting up property
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		// Declaring object for Chrome driver
		ChromeDriver driver = new ChromeDriver();

		// Maximize window
		driver.manage().window().maximize();

		// add implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Launching URL
		driver.get("https://dev77567.service-now.com/");

		// Wait
		Thread.sleep(8000);

		// Switch to login frame
		driver.switchTo().frame(0);

		// entering user_name
		driver.findElementById("user_name").sendKeys("admin");

		// entering pass_word
		driver.findElementById("user_password").sendKeys("India@123");

		// Clicking Login button
		driver.findElementById("sysverb_login").click();

		// search for callers in filter
		driver.findElementById("filter").sendKeys("My Work", Keys.ENTER);

		// wait
		Thread.sleep(6000);

		// Click on my work
		driver.findElementByXPath("(//div[text()='My Work'])[1]").click();

		// Switch to frame
		driver.switchTo().frame("gsft_main");

		// click on new
		driver.findElementById("sysverb_new").click();

		// Click on chat_queue_entry
		driver.findElementByXPath("//a[text()[normalize-space()='Chat_queue_entry']]").click();

		// enter short description
		driver.findElementById("chat_queue_entry.short_description").sendKeys("Testing");

		// enter work notes
		driver.findElementById("chat_queue_entry.work_notes").sendKeys("Selenium");

		// Get the value of chat queue entry
		String chngnum = driver.findElementById("chat_queue_entry.number").getAttribute("value");
		
		// click on submit button
		driver.findElementById("sysverb_insert").click();

		// search the created chat queue entry
		driver.findElementByXPath("((//label[text()='Search'])[2]/following::input)[1]").sendKeys(chngnum, Keys.ENTER);

	

		
		  // get text of the displayed chat queue entry String chng =
		  String chng = driver.findElementByXPath("(//tr[@data-list_id='task']//td)[3]").getText();
		
		  
		  // verify whether created chat queue entry is said to be the same String
		  String chngg = driver.findElementByXPath("(//tr[@data-list_id='task']//td)[3]").getText();
		  if (chngg.equals(chng)) 
		  { System.out.println("Chat queue entry is created");
		  
		  } 
		  else { System.out.println("error occured"); } }
		 

	
}
