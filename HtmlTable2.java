package week4.day1.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HtmlTable2 {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://html.com/tags/table/");
		//String text = "Absolute Usage";
		String[] arr = {"Absolute Usage","Market Share"};
		for (String string : arr) {
			if (string.equals("Absolute Usage")) {
				List<WebElement> value = driver.findElements(By.xpath("//div[@class='render']//td[text()='"+string +"']/following-sibling::td"));
				for (WebElement webElement : value) {
					System.out.println(webElement.getText());
				}
			}
			
			//System.out.println("---------------------------");
		}
		
		
		/*
		 * for (int i = 1; i <=5; i++) { if(i==3) { Thread.sleep(3000); String text =
		 * driver.findElement(By.xpath("(//div[@class='render']//tr)[i]")).getText();
		 * System.out.println(text); } else if(i==4){ String text =
		 * driver.findElement(By.xpath("(//div[@class='render']//tr)[i]")).getText();
		 * System.out.println(text); } }
		 */
	}	

}
