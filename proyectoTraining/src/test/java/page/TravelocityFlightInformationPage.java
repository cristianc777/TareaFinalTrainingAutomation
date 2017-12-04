package page;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TravelocityFlightInformationPage extends BasePage{

	@FindBy(className="totalContainer")
	WebElement totalPriceContainerLabel;
	
	@FindBy(xpath="//*[contains(@class,'flex-card flex-tile details OD0')]")
	WebElement panelFromInfo;
	
	@FindBy(xpath="//*[contains(@class,'flex-card flex-tile details OD1')]")
	WebElement panelToInfo;
	
	@FindBy(css=".tripTotals")
	WebElement labelPrice;
	
	@FindBy(id="bookButton")
	WebElement buttonBook;
	
	@FindBy(css=".priceGuarantee")
	WebElement labelGuarantee;
	
	
	public TravelocityFlightInformationPage(WebDriver driverT) {
		super(driverT);
		PageFactory.initElements(driverT,this);
		getWebDriverWait().until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.cssSelector(".packagePriceList"), By.cssSelector(".tripTotals")));
		// TODO Auto-generated constructor stub
	}
	
	public boolean verifyInformationStrPattern(String stringToEval, String pattern) {
		return stringToEval.matches(pattern);
	}
	
	public WebElement getTotalPriceContainerLabel() {
		return totalPriceContainerLabel;
	}

	public void setTotalPriceContainerLabel(WebElement totalPriceContainerLabel) {
		this.totalPriceContainerLabel = totalPriceContainerLabel;
	}

	public WebElement getPanelFromInfo() {
		return panelFromInfo;
	}

	public void setPanelFromInfo(WebElement panelFromInfo) {
		this.panelFromInfo = panelFromInfo;
	}

	public WebElement getPanelToInfo() {
		return panelToInfo;
	}

	public void setPanelToInfo(WebElement panelToInfo) {
		this.panelToInfo = panelToInfo;
	}

	public WebElement getLabelPrice() {
		return labelPrice;
	}

	public void setLabelPrice(WebElement labelPrice) {
		this.labelPrice = labelPrice;
	}

	public WebElement getButtonBook() {
		return buttonBook;
	}

	public void setButtonBook(WebElement buttonBook) {
		this.buttonBook = buttonBook;
	}

	public WebElement getLabelGuarantee() {
		return labelGuarantee;
	}

	public void setLabelGuarantee(WebElement labelGuarantee) {
		this.labelGuarantee = labelGuarantee;
	}
	
	
}
