package assignmentWeek4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(handles.get(1));
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
		driver.switchTo().window(handles.get(0));
		System.out.println(driver.getTitle());
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		for (String eachWindow : windowHandles2) {
			if(!parentWindow.equals(eachWindow)) {
				driver.switchTo().window(eachWindow);
				driver.close();
			}
		}
		
		
		
		/*
		 * driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
		 * driver.navigate().to("http://www.leafground.com/pages/Window.html"); String
		 * oldWindow = driver.getWindowHandle();
		 * driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).
		 * click(); Set<String> windowHandles = driver.getWindowHandles(); for (String
		 * allWindow : windowHandles) { if(!oldWindow.equals(allWindow)) {
		 * driver.switchTo().window(allWindow); driver.close(); } } 
		 */
		

	}

}
