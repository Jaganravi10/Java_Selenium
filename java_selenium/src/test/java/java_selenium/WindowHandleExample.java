package java_selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleExample {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//*[@class='btn btn-info']) [1]")).click();
		
		
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> iterator = allWindows.iterator();
		String parentWindow = iterator.next();
		String childWindow = iterator.next();
		
		driver.switchTo().window(childWindow);
		String childWindowTitle = driver.getTitle();
		System.out.println(childWindowTitle);
		driver.switchTo().window(parentWindow);
		
//		Set<String> allWindows = driver.getWindowHandles();
//		Iterator<String> iterator = allWindows.iterator();
//		String parentWindow = iterator.next();
//		String childWindow = iterator.next();
//		
//		driver.switchTo().window(childWindow);
//		
//		String childWindowTitle = driver.getTitle();
//		driver.switchTo().window(parentWindow);
//		System.out.println(childWindowTitle);
//		
		
	}

}
