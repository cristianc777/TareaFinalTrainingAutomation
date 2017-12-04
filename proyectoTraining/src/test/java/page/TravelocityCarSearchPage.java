package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravelocityCarSearchPage extends BasePage{

	@FindBy(id="search-results")
	WebElement divContainerResults;
	
	public static String XPATH_TO_CAR = "//*[contains(@class,'btn btn-secondary btn-action ember-view')]";
	
	
	public TravelocityCarSearchPage(WebDriver driverT) {
		super(driverT);
		PageFactory.initElements(driverT,this);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement getDivContainerResults() {
		return divContainerResults;
	}

	public void setDivContainerResults(WebElement divContainerResults) {
		this.divContainerResults = divContainerResults;
	}

}
