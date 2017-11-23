package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravelocityFlightSearchPage extends BasePage {

	@FindBy(name="sort")
	WebElement selectorOrder;
	List<WebElement> listSelector;
	
	
		
	public TravelocityFlightSearchPage(WebDriver driverT) {
		super(driverT);
		// TODO Auto-generated constructor stub
	}

	public boolean existsValue(List<WebElement> listEval, String valEval) {
		return false;
	}
	
}
