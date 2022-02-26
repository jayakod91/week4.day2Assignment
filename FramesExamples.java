package week4.day2;


import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesExamples {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(" https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame(0);
		driver.findElement(By.tagName("input")).sendKeys("Testing Frames");
		WebElement element = driver.findElement(By.id("frame3"));
		driver.switchTo().frame(element);
		driver.findElement(By.id("a")).click();
		driver.switchTo().defaultContent();
		WebElement element1 = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(element1);
		WebElement Animals = driver.findElement(By.id("animals"));
		Select Animals1 = new Select(Animals);
		Animals1.selectByValue("babycat");

	}
}
