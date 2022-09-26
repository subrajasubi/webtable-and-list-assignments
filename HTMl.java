package assignmentWeek4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTMl {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// 1. Launch the URL https://html.com/tags/table/
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//2. Get the total  number of rows
		List<WebElement> totalRows = driver.findElements(By.xpath("//table//tr"));
		System.out.println("Total no of rows in this table :"+totalRows.size());
		//3.Get the count of number of rows of the first table
		List<WebElement> rows = driver.findElements(By.xpath("(//table)[1]//tr"));
		System.out.println("Total no of rows in the first table :"+rows.size());
		List<String> list = new ArrayList<String>();
		//to get the text of Absolute usage
		List<String> list1 = new ArrayList<String>();
		String[] arr = {"Absolute Usage","Market Share"};
		for (String string : arr) {
			if (string.equals("Absolute Usage")) {
				List<WebElement> value = driver.findElements(By.xpath("//div[@class='render']//td[text()='"+string +"']/following-sibling::td"));
				for (WebElement webElement : value) {
					String text = webElement.getText();
					list.add(text);
				}
			}
	//to get the text of market share	
			else if(string.equals("Market Share")) {
			List<WebElement>  marketShare = driver.findElements(By.xpath("//div[@class='render']//td[text()='"+string+"']/following-sibling::td"));
			
			for (WebElement each : marketShare) {
				String text1 = each.getText();
				list1.add(text1);
			}
			}
			
		}
		System.out.println("Absolute Usage  values : "+list);
		System.out.println("Market Share Values : "+list1);
		//3. Get the total of number of columns
		List<WebElement> columns = driver.findElements(By.xpath("//table//tr//th"));
		System.out.println("total no.of columns : "+columns.size());
		//3.Get the count of number of columns of the first table
		List<WebElement> coulumns1 = driver.findElements(By.xpath("(//table)[1]//tr//th"));
		System.out.println("Total no of coulmns in first table :"+coulumns1.size());
		
		  
		
		
	}

}

