package CDP;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.devtools.v119.network.Network;
import org.openqa.selenium.devtools.v119.network.model.AuthChallengeResponse.Response;

public class Test {
	
	void ArcMethod1()
	{
		System.out.println("Branch 1");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        WebDriver driver = new ChromeDriver();
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        
        devTools.createSession();

        
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        
        devTools.addListener(Network.responseReceived(), responseReceived -> {
        	org.openqa.selenium.devtools.v119.network.model.Response response=
        	responseReceived.getResponse();
                 //Response response = responseReceived.getResponse();
            System.out.println("URL: " + response.getUrl());
            System.out.println("Status Code: " + response.getStatus());
            // You can extract more information from the 'response' object as needed
        });
        
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        
        
}
	
	

}
