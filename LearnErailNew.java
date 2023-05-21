package learnTL;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnErailNew {
public static void main(String[] args) throws InterruptedException {
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--remote-allow-origins=*");
	ChromeDriver driver = new ChromeDriver(option);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://erail.in/");
	WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
	fromStation.clear();
	fromStation.sendKeys("MAS");
	Thread.sleep(500);
	fromStation.sendKeys(Keys.ENTER);
	WebElement toStation = driver.findElement(By.id("txtStationTo"));
	toStation.clear();
	toStation.sendKeys("CAPE");
	Thread.sleep(500);
	toStation.sendKeys(Keys.ENTER);
	driver.findElement(By.id("chkSelectDateOnly")).click();
	
	//Method 1:
	//find table
	WebElement table = driver.findElement(By.xpath("//table[contains(@class,'DataTable TrainList')]"));
	//from the table find no of rows
	List<WebElement> rows = table.findElements(By.tagName("tr"));
	//get data from the 1st row
	WebElement column = rows.get(1);
	List<WebElement> dataFrom1strow = column.findElements(By.tagName("td"));
	//iterate through the data and print all datas in the 1st row
	for (WebElement each : dataFrom1strow) {
		String text = each.getText();
		System.out.println(text);
		
	}
	
	//Method 2:
	//to get 2nd column data
	List<WebElement> secondColumnData = driver.findElements(By.xpath("//table[contains(@class,'DataTable TrainList')]//td[2]"));
	for (WebElement each : secondColumnData) {
		String text = each.getText();
	    System.out.println(text);
	}
	
	//Method 3:
	//to get 2nd column data
	for (int i = 1; i < rows.size(); i++) {
		List<WebElement> rowData = rows.get(i).findElements(By.tagName("td"));
		String text = rowData.get(1).getText();
		System.out.println(text);
	}
	
	//Method 4:
	//to get all datas from the table
	for (int i = 0; i < rows.size(); i++) {
		WebElement allColumns = rows.get(i);
		List<WebElement> allData = allColumns.findElements(By.tagName("td"));
		for (int j = 0; j < allData.size(); j++) {
			String text = allData.get(j).getText();
			System.out.println(text);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	WebElement table = driver.findElement(By.xpath("//table[contains(@class,'DataTable TrainList')]"));
//	List<WebElement> head = table.findElements(By.tagName("td"));
//	List<WebElement> rows = table.findElements(By.tagName("tr"));
//	List<WebElement> findElements = driver.findElements(By.xpath("//table[contains(@class,'DataTable TrainList')]//td[2]"));
////	for (int i = 1; i < rows.size(); i++) {
////		List<WebElement> findElements2 = rows.get(i).findElements(By.tagName("td"));
////		String text = findElements2.get(2).getText();
////		System.out.println(text);
////	}
//	
//	
//	WebElement column = rows.get(1);
//	List<WebElement> data = column.findElements(By.tagName("td"));
////	for (WebElement each : data) {
////		String text = each.getText();System.out.println(text);
////		
////	}
//	
////	for (int i = 0; i < rows.size(); i++) {
////		WebElement allColumns = rows.get(i);
////		List<WebElement> allData = allColumns.findElements(By.tagName("td"));
////		for (int j = 0; j < allData.size(); j++) {
////			String text = allData.get(j).getText();
////			System.out.println(text);
////		}
////	}
	
	
}
}
