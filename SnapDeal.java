package assignmentWeek4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {









//			16. Close the main window
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		// WebDriverManager.chromedriver().setup();
		// ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		// ChromeDriver driver = new ChromeDriver();
		ChromeDriver driver = new ChromeDriver(options);
		// EdgeDriver driver = new EdgeDriver(options);
//			1. Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions builder = new Actions(driver);
//			2. Go to Mens Fashion
		WebElement mens = driver.findElement(By.xpath("//span[@class='catText']"));
//			3. Go to Sports Shoes
		WebElement sport = driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]"));
		Thread.sleep(3000);
		builder.moveToElement(mens).click(sport).perform();
//		    4. Get the count of the sports shoes
		String text = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println(text);
		Thread.sleep(3000);
//			5. Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(10000);
//			6. Sort by Low to High
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
//		7. Check if the items displayed are sorted correctly
		Thread.sleep(3000);
		List<WebElement> findElements = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<Integer>list = new ArrayList<Integer>();
		for (WebElement each : findElements) {
			
			String text2 = each.getText();
			String replaceAll =text2.replaceAll("[^0-9]","");
		     list.add(Integer.parseInt(replaceAll));
//			
		}
		System.out.println(list);
		Set<Integer> set = new TreeSet<Integer>(list);
		System.out.println(set);
//		8.Select the price range (900-1200)
		WebElement fromVal = driver.findElement(By.xpath("//input[@name='fromVal']"));
		fromVal.clear();
		fromVal.sendKeys("900");
		WebElement toVal = driver.findElement(By.xpath("//input[@name='toVal']"));
		toVal.clear();
		toVal.sendKeys("1200");
//		9.Filter with color Navy 
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
//		10 verify the all applied filters 
//		String color = "Navy";
//		Thread.sleep(8000);
//		driver.findElement(By.xpath("//a[text()='" + color + "']/../parent::div")).click();
//		String attribute = driver.findElement(By.xpath("//a[text()='" + color + "']/../parent::div"))
//				.getAttribute("class");
//		System.out.println(attribute);
//		if (attribute.contains("active-filter")) {
//			System.out.println("selected");
//		} else {
//			System.out.println("not selected");
//
//		}
		
		/*
		 * WebElement colors =
		 * driver.findElement(By.xpath("//div[@class='filters-list sdCheckbox']"));
		 * String text2 = colors.getText(); System.out.println(text2);
		 */
//		11. Mouse Hover on first resulting Training shoes

		WebElement findElement = driver.findElement(By.xpath("//div[@class='clearfix row-disc']"));
		builder.moveToElement(findElement).perform();
//		12. click QuickView button
		driver.findElement(By.xpath("//div[@class='clearfix row-disc']")).click();
//		13. Print the cost and the discount percentage
		String price = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']")).getText();
		System.out.println(price);
//		14. Take the snapshot of the shoes.
		File source=driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./Snapshot/snapdeal.png");
		FileUtils.copyFile(source, destination);
//		15. Close the current window
		driver.close();
		driver.quit();
		

	}

}
