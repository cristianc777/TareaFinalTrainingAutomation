package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravelocityHotelSearchPage extends BasePage {

	@FindBy(id="mer-signup-toggle-btn")
	WebElement divGetDiscount;
	
	@FindBy(id="mer-banner-signup-email")
	WebElement inputMailDiscount;
	
	@FindBy(id="resultsContainer")
	WebElement divContainer;
	
	@FindBy(id="sponsored")
	WebElement articleSponsored;
	
	@FindBy(id="mer-signup-title-link")
	WebElement slideDiscountMail;
	
	public static String XPATH_SPONSORED = "[id*=_sponsored]";
	
	
	public TravelocityHotelSearchPage(WebDriver driverT) {
		super(driverT);
		// TODO Auto-generated constructor stub
	}
	
	public boolean validationTextCss(WebElement element, String textValue, int compareIndex, String cssSelector) {
		List<WebElement> sub_li_comp = element.findElements(By.cssSelector(cssSelector));
		boolean found = false;
		int i = 0;
		for (WebElement wElementTemp: sub_li_comp){
			String aux = wElementTemp.getText().replaceAll("\\r\\n|\\r|\\n", " ");
			if (aux.contains(textValue) && i == compareIndex){
				System.out.println("valor" + aux);
				found = true;
				break;
			}else {
				found = false;			
			}
		}
		i++;
		return found; 
	}
	
	public WebElement getDivGetDiscount() {
		return divGetDiscount;
	}

	public void setDivGetDiscount(WebElement divGetDiscount) {
		this.divGetDiscount = divGetDiscount;
	}

	public WebElement getInputMailDiscount() {
		return inputMailDiscount;
	}

	public void setInputMailDiscount(WebElement inputMailDiscount) {
		this.inputMailDiscount = inputMailDiscount;
	}

	public WebElement getDivContainer() {
		return divContainer;
	}

	public void setDivContainer(WebElement divContainer) {
		this.divContainer = divContainer;
	}

	public WebElement getArticleSponsored() {
		return articleSponsored;
	}

	public void setArticleSponsored(WebElement articleSponsored) {
		this.articleSponsored = articleSponsored;
	}

	public WebElement getButtonSlideDiscountMail() {
		return slideDiscountMail;
	}

	public void setButtonSlideDiscountMail(WebElement buttonSlideDiscountMail) {
		this.slideDiscountMail = buttonSlideDiscountMail;
	}
	
}
