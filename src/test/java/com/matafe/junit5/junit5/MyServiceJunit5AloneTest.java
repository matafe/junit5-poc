package com.matafe.junit5.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInfo;

import com.matafe.junit5.example.MyService;

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

	@DisplayName("Get the Company Name + DB Object")
	@Test
	public void testGetCompanyName(TestInfo testInfo) {
		assertEquals("XPTO", classUnderTest.getCompanyName());
		assertEquals("Get the Company Name + DB Object", testInfo.getDisplayName(),
				() -> "TestInfo is injected correctly");
	}

	@Disabled
	@Tag("slow")
	public void testFetchAllDatabaseData() throws Exception {
		Thread.sleep(1000);
	}

	@Test
	public void testGetCompanyName() {
		Throwable exception = Assertions.assertThrows(NullPointerException.class,
				() -> classUnderTest.getCompanyName(null));
		Assertions.assertEquals("Name can not be null!", exception.getMessage());
	}

	@DisplayName("Get the Company Name with null")
	@Test
	public void testGetCompanyDetails() {
		Map<String, String> companyDetails = classUnderTest.getCompanyDetails();

		// many assetions
		Assertions.assertAll("Company Details", () -> assertEquals("Dublin", companyDetails.get("city")),
				() -> assertEquals("Malahide Road", companyDetails.get("address")));

		// timeout
		String city = Assertions.assertTimeout(Duration.ofSeconds(1), () -> {
			return classUnderTest.getCompanyDetails().get("city");
		});
		assertEquals("Dublin", city);
	}

	@TestFactory
	public Stream<DynamicTest> testMultiplyException() {
		int[][] data = new int[][] { { 0, 10, 0 }, { 2, 4, 8 }, { 10, 10, 100 } };
		return Arrays.stream(data).map(entry -> {
			int m1 = entry[0];
			int m2 = entry[1];
			int expected = entry[2];
			return DynamicTest.dynamicTest(m1 + " * " + m2 + " = " + expected, () -> {
				assertEquals(expected, classUnderTest.multiply(m1, m2));
			});
		});
	}

}
