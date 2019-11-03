package com.matafe.junit5.junit4.jmockit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.matafe.junit5.example.MyService;
import com.matafe.junit5.example.MySupport;

import mockit.Expectations;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

/**
 * Junit4 + JMockit 1.41 Unit Test
 * 
 * @author matafe@gmail.com
 */
@RunWith(JMockit.class)
public class MyServiceJunit4JMockitTest {

	@Tested
	MyService classUnderTest;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Starting My Service Tests with Junit 4 + JMockit...");
	}

	@Before
	public void before() {
		this.classUnderTest = new MyService();
	}

	@After
	public void after() {
		this.classUnderTest = null;
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("Finishing My Service Tests with Junit 4 + JMockit...");
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
		new Expectations(new MySupport()) {
			{
				MySupport.getSomethingFromDatabase();
				result = dbObject;
			}
		};

		assertThat(classUnderTest.getCompanyNameFromSupport4(), equalTo("XPTO-" + dbObject + "4"));
	}
}
