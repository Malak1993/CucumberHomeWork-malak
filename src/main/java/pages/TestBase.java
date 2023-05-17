package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;

	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver113\\chromedriver113.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	public void takeScreenshot(WebDriver driver) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File filesource=ts.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss");
		Date date = new Date();
		String label = formatter.format(date);
try {
	FileUtils.copyFile(filesource, new File(System.getProperty("user.dir")+ "/screenshot/"+ label +".png"));
} catch (IOException e) {
	e.printStackTrace();
}
	}

	public int generateRandomNumber(int bounderyNumber) {
		Random rnd=new Random();
		return rnd.nextInt(bounderyNumber);
		
	}

}
