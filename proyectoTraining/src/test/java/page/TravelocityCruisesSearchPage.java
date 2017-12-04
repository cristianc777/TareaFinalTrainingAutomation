package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class TravelocityCruisesSearchPage extends BasePage{

	@FindBy(id="cruise-destination-hp-cruise")
	WebElement selectorCruisesFrom;
	@FindBy(id="cruise-departure-month-hp-cruise")
	WebElement selectorCruisesWhen;
	@FindBy(css = "button.btn-primary:nth-child(9)")
	WebElement buttonSearchCruise;
	
	private Select selectorFrom = new Select(selectorCruisesFrom);
	private Select selectWhen = new Select(selectorCruisesWhen);
	
	public TravelocityCruisesSearchPage(WebDriver driverT) {
		super(driverT);
		PageFactory.initElements(driverT,this);
		// TODO Auto-generated constructor stub
	}	
	
	public void waitOnSelectors() {
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(selectorCruisesFrom));
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(selectorCruisesWhen));
	}
	
	public WebElement getSelectorCruisesFrom() {
		return selectorCruisesFrom;
	}

	public void setSelectorCruisesFrom(WebElement selectorCruisesFrom) {
		this.selectorCruisesFrom = selectorCruisesFrom;
	}

	public WebElement getSelectorCruisesWhen() {
		return selectorCruisesWhen;
	}

	public void setSelectorCruisesWhen(WebElement selectorCruisesWhen) {
		this.selectorCruisesWhen = selectorCruisesWhen;
	}

	public Select getSelectorFrom() {
		return selectorFrom;
	}

	public void setSelectorFrom(Select selectorFrom) {
		this.selectorFrom = selectorFrom;
	}

	public Select getSelectWhen() {
		return selectWhen;
	}

	public void setSelectWhen(Select selectWhem) {
		this.selectWhen = selectWhem;
	}

	public WebElement getButtonSearchCruise() {
		return buttonSearchCruise;
	}

	public void setButtonSearchCruise(WebElement buttonSearchCruise) {
		this.buttonSearchCruise = buttonSearchCruise;
	}	
}
