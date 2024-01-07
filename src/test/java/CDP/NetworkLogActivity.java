package CDP;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.network.model.Request;
import org.openqa.selenium.devtools.v119.network.model.Response;
import org.openqa.selenium.devtools.v119.network.Network;

public class NetworkLogActivity {

	public static void main(String[] args) throws Exception {

		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();

		devTools.createSession();

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");

		Thread.sleep(3000L);

		driver.findElement(By.xpath("//button[normalize-space()='Virtual Library']")).click();

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		// Request
		devTools.addListener(Network.requestWillBeSent(), request ->

		{
			Request req = request.getRequest();
			System.out.println("req.getUrl()" + req.getUrl());
		});
		// Responce
		devTools.addListener(Network.responseReceived(), responce -> {
			Response res = responce.getResponse();

			System.out.println("res.getStatus()" + res.getStatus());
			System.out.println("res.getUrl()" + res.getUrl());
		});

		System.out.println("End of program");

	}

}
