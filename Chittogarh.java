package assignmentWeek4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittogarh {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// 1. Launch the URL https://www.chittorgarh.com/
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//2. Click on stock market
        driver.findElement(By.xpath("(//div[@class='ch-bar float-start w-100 overflow-hidden']//a)[5]")).click();
        //3. Click on NSE bulk Deals
        driver.findElement(By.linkText("NSE Bulk Deals")).click();
        //4. Get all the Security names
        List<WebElement> securityNames = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr//td[3]"));
        List<String> list = new ArrayList<String>();
        for (int i = 1; i <securityNames.size(); i++) {
        	String text = driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr["+i+"]//td[3]")).getText();
        	list.add(text);
		}
//        for (WebElement string : securityNames) {
//        	String text = string.getText();
//	      
//			list.add(text);
//			
//		}
        System.out.println("List size = "+list.size());
        System.out.println(list);
        //5. Ensure whether there are duplicate Security names
        Set<String> set = new TreeSet<String>(list);
        System.out.println("Set Size = "+set.size());
        if (list.size()==set.size()) {
			System.out.println("Duplicates not found");
		}
        else {
        	System.out.println("Found");
        }
        System.out.println(set);
	}

}

