package pages;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;

import base.ProjectSpecificMethods;

public class ScreenShotPage extends ProjectSpecificMethods {

	public ScreenShotPage TakeScreenShot() throws IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./data/shot.png");
		FileUtils.copyFile(src, dst);
		return this;
	}

}
