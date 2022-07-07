package demo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal { 

public static void main(String[] args) throws InterruptedException, IOException {
	WebDriverManager.firefoxdriver().setup();
 FirefoxOptions options = new FirefoxOptions();
	//WebDriverManager.chromedriver().setup();
	//ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable notifications");
	//ChromeDriver driver = new ChromeDriver();
	FirefoxDriver driver = new FirefoxDriver(options);
	//EdgeDriver driver = new EdgeDriver(options);
	driver.get("https://www.snapdeal.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	Actions builder = new Actions(driver);
	WebElement mens = driver.findElement(By.xpath("//span[@class='catText']"));
	WebElement sport = driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]"));
	Thread.sleep(15000);
		builder.moveToElement(mens).click(sport).perform();
	
	String text = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
	System.out.println(text);
	Thread.sleep(10000);
	
			//driver.findElement(By.xpath("(//a[@class='child-cat-node dp-widget-link hashAdded'])[3]")).click();
	
		    driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
			Thread.sleep(10000);

			driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
			WebElement fromVal = driver.findElement(By.xpath("//input[@name='fromVal']"));
			fromVal.clear();
			fromVal.sendKeys("900");
			WebElement toVal = driver.findElement(By.xpath("//input[@name='toVal']"));
			toVal.clear();
			toVal.sendKeys("1200");
			driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
			String color = " White";
			driver.findElement(By.xpath("//a[text()='"+color+"']/../parent::div")).click();
			String attribute = driver.findElement(By.xpath("//a[text()='"+color+"']/../parent::div")).getAttribute("class");
			System.out.println(attribute);
			if (attribute.contains("active-filter")) {
				System.out.println("selected");
			} else {
				System.out.println("not selected");

			}
			/*
			 * WebElement colors =
			 * driver.findElement(By.xpath("//div[@class='filters-list sdCheckbox']"));
			 * String text2 = colors.getText(); System.out.println(text2);
			 */
	
	
	}

}