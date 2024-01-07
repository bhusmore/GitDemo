package CDP;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.emulation.Emulation;

public class SetGeoLocation {

	public static void main(String[] args) {
		
		

		/*
		 * ChromeDriver driver= new ChromeDriver(); DevTools devTools =
		 * driver.getDevTools(); devTools.createSession();
		 * 
		 * Map<String,Object> cooridatenate= new HashMap<String,Object>();
		 * cooridatenate.put("latitude", 40); cooridatenate.put("longitude", 3);
		 * cooridatenate.put("accuracy", 1);
		 * 
		 * driver.executeCdpCommand("Emulation.setGeolocationOverride", cooridatenate);
		 * 
		 * driver.get("https://www.google.co.in/");
		 * driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		 */
		
		ChromeDriver driver=new ChromeDriver();



		DevTools devTools = driver.getDevTools();

		        devTools.createSession();

		//get coordinates using Google Earth



		Map<String, Object> param = new HashMap<String, Object>();

		param.put("latitude", 40);

		param.put("longitude", 3);

		param.put("accuracy", 1);



		driver.get("https://www.google.com/");

		driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);

		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();

		driver.findElement(By.cssSelector(".our-story-card-title")).getText();

		System.out.println(driver.findElement(By.xpath("//div[@class='our-story-card-text']/h1")).getText());		
		
		

	}

}
