package com.matafe.junit5.example;

import static org.hamcrest.CoreMatchers.equalTo;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.matafe.junit5.JMockitJUnit5Extension;

import mockit.Expectations;
import mockit.Tested;

/**
 * Junit5 + JMockit 1.41 Unit Test
 * 
 * @author matafe@gmail.com
 */
@ExtendWith(JMockitJUnit5Extension.class)
public class MyServiceJunit5JMockitTest {

	@Tested
	MyService classUnderTest;

	@BeforeAll
	public static void beforeClass() {
		System.out.println("Starting My Service Tests with Junit 5 + JMockit...");
	}

	@BeforeEach
	public void before() {
		System.out.println("Before each test");
	}

	@AfterEach
	public void after() {
		this.classUnderTest = null;
		System.out.println("After each test");
	}

	@AfterAll
	public static void afterClass() {
		System.out.println("Finishing My Service Tests with Junit 5 + JMockit...");
	}

	// Test methods below

	@Test
	public void testGetCompanyName() {
		Assert.assertEquals("XPTO", classUnderTest.getCompanyName());
	}

	@Test
	public void testGetCompanyNameFromSupport() {

		final String dbObject = "PE:9999:99991";

		// partial mock -> MySupport
		new Expectations(MySupport.class) {
			{
				MySupport.getSomethingFromDatabase();
				result = dbObject;
			}
		};

		// Assertions.
		// org.junit.Assert.assertThat removed
		MatcherAssert.assertThat(classUnderTest.getCompanyNameFromSupport5(), equalTo("XPTO-" + dbObject + "5"));
	}
}
