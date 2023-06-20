package org.sample;

import org.testng.annotations.Test;

public class CClass {
	@Test(groups = {"smoke,regression"})//---and operator
	private void tC17() {
		System.out.println("tc17");
	}
	@Test(groups = {"smoke","regression"})//---or operator
	private void tC19() {
		System.out.println("tc19");
	}
	@Test(groups = "sanity")
	private void tC18() {
		System.out.println("tc18");
	}
	
	@Test(groups = "regression")
	private void tC20() {
		System.out.println("tc20");
	}
	@Test(groups = "sanity")
	private void tC22() {
		System.out.println("tc22");
	}
	@Test(groups = "regression")
	private void tC21() {
		System.out.println("tc21");
	}

}
