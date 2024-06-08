package java_selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthExample {
	
	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://postman:password@postman-echo.com/basic-auth");
		String text = driver.findElement(By.cssSelector("pre")).getText();
		System.out.println(text);
		
	}

}
