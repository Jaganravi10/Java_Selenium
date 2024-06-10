package java_selenium;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshot {
	
	public static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationFolder = System.getProperty("user.dir")+"\\Screenshots\\"+"HomePage.png";
		try {
			org.openqa.selenium.io.FileHandler.copy(screenshotFile, new File(destinationFolder));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
