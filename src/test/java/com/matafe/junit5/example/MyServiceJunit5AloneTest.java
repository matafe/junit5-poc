package com.matafe.junit5.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * Plain Junit5 Unit Test
 * 
 * @author matafe@gmail.com
 */
@Tag("junit5")
public class MyServiceJunit5AloneTest {

	MyService classUnderTest;

	@BeforeAll
	public static void beforeClass() {
		System.out.println("Starting My Service Tests with Junit 5...");
	}

	@BeforeEach
	public void before() {
		this.classUnderTest = new MyService();
	}

	@AfterEach
	public void after() {
		this.classUnderTest = null;
	}

	@AfterAll
	public static void afterClass() {
		System.out.println("Finishing My Service Tests with Junit 5...");
	}

	// Test methods below

	@DisplayName("Get the CIA Name + DB Object")
	@Test
	public void testGetCompanyName(TestInfo testInfo) {
		assertEquals("XPTO", classUnderTest.getCompanyName());
		assertEquals("Get the CIA Name + DB Object", testInfo.getDisplayName(), () -> "TestInfo is injected correctly");
	}

	@Disabled
	@Tag("slow")
	public void testFetchAllDatabaseData() throws Exception {
		Thread.sleep(1000);
	}
}
