package handlingalerts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   //Draggable
		WebElement drag = driver.findElement(By.id("form:conpnl_content"));
	    Point location = drag.getLocation();
	    int x = location.getX();
	    int y = location.getY();
	    System.out.println("X Location"+x+ "y Location"+y);
	    Actions builder=new Actions(driver);
	   builder.dragAndDropBy(drag,105,200).perform();
	   //Droppable
	   WebElement source = driver.findElement(By.id("form:drag_content"));
	   WebElement destin = driver.findElement(By.id("form:drop_header"));
	   builder.dragAndDrop(source, destin).perform();
	   String cssValue = driver.findElement(By.id("form:drop_header")).getCssValue("background-color");
	   System.out.println(cssValue);
	   if(cssValue.contains("rgba(0, 113, 188, 1)")){
		  
		   System.out.println("Element dropped");
	   }
	   else {
		   System.out.println("Element Not dropped");
	   }
	   //Draggable Columns
	   WebElement colName = driver.findElement(By.id("form:j_idt94:j_idt95"));
	   WebElement colCategory = driver.findElement(By.id("form:j_idt94:j_idt97"));
	   WebElement colquality = driver.findElement(By.id("form:j_idt94:j_idt99"));
	   builder.dragAndDrop(colCategory,colName).perform();
	  // builder.clickAndHold(colCategory ).moveToElement(colName).release().perform();
	   WebElement message = driver.findElement(By.xpath("//div[@class='ui-growl-message']/span"));
	   System.out.println("Category and Name"+" "+message.getText());
	  Thread.sleep(2000);
	   builder.dragAndDrop(colquality,colCategory).perform();
	   WebElement message1 = driver.findElement(By.xpath("//div[@class='ui-growl-message']/span"));
	   System.out.println("Quality and Category"+"  "+message1.getText());
		/*
		 * List<WebElement> lst = driver.findElements(By.
		 * xpath("//th[contains(@class,'ui-state-default ui-draggable')]")); for (int i
		 * = 0; i < lst.size(); i++) { builder.clickAndHold(colCategory
		 * ).moveToElement(colName).release().perform();
		 * 
		 * } System.out.println(lst.size());
		 */
//	      //Draggable Row
//	   List<WebElement> row = driver.findElements(By.xpath("//tbody[@id='form:j_idt111_data']//tr"));
//	   int rowsize = row.size();
//	   System.out.println(rowsize);
//	   int count=0;
//	  for (int i = 1; i < rowsize; i++) {
//		 for (int j =i+1; j <rowsize; j++) {
//	   
//		  WebElement ele1 = driver.findElement(By.xpath("//tbody[@id='form:j_idt111_data']//tr["+i+"]"));
//		  WebElement ele2 = driver.findElement(By.xpath("//tbody[@id='form:j_idt111_data']//tr["+j+"]"));
//		  Thread.sleep(2000);
//		  builder.dragAndDrop(ele1,ele2).perform();
//		 // builder.clickAndHold(ele1 ).moveToElement(ele2).release().perform();
//		  Thread.sleep(3000);
//		  String msg = driver.findElement(By.xpath("//div[@class='ui-growl-message']/span")).getText();
//		  System.out.println(msg);
//		  String msg1 = driver.findElement(By.xpath("//div[@class='ui-growl-message']/p")).getText();
//		  System.out.println("RowMoved"+msg1);
//		 }
//	  }
//	//Resize Image
		  WebElement reSize = driver.findElement(By.xpath("//div[contains(@class,'ui-resizable')]"));
	     Point location2 = reSize.getLocation();
	     int x2 = location2.getX();
	     int y2 = location2.getY();
	     System.out.println(x2+"   "+y2);
		  builder.dragAndDropBy(reSize,50,10).perform();
		  Thread.sleep(1000);
		  String resizeMsg = driver.findElement(By.xpath("//div[@class='ui-growl-message']/span")).getText();
		  System.out.println(resizeMsg);
		  String resizeMsg2 = driver.findElement(By.xpath("//div[@class='ui-growl-message']/p")).getText();
		  System.out.println(resizeMsg2);
	}

	}


