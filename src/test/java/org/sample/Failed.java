package org.sample;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Failed implements IRetryAnalyzer {

	int min=0;
	int max=3;
	public boolean retry(ITestResult arg0) {
		
		if(min < max) {
			min++;
			return true;//by giving return true it will rerun the failed test cases
		}
		return false;
	}

}
