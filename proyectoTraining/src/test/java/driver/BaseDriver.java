package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseDriver {

	private WebDriver driver;
	
	public BaseDriver(EnumDrivers driverBrowser) {

		switch(driverBrowser) {
		case FIREFOX:
			System.setProperty( "webdriver.gecko.driver","C:\\Gecko\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case GCHROME:
			System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		case IEXPLORER:
			
			System.setProperty("webdriver.ie.driver", "C:\\Iexplore\\IEDriverServer.exe");
			driver = new ChromeDriver();
		default: 
			System.out.println("");
			break; 
		}

	}

	public WebDriver getDriver() {
		return driver;
	}
	
}
