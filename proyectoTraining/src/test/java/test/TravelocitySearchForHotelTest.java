package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;
import page.TravelocityHomePage;
import page.TravelocityHotelInformationPage;
import page.TravelocityHotelSearchPage;

public class TravelocitySearchForHotelTest extends BaseTest {

	
	
	@Test
	@Parameters({"browser"})
	public void SearchFlight() {
		TravelocityHomePage tvhp = getTravelocityHomePage();
		tvhp.getButtonHotel().click();
		tvhp.getTextInGoingTo().click();
		tvhp.selectSuggeestion(tvhp.getTextInGoingTo(),"Montevideo, Uruguay",tvhp.getDriver()).click();
		tvhp.getSuggestFirst().click();
		tvhp.getButtonSearchHotel().click();
		tvhp.waitOnloadMessage(1,"interstitial-message","Hurry! Prices and inventory are limited",null);
		new SoftAssert().assertTrue(tvhp.getDriver().getTitle().contains("Hotel Search Results"), "Title not found");
		TravelocityHotelSearchPage tvhsp = tvhp.getTravelocityHotelSearchPage(tvhp.getDriver());
		tvhsp.waitOnElement(tvhsp.getDivContainer());
		//Validations 3a and 3b
	    Assert.assertTrue(tvhsp.validationTextCss(tvhsp.getDivContainer(), "Sponsored", 0, "[id*=_sponsored]"));
		tvhsp.getButtonSlideDiscountMail().click();
	    Assert.assertTrue(tvhsp.getInputMailDiscount().isDisplayed());
	}
}
