package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravelocityReviewBookPage extends BasePage{

	@FindBy(xpath="//*[contains(@class,'segment segment-title no-target trip-preferences module-header')]")
	WebElement labelWhosFliying;
	
	@FindBy(id="payments")
	WebElement sectionPayments;
	
	@FindBy(id="firstname[0]")
	WebElement fieldFirstName;
	
	@FindBy(className="cko-field single-name-field ")
	WebElement fieldWhosDriving;
	
	@FindBy(name="email")
	WebElement fieldName; 
	
	@FindBy(className="text billing-zip-code cko-field")
	WebElement fieldZipCode;
	
	@FindBy(id="new_cc_security_code")
	WebElement fieldCSV;
	
	@FindBy(css="div.product-summary:nth-child(2)")
	WebElement divInfoTrip;
	
	public TravelocityReviewBookPage(WebDriver driverT) {
		super(driverT);
		// TODO Auto-generated constructor stub
	}

	public WebElement getLabelWhosFliying() {
		return labelWhosFliying;
	}

	public void setLabelWhosFliying(WebElement labelWhosFliying) {
		this.labelWhosFliying = labelWhosFliying;
	}

	public WebElement getSectionPayments() {
		return sectionPayments;
	}

	public void setSectionPayments(WebElement sectionPayments) {
		this.sectionPayments = sectionPayments;
	}

	public WebElement getFieldFirstName() {
		return fieldFirstName;
	}

	public void setFieldFirstName(WebElement fieldFirstName) {
		this.fieldFirstName = fieldFirstName;
	}

	public WebElement getFieldWhosDriving() {
		return fieldWhosDriving;
	}

	public void setFieldWhosDriving(WebElement fieldWhosDriving) {
		this.fieldWhosDriving = fieldWhosDriving;
	}
	
	public WebElement getFieldCSV() {
		return fieldCSV;
	}

	public void setFieldCSV(WebElement fieldCSV) {
		this.fieldCSV = fieldCSV;
	}

	public WebElement getFieldName() {
		return fieldName;
	}

	public void setFieldName(WebElement fieldName) {
		this.fieldName = fieldName;
	}

	public WebElement getFieldZipCode() {
		return fieldZipCode;
	}

	public void setFieldZipCode(WebElement fieldZipCode) {
		this.fieldZipCode = fieldZipCode;
	}

	public WebElement getDivInfoTrip() {
		return divInfoTrip;
	}

	public void setDivInfoTrip(WebElement divInfoTrip) {
		this.divInfoTrip = divInfoTrip;
	}
	
}
