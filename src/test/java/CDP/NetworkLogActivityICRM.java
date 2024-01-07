package CDP;

import java.time.Duration;
import java.util.Optional;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.network.Network;
import org.openqa.selenium.devtools.v119.network.model.Request;
import org.openqa.selenium.devtools.v119.network.model.Response;

public class NetworkLogActivityICRM {
	
	public void sleepMilliseconds() {
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static void main(String[] args) throws Exception {
		
		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();

		devTools.createSession();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();
		driver.get("https://testicrm.indigotools.com/icrm-r/index.html");
		driver.findElement(By.name("loginEmail1")).sendKeys("bhushan.more@virtuaresearch.com");
		driver.findElement(By.cssSelector("button[aria-label=\"Close\"]")).click();
		driver.findElement(By.id("Password1")).sendKeys("Stage@2023");
		driver.findElement(By.cssSelector("button[type=\"button\"]:nth-child(1)")).click();
		driver.findElement(By.xpath("//span[@class='icon-user navbarpositionsmall']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Go to new link']")).click();
		
		String tickername="Spring";
		
		String currentWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(currentWindowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@placeholder='Search Company Name/Ticker']")).sendKeys(tickername);
		//this.sleepMilliseconds();
		
		driver.findElement(By.xpath("//span[contains(normalize-space(), '" +tickername + "')]")).click();
		Thread.sleep(8000);
		

		
		driver.findElement(By.xpath("//div[@title='Virtua Logo']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Competitive Intelligence')]")).click();
		Thread.sleep(30000);
		
		driver.findElement(By.xpath("//span[@class='icon-decimal_increase']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='icon-decimal_increase']")).click();
		
		driver.findElement(By.xpath("//span[@title='Close Transcript Widget Pannel']")).click();
		
devTools.send(Network.enable(Optional.empty(), Optional.empty(),Optional.empty()));

		
        // Request
		devTools.addListener(Network.requestWillBeSent(), request ->

		{
			Request req = request.getRequest();
			System.out.println("req.getUrl()"+req.getUrl());
		});
        //Responce 
		devTools.addListener(Network.responseReceived(), responce -> {
			Response res = responce.getResponse();
			System.out.println("res.getStatus()"+res.getStatus());
			System.out.println("res.getUrl()" +res.getUrl());
		});

		System.out.println("End of program");

		
		


	}

}
