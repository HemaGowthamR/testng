package org.sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.pojo.FbLoginPojo;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.utility.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DClass extends BaseClass {

@Test(enabled=false)
	private void tC2() {
	launchTheBrowser();
		launchTheUrl("https://www.facebook.com/");
		FbLoginPojo l = new FbLoginPojo();
		WebElement emailbox = l.getEmailbox();
		passingText(emailbox, "Josvik");
		passingText(l.getPasswordbox(), "26.12.2022");
		System.out.println(Thread.currentThread().getId());
		quitTheBrowser();
	}
@Parameters("browsername")
@Test//(retryAnalyzer=Failed.class)
private void tC1(String browsername) {
	if(browsername.equals("chromebrowser")) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}
				else if (browsername.equals("edgebrowser")) {
					
					WebDriverManager.edgedriver().setup();
					WebDriver driver = new EdgeDriver();
					driver.get("https://www.facebook.com/");
				}
				else {
					WebDriverManager.firefoxdriver().setup();
					WebDriver driver = new FirefoxDriver();
					driver.get("https://www.facebook.com/");				
				}			
	
	}

}	
//	launchTheUrl("https://www.facebook.com/");
//	FbLoginPojo l = new FbLoginPojo();
//	WebElement emailbox1 = l.getEmailbox();
//	passingText(emailbox1, "aishu");
//	WebElement passwordbox1 = l.getPasswordbox();
//	passingText(passwordbox1, "01.03.1996");
//	System.out.println(Thread.currentThread().getId());
//	quitTheBrowser();


