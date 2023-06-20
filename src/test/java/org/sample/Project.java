package org.sample;

import java.util.Date;

import org.openqa.selenium.WebElement;
import org.pojo.FbLoginPojo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.utility.BaseClass;

public class Project extends BaseClass {

	@DataProvider(name = "sample data")
	private Object[][] testData() {
		return new Object[][] {
			{"gowtham","13.03.1995"},
			{"aishu","01.03.1996"},
			{"josvik","26.12.2022"},
	};

	}
	
	@BeforeClass
	private void preCondition() {
		launchTheBrowser();
		windowMaximize();
		//System.out.println("launch the browser");
	}
	
	@BeforeMethod
	private void startDateAndTime() {
		Date d = new Date();
		System.out.println(d);
	}
	
	@Test( dataProvider="sample data")
	private void tC1(String e, String p) {
		launchTheUrl("https://www.facebook.com/");
		FbLoginPojo l = new FbLoginPojo();
		WebElement emailbox = l.getEmailbox();
		passingText(emailbox, e);
		passingText(l.getPasswordbox(), p);
		clickTheLogin(l.getLoginbutton());
		System.out.println("tc1");
	}
	
	@AfterMethod
	private void endDateAndTime() {
		Date d = new Date();
		System.out.println(d);
	}
	@Test(invocationCount=1)
	private void tC3() {
		System.out.println("tc3");
	}
	@Parameters({"emailbox","passwordbox"})
	@Test(retryAnalyzer=Failed.class, enabled = false) //@Optional("sql")
	private void tC2(String emailtxt, String passwordtxt) {
		launchTheUrl("https://www.facebook.com/");
		FbLoginPojo l = new FbLoginPojo();
		WebElement emailbox = l.getEmailbox();
		passingText(emailbox,emailtxt );
		//passingText(emailbox, "Josvik");
		passingText(l.getPasswordbox(), passwordtxt);
		clickTheLogin(l.getLoginbutton());
		//passingText(l.getPasswordbox(), "26.12.2022");
		System.out.println("tc2");
	}
	@AfterClass
	private void postCondition() {
		quitTheBrowser();
		//System.out.println("close the browser");
	}
}
