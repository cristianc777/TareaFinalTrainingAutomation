package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.BasePage;
import page.TravelocityHomePage;

public class TravelocityErrorMessage extends BaseTest {

	@Test
	@Parameters({"browser"})
	public void validationError() {
		TravelocityHomePage tvhpfh = getTravelocityHomePage();
		tvhpfh.getButtonFlightHotel().click();
		tvhpfh.selectSuggeestion(tvhpfh.getTextInFromFlHotel(),"LAS",tvhpfh.getDriver()).click();
		tvhpfh.getSuggestFirst().click();
		tvhpfh.getTextInToFlHotel();
		tvhpfh.selectSuggeestion(tvhpfh.getTextInToFlHotel(),"LAX", tvhpfh.getDriver()).click();
		tvhpfh.getSuggestFirst().click();
		tvhpfh.getInputDateFromFlHo().click();
		tvhpfh.clickNTimes(tvhpfh.getInputDateFromButtonNext(),1);
		tvhpfh.selectDay(tvhpfh.getColumns(), 1);
		tvhpfh.getInputDateToFlHo().click();
		tvhpfh.clickNTimes(tvhpfh.getInputDateFromButtonNext(),0);
		tvhpfh.selectDay(tvhpfh.getColumns(), 10);
		tvhpfh.getCheckPartialHotel().click();
	
		tvhpfh.getInputDateCheckIn().click();
		tvhpfh.clickNTimes(tvhpfh.getInputDateFromButtonNext(),1);
		tvhpfh.selectDay(tvhpfh.getColumns(), 20);
		tvhpfh.getInputDateCheckOut().click();
		tvhpfh.clickNTimes(tvhpfh.getInputDateFromButtonNext(),1);
		tvhpfh.selectDay(tvhpfh.getColumns(), 25);
		tvhpfh.getButtonSearch().click();
//		tvhpfh.waitOnElement(tvhpfh.getContainerErrorMessage());
		System.out.println("mensaje: " + tvhpfh.verifyInformationStr(tvhpfh.getContainerErrorMessage().getText(), "Your partial check-in and check-out dates must fall within your arrival and departure dates. Please review your dates."));
		
	}
}
