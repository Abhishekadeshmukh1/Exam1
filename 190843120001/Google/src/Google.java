import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Chromedriver\\chromedriver.exe");
	       WebDriver driver = new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.get("https://accounts.google.com/SignUp");
	       driver.findElement(By.id("firstName")).sendKeys("xyz");
	       driver.findElement(By.id("lastName")).sendKeys("xyz");
	       driver.findElement(By.id("username")).sendKeys("ab20001");
	       driver.findElement(By.name("Passwd")).sendKeys("190843120001");
	       driver.findElement(By.name("ConfirmPasswd")).sendKeys("190843120001");
	       driver.findElement(By.className("CwaK9")).click();
	}
}