package org.sample;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class FailedAll implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotation, Class arg1, Constructor arg2, Method arg3) {
		IRetryAnalyzer r = annotation.getRetryAnalyzer();
		
		if (r==null) {
		annotation.setRetryAnalyzer(Failed.class);
		}
	
		
		
	}

}
