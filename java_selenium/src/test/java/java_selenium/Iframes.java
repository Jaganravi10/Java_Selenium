package java_selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Iframes {
	
	public static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://qavbox.github.io/demo/iframes/");
		driver.manage().window().maximize();
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		WebElement firstFrame = driver.findElement(By.xpath("//iframe[@name='Framename1']"));
		driver.switchTo().frame(firstFrame);
		String actualIframeText = driver.findElement(By.xpath("//p[@id='frametext']")).getText();
		System.out.println(actualIframeText);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("Frame2");
		driver.findElement(By.id("frameinput")).sendKeys("Hello there !");
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("input1")).sendKeys("Jagan");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.close();
		
	}

}
