package test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import bsh.classpath.BshClassPath.GeneratedClassSource;
import page.TravelocityCarSearchPage;
import page.TravelocityFlightHotelInformationPage;
import page.TravelocityFlightSearchPage;
import page.TravelocityHomePage;
import page.TravelocityHotelInformationPage;
import page.TravelocityReviewBookPage;

public class TravelocityFlightHotelSearchPageTest extends BaseTest {

	@Test
	@Parameters({"browser"})
	public void SearchFlightHotel() {
		TravelocityHomePage tvhpfh = getTravelocityHomePage();
		tvhpfh.getButtonFlightHotel().click();
		tvhpfh.getButtonflHoCa().click();
		tvhpfh.selectSuggeestion(tvhpfh.getTextInFromFlHotel(),"LAS",tvhpfh.getDriver()).click();
		tvhpfh.getSuggestFirst().click();
		tvhpfh.getTextInToFlHotel();
		tvhpfh.selectSuggeestion(tvhpfh.getTextInToFlHotel(),"LAX", tvhpfh.getDriver()).click();
		tvhpfh.getSuggestFirst().click();
		tvhpfh.getInputDateFromFlHo().click();
		tvhpfh.clickNTimes(tvhpfh.getInputDateFromButtonNext(),3);
		tvhpfh.selectDay(tvhpfh.getColumns(), 1);
		tvhpfh.getInputDateToFlHo().click();
		tvhpfh.clickNTimes(tvhpfh.getInputDateFromButtonNext(),0);
		tvhpfh.selectDay(tvhpfh.getColumns(), 13);
		tvhpfh.getButtonSearch().click();
		tvhpfh.waitOnloadMessage(1,"interstitial-message","Hurry! Prices and inventory are limited",null);
		TravelocityFlightHotelInformationPage tvfhi = new TravelocityFlightHotelInformationPage(tvhpfh.getDriver());
		tvfhi.waitOnload(tvfhi.getDriver());
		//Validations
		Assert.assertTrue(tvfhi.getLabelLegalInfo().getText().contains("See how we pick our recommended properties"));
		Assert.assertTrue(tvfhi.getLabelShowingResults().isDisplayed());
		Assert.assertTrue(tvfhi.verifyInformationStrPattern(tvfhi.getLabelShowingResults().getText(),"Showing Results(.+?)"));
		Assert.assertTrue(tvfhi.getLabelStartChoosingHotel().getText().contains("Start by choosing your hotel"));
		Assert.assertNotNull(tvfhi.getDivContainerResults());
		//Continue	
		tvfhi.getButtonSortBy().click();
		tvfhi.waitFixed(5);
		TravelocityFlightHotelInformationPage tvfhio = new TravelocityFlightHotelInformationPage(tvhpfh.getDriver());
		tvfhio.waitOnListResults();
		//Validation 2.4
		tvfhio.isOrderedRight(tvfhio.getDivContainerResults(),TravelocityFlightHotelInformationPage.XPATH_OF_HOTEL_CONTAINER);
		tvfhio.getCheck3Star().click();
		tvfhi.waitFixed(5);
		tvfhio = tvfhio.getNewInstance(tvfhio.getDriver());
		tvfhio.selectOptionFlight(tvfhio.getDivContainerResults(), 1, 20);
		// The second value is the minimum starts accepted
		tvfhio.validationStars(tvfhio.getDivContainerResults(), 3);
		tvfhio.switchTab();
//		tvfhio.waitOnloadMessage(1, "interstitial", "Getting your room options ",null);
		tvfhio.waitFixed(5);
		TravelocityHotelInformationPage tvhp = new TravelocityHotelInformationPage(tvfhio.getDriver());
		//Validations
		Assert.assertTrue(tvhp.getTitleAmenities().isDisplayed());
		Assert.assertTrue(tvhp.getContainerRooms().isDisplayed());
		Assert.assertTrue(tvhp.getTitleAvailability().isDisplayed());
		//2.7 Select 
		tvhp.selectOptionInContainer(tvhp.getContainerRooms(), 1, 3, TravelocityHotelInformationPage.XPATH_TO_HOTEL);
		tvhp.waitFixed(5);
		TravelocityFlightSearchPage tvfsp = new TravelocityFlightSearchPage(tvhp.getDriver());
		tvfsp.selectOptionFlight(tvfsp.getContainerListResultsFlight(), 1, 4);
		tvhp.waitFixed(5);
		tvfsp.selectOptionFlight(tvfsp.getContainerListResultsFlight(), 3, 4);
		tvfsp.waitOnloadMessage(1,"interstitial-dialog","Finding available cars for your trip",null);
		TravelocityCarSearchPage tvcsp = new TravelocityCarSearchPage(tvfsp.getDriver());
		tvcsp.selectOptionInContainer(tvcsp.getDivContainerResults(), 1, 5, TravelocityCarSearchPage.XPATH_TO_CAR);
		TravelocityReviewBookPage tvrb = new TravelocityReviewBookPage(tvcsp.getDriver());
		//Validations
		Assert.assertTrue(tvrb.getDriver().getTitle().contains("Payment"));
		Assert.assertTrue(tvrb.getFieldFirstName().isEnabled());
		Assert.assertNotNull(tvrb.getFieldWhosDriving());
		Assert.assertNotNull(tvrb.getFieldZipCode());
		Assert.assertTrue(tvrb.getFieldWhosDriving().isDisplayed());
		Assert.assertTrue(tvrb.getDivInfoTrip().getText().contains("Las Vegas (LAS) to Los Angeles (LAX)"));
		
	}
	
}
