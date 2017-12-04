package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driver.BaseDriver;
import driver.EnumDrivers;
import page.TravelocityHomePage;

public class BaseTest {
	
	private BaseDriver bd;
	private TravelocityHomePage travelocityHomePage;
	
	@BeforeSuite(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeSuite(String browser) {
		
		bd = new BaseDriver(EnumDrivers.valueOf(browser)); 
		travelocityHomePage = new TravelocityHomePage(bd.getDriver());
	}
	
	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
//	bd.getDriver().close();
	}

	public BaseDriver getBd() {
		return bd;
	}

	public void setBd(BaseDriver bd) {
		this.bd = bd;
	}

	public TravelocityHomePage getTravelocityHomePage() {
		return travelocityHomePage;
	}

	public void setTravelocityHomePage(TravelocityHomePage travelocityHomePage) {
		this.travelocityHomePage = travelocityHomePage;
	}
	
	
	
}
