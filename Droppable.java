package week4.day2;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Droppable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame(0);
		WebElement dragElement = driver.findElement(By.xpath("//div[@id= 'draggable']"));
		WebElement dropElement = driver.findElement(By.xpath("//div[@id= 'droppable']"));
		Actions builder = new Actions(driver);
		builder.dragAndDrop(dragElement, dropElement).perform();
		String dropText = driver.findElement(By.xpath("//div[@id= 'droppable']")).getText();
		System.out.println("My DragDrop page text is :: "+dropText);

	}

}
