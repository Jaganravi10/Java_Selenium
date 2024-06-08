package java_selenium;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadAFile {

	public static WebDriver driver;

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		String downloadFilePath = System.getProperty("user.dir");
		
		HashMap<String, Object> chromePreferences = new HashMap<String, Object>();
		chromePreferences.put("profile.default_content_settings.popups", 0);
		chromePreferences.put("download.default_directory", downloadFilePath);
		options.setExperimentalOption("prefs", chromePreferences);
		
		driver = new ChromeDriver(options);
		driver.get("https://omayo.blogspot.com/p/page7.html");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("ZIP file")).click();
		
		File file = new File(downloadFilePath+"//DownloadDemo-master.zip");
		
		if(file.exists()) {
			System.out.println("File successfully downloaded");
		}else {
			System.out.println("File not downloaded, please check");
		}
		
	}

}
