package java_selenium;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListOfElementsSize {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/");
		driver.manage().window().maximize();
		
		List<WebElement> updatesList = driver.findElements(By.xpath("(//*[@class='footerlinks_2'])[2]/a"));
		
		for (WebElement lists : updatesList) {
			System.out.println(lists.getText());
		}
	}

}
