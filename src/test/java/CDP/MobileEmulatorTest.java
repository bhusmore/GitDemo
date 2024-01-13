package CDP;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.emulation.Emulation;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class MobileEmulatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver= new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		//Send cmd to CDP Methods & CDP methods will invoke & get access to Chrome 
		
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		
		driver.get("https://rahulshettyacademy.com/");
		System.out.println("Added my user X line 1");
		System.out.println("Added my user X line 2");

	}

}
