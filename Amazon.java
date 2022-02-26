package week4.day2;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("One plus 9 pro");
		WebElement search1 = driver.findElement(By.id("nav-search-submit-button"));
		search1.click();
		WebElement firstProduct = driver.findElement(By.xpath("//span[text()='OnePlus 9 Pro 5G (Pine Green, 12GB RAM, 256GB Storage)']"));
		firstProduct.click();
		String price = driver.findElement(By.xpath("(//span[@data-a-size='b']//span)[2]")).getText();
		System.out.println("The price of the first product is :: "+price);
		Thread.sleep(2000);
		WebElement customerReview = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']"));
		String ratings = customerReview.getText();
		System.out.println("Number of customer ratings for the first product is :: "+ratings);
		driver.findElement(By.xpath("//a[@href='javascript:void(0)']//i")).click();
		WebElement RatingTable = driver.findElement(By.id("histogramTable"));
		List<WebElement> Rows = RatingTable.findElements(By.tagName("tr"));
		WebElement firstRow = Rows.get(1);
		int TotalColumn = firstRow.findElements(By.tagName("td")).size();
		System.out.println("Number of Columns: " + TotalColumn);
		System.out.println("Number of rows: " + Rows.size());
		for (int i = 0; i < Rows.size(); i++) {
			WebElement currentRow = Rows.get(i);
			List<WebElement> listColumns = currentRow.findElements(By.tagName("td"));
			for (int j = 0; j < listColumns.size(); j++)
			{
				if (listColumns.get(j).getText().contains("5 star")) 
				{
					System.out.println("Percentage of 5 Star rating is " + listColumns.get(2).getText());
				}

			}
		}
		driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base')]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		String secondWindow = list.get(1);
		driver.switchTo().window(secondWindow);

		WebElement Image = driver.findElement(By.id("imgTagWrapperId"));
		File source = Image.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/main/resources/snaps/Amazon.jpg");
		FileUtils.copyFile(source, dest);
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(2000);
		String CartTotal = driver.findElement(By.xpath("//span[@id = 'attach-accessory-cart-subtotal']")).getText();
		//String CartPrice = CartTotal;
		System.out.println("The Cart Sub-Total is :: "+CartTotal);
		Thread.sleep(2000);

		if (CartTotal.equals(price)) {
			System.out.println("Cart sub total is verified");
		}else {
			System.out.println("Cart sub total is not verified");
		}

		driver.close();

		

	}

}
