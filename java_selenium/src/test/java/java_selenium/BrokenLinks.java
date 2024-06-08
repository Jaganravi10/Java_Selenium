package java_selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		List<WebElement> allLinks =  driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		
		List<String> urlList = new ArrayList<String>();
		for (WebElement allUrlList : allLinks) {
			String url = allUrlList.getAttribute("href");
			urlList.add(url);
			
		}
		
		long startTime = System.currentTimeMillis();
		urlList.parallelStream().forEach(allUrlList->{
			try {
				checkBrokenLinks(allUrlList);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		
	}
	
	public static void checkBrokenLinks(String urlLink) throws IOException {
		
		URL url = new URL(urlLink);
		HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
		httpUrlConnection.setConnectTimeout(5000);
		httpUrlConnection.connect();
		
		if(httpUrlConnection.getResponseCode()>=400) {
			System.out.println(httpUrlConnection.getResponseMessage());
			
		}
		
		
	}

}
