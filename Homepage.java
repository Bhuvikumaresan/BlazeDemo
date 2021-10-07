package flightBooking;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Homepage {


		// TODO Auto-generated method stub

	    public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32 (2)\\chromedriver.exe");
		ChromeOptions chromeOptions= new ChromeOptions(); 
		chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"); 
		ChromeDriver driver = new ChromeDriver(chromeOptions);
        String baseUrl = "https://blazedemo.com/";
        driver.get(baseUrl);
        System.out.println("success");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7000, TimeUnit.SECONDS);
        
		Select departure = new Select(driver.findElement(By.name("fromPort")));
		departure.selectByIndex(1);
		
		
		Select destination = new Select(driver.findElement(By.name("toPort")));
		destination.selectByVisibleText("Rome");
		
		driver.findElement(By.xpath("/html/body/div[3]/form/div/input")).click();
		Thread.sleep(4000);
		
		//Selecting 2nd flight
		
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[2]/td[1]/input"))).click().build().perform();
		Thread.sleep(4000);
		
		//Filling up customer details for booking
		
		driver.findElement(By.id("inputName")).sendKeys("Bhu");
		driver.findElement(By.id("address")).sendKeys("HSR");
		driver.findElement(By.id("city")).sendKeys("Bangalore");
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.id("state")).sendKeys("Karnataka");		
		driver.findElement(By.id("zipCode")).sendKeys("12356");
		driver.findElement(By.id("creditCardNumber")).sendKeys("87292029022");
		driver.findElement(By.id("nameOnCard")).sendKeys("Bhilm");
		driver.findElement(By.id("rememberMe")).click();
		
		driver.findElement(By.xpath("/html/body/div[2]/form/div[11]/div/input")).click();
		Thread.sleep(4000);
		
		//ID confirmation
		WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[1]/td[2]"));
		
		if(element.isDisplayed())
		{
			System.out.println("Your flight ticket is booked");
			}else
			{
			System.out.println("Id value is not present");
				
		}
		driver.quit();
		}}
		
		



