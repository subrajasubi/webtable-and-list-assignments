package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HtmlTable1 {
	public static void main(String[] args) {
	   WebDriverManager.chromedriver().setup();
	   ChromeDriver driver = new ChromeDriver();
	   driver.get("https://html.com/tags/table/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   List<WebElement> rowCount = driver.findElements(By.xpath("//table//tr[1]"));
	   System.out.println(rowCount.size());
	   List<WebElement> headingCount = driver.findElements(By.xpath("//table//thead//th"));
	   System.out.println(headingCount.size());
       
       
	}

}
