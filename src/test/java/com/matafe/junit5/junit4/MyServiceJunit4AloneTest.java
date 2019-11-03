package com.matafe.junit5.junit4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.matafe.junit5.example.MyService;

/**
 * Plain Junit4 - Unit Test.
 * 
 * @author matafe@gmail.com
 */
public class MyServiceJunit4AloneTest {

	MyService classUnderTest;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Starting My Service Tests with Junit 4...");
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
		System.out.println("Finishing My Service Tests with Junit 4...");
	}

	// Test methods below

	@Test
	public void testGetCompanyName() {
		Assert.assertEquals("XPTO", classUnderTest.getCompanyName());
	}
}
