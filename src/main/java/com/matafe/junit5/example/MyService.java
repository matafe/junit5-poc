package com.matafe.junit5.example;

/**
 * Simple Service
 * 
 * @author matafe@gmail.com
 */
public class MyService {

	public String getCompanyName() {
		return "XPTO";
	}

	public String getCompanyNameFromSupport4() {
		return getCompanyNameFromSupport(4);
	}

	public String getCompanyNameFromSupport5() {
		return getCompanyNameFromSupport(5);
	}

	private String getCompanyNameFromSupport(int i) {
		return getCompanyName() + "-" + MySupport.getSomethingFromDatabase() + i;
	}
}
