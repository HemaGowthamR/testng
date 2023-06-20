
package org.sample;

import java.util.Date;

import org.openqa.selenium.WebElement;
import org.pojo.FbLoginPojo;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.utility.BaseClass;

public class AClass extends BaseClass{
	@DataProvider(name = "data")
	private Object[][] testData() {
		return new Object[][] {
			{"gowtham","13.03.1995"},
			{"aishu","01.03.1996"},
			{"josvik","26.12.2022"},
		};

	}
	@BeforeMethod
	private void startDateAndTime() {
		Date d= new Date();
		System.out.println(d);
	}
	
	@AfterMethod
	private void endDateAndTime() {
		Date d= new Date();
		System.out.println(d);
	}
	
	@BeforeClass
	private void preCondition() {
		launchTheBrowser();
		windowMaximize();
		System.out.println("launch the browser");
	}
	@AfterClass
	private void postCondition() {
		quitTheBrowser();
		System.out.println("close the browser");
	}
	
	@Test(priority=-10,enabled=true)
	private void tC5() {
		launchTheUrl("https://www.facebook.com/");
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Facebook"), "Check the title");
		Assert.assertEquals("https://www.facebook.com/", driver.getCurrentUrl(), "checking the url");
		System.out.println("tc5");
	}
		
	@Test(enabled=false, dataProvider="sample data",dataProviderClass=Project.class)
	private void tC6(String e1, String p1 ) {
		launchTheUrl("https://www.facebook.com/");
		FbLoginPojo l = new FbLoginPojo();
		WebElement emailbox = l.getEmailbox();
		passingText(emailbox, e1);
		WebElement passwordbox = l.getPasswordbox();
		passingText(passwordbox, p1);
		//clickTheLogin(l.getLoginbutton());
		System.out.println("tc6");
		
	}
	
	@Test(enabled= true, priority=-15)
	private void tC8() {
		launchTheUrl("https://www.facebook.com/");
		FbLoginPojo l = new FbLoginPojo();
		WebElement emailbox = l.getEmailbox();
		passingText(emailbox, "Josvik");
		SoftAssert s = new SoftAssert();
		s.assertTrue(true);
		passingText(l.getPasswordbox(), "26.12.2022");
		//clickTheLogin(l.getLoginbutton());
		System.out.println("tc8");
		s.assertAll();
	}
	
}
