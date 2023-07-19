package actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class scroll {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(opt);
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement lastpage = driver.findElement(By.linkText("Collections"));
		Actions build = new Actions(driver);
		build.scrollToElement(lastpage).perform();
		File ajio = driver.getScreenshotAs(OutputType.FILE);
		File path = new File("./images/screen1.png");
		FileUtils.copyFile(ajio, path);
		Thread.sleep(2000);
		String text = lastpage.getText();
		System.out.println(text);
		

	}

}
