package CDP;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.fetch.Fetch;

public class Networkmocking {

	public static void main(String[] args) throws Exception {
		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();

		devTools.createSession();

		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));

		devTools.addListener(Fetch.requestPaused(), request -> {
			if (request.getRequest().getUrl().contains("=shetty")) {
				String newurl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				System.out.println("NewURL" + newurl);
				
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(newurl),
						Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(), Optional.empty()));
				
				
			}
			else
			{
				//devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl())
					//	, Optional.of(request.getRequest().getMethod())),Optional.empty(), Optional.empty());
				
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()), 
						 Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(), Optional.empty()));
				
				
			}
		});

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");

		Thread.sleep(3000L);

		driver.findElement(By.xpath("//button[normalize-space()='Virtual Library']")).click();

	}

}
