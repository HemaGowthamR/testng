
package org.sample;

import org.testng.annotations.Test;

public class BClass {
	
	@Test(groups = "smoke")
	private void tC10() {
		System.out.println("tc10");
	}
	@Test(groups = "smoke")
	private void tC11() {
		System.out.println("tc11");
	}
	@Test(groups = "sanity")
	private void tC13() {
		System.out.println("tc13");
	}
	
	@Test(groups = "regression")
	private void tC12() {
		System.out.println("tc12");
	}
	@Test(groups = "sanity")
	private void tC15() {
		System.out.println("tc15");
	}
	@Test(groups = "regression")
	private void tC16() {
		System.out.println("tc16");
	}
	
}
