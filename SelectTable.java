package week4.day2;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SelectTable {


		public static void main(String[] args) {
			
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://jqueryui.com/selectable");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.switchTo().frame(0);
			WebElement elementItem1 = driver.findElement(By.xpath("//li[contains(text(),'Item 1')]"));
			WebElement elementItem2 = driver.findElement(By.xpath("//li[contains(text(),'Item 2')]"));
			WebElement elementItem3 = driver.findElement(By.xpath("//li[contains(text(),'Item 3')]"));
			WebElement elementItem4 = driver.findElement(By.xpath("//li[contains(text(),'Item 4')]"));
			WebElement elementItem5 = driver.findElement(By.xpath("//li[contains(text(),'Item 5')]"));
			WebElement elementItem6 = driver.findElement(By.xpath("//li[contains(text(),'Item 6')]"));
			Actions builder = new Actions(driver);
			builder.keyDown(Keys.CONTROL).click(elementItem1).click(elementItem2)
			.click(elementItem3).click(elementItem4).
			click(elementItem5).click(elementItem6).keyUp(Keys.CONTROL).perform();
		}
}
