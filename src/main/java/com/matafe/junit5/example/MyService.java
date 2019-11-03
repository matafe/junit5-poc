package com.matafe.junit5.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Simple Service
 * 
 * @author matafe@gmail.com
 */
public class MyService {

	public String getCompanyName(String name) {
		Objects.requireNonNull(name, "Name can not be null!");
		return name;
	}

	public String getCompanyName() {
		return getCompanyName("XPTO");
	}

	public Map<String, String> getCompanyDetails() {
		Map<String, String> details = new HashMap<>(2);
		details.put("address", "Malahide Road");
		details.put("city", "Dublin");
		return details;
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

	public int multiply(int i, int j) {
		return i * j;
	}
}
