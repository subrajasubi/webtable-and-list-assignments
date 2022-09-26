package handlingalerts;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(handles.get(1));
		String title2 = driver.getTitle();
		System.out.println(title2);
		if(title.equals(title2)) {
			System.out.println("Control not switched");
		}
		else {
			System.out.println("Control switched");
		}
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> handles2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(handles2.get(1));
		for (String eachWindow : handles2) {
			if (!eachWindow.equals(parentWindow)) {
				driver.switchTo().window(eachWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> handles3 = new ArrayList<String>(windowHandles3);
		System.out.println(handles3.size());
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
//		WebDriverManager.chromedriver().setup();
//		ChromeDriver driver=new ChromeDriver();
//		driver.get("https://leafground.com/window.xhtml");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	    //Click and Confirm new Window Opens
//		String parentWindow = driver.getWindowHandle();
//		String title1 = driver.getTitle();
//		System.out.println("Title of the parent window:"+title1);
//		driver.findElement(By.xpath("//span[text()='Open']//parent::button[contains(@class,'ui-button')]")).click();
//		Set<String> windowHandles = driver.getWindowHandles();
//		List<String>lstwindow=new ArrayList<String>(windowHandles);
//		driver.switchTo().window(lstwindow.get(1));
//		String title2 = driver.getTitle();
//		System.out.println(title2);
//		if(title1.equals(title2))
//		{
//			System.out.println("New page not open");
//		}
//		else {
//			System.out.println("New page open");
//		}
//		driver.close();
//		driver.switchTo().window(lstwindow.get(0));
//		//Close all windows except Primary
//		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
//		Set<String> windowHandles1 = driver.getWindowHandles();
//		System.out.println(windowHandles1.size());
//		List<String>lstwindow1=new ArrayList<String>(windowHandles1);
//		driver.switchTo().window(lstwindow1.get(1));
//		String title3 = driver.getTitle();
//		System.out.println(title3);
//		for (String allWindow : lstwindow1) {
//			if(!allWindow .equals(parentWindow)) {
//				driver.switchTo().window(allWindow);
//				driver.close();
//				
//			}
//		}
//			driver.switchTo().window(lstwindow1.get(0));
//			//Find the number of opened tabs
//			driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
//			Set<String> windowHandles2 = driver.getWindowHandles();
//			System.out.println("number of opened tabs"+windowHandles2.size());
//			 System.out.println(driver.getTitle());
//			 driver.navigate().back();
//	        //Wait for 2 new tabs to open
//	        WebElement newWindow = driver.findElement(By.xpath("//span[text()='Open with delay']"));
//	        newWindow.click();
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.stalenessOf(newWindow));
//	        Set<String> windowHandles3 = driver.getWindowHandles();
//	        System.out.println("New Tab open:"+windowHandles3.size());
//	        driver.quit();
	        
	}
	
	}


