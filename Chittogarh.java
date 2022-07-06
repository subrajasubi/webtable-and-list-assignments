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

public class Chittogarh {
	public static void main(String[] args) {
	   WebDriverManager.chromedriver().setup();
	   ChromeDriver driver = new ChromeDriver();
	   driver.get(" https://www.chittorgarh.com/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   driver.findElement(By.xpath("//a[contains(text(),STOCK)][5]")).click();
	   driver.findElement(By.linkText("NSE Bulk Deals")).click();
	   List<WebElement> findElements = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr"));
	   System.out.println(findElements.size());
	   List<String> list = new ArrayList<String>();
	   for (int i = 1; i < findElements.size(); i++) {
		   String text = driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr["+i+"]//td[3]")).getText();
		   list.add(text);
	}
	   System.out.println(list.size());
	  System.out.println("list:"+list); 
	  Set<String> set = new LinkedHashSet<String>(list);
	  System.out.println(set.size());
	  System.out.println("set without duplicates:"+set);
	  if(list.size()==set.size()) {
		  System.out.println("No duplicates ");
	  }
	  else {
		  System.out.println("Duplicates present");
	  }
	 
       
       
	}

}
