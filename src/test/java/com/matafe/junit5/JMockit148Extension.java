/*
 * Copyright (c) 2006 JMockit developers
 * This file is subject to the terms of the MIT license (see LICENSE.txt).
 */
package com.matafe.junit5;

//import static mockit.internal.util.StackTrace.filterStackTrace;
//
//import java.lang.reflect.Method;
//
//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.extension.AfterAllCallback;
//import org.junit.jupiter.api.extension.AfterEachCallback;
//import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
//import org.junit.jupiter.api.extension.BeforeAllCallback;
//import org.junit.jupiter.api.extension.BeforeEachCallback;
//import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.api.extension.ParameterContext;
//import org.junit.jupiter.api.extension.ParameterResolver;
//import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
//import org.junit.jupiter.api.extension.TestInstancePostProcessor;
//
//import mockit.Capturing;
//import mockit.Injectable;
//import mockit.Mocked;
//import mockit.Tested;
//import mockit.integration.TestRunnerDecorator;
//import mockit.internal.expectations.RecordAndReplayExecution;
//import mockit.internal.state.SavePoint;
//import mockit.internal.state.TestRun;

public final class JMockit148Extension 
//extends TestRunnerDecorator implements BeforeAllCallback, AfterAllCallback,
//		TestInstancePostProcessor, BeforeEachCallback, AfterEachCallback, BeforeTestExecutionCallback,
//		AfterTestExecutionCallback, ParameterResolver, TestExecutionExceptionHandler 
{
//	private SavePoint savePointForTestClass;
//	private SavePoint savePointForTest;
//	private SavePoint savePointForTestMethod;
//	private Throwable thrownByTest;
//	private Object[] parameterValues;
//
//	@Override
//	public void beforeAll(ExtensionContext context) {
//		if (isRegularTestClass(context)) {
//			Class<?> testClass = context.getTestClass().orElse(null);
//			savePointForTestClass = new SavePoint();
//			TestRun.setCurrentTestClass(testClass);
//		}
//	}
//
//	private static boolean isRegularTestClass(ExtensionContext context) {
//		Class<?> testClass = context.getTestClass().orElse(null);
//		return testClass != null && !testClass.isAnnotationPresent(Nested.class);
//	}
//
//	@Override
//	public void postProcessTestInstance(Object testInstance, ExtensionContext context) {
//		if (isRegularTestClass(context)) {
//			TestRun.enterNoMockingZone();
//
//			try {
//				handleMockFieldsForWholeTestClass(testInstance);
//			} finally {
//				TestRun.exitNoMockingZone();
//			}
//
//			TestRun.setRunningIndividualTest(testInstance);
//		}
//	}
//
//	@Override
//	public void beforeEach(ExtensionContext context) {
//		Object testInstance = context.getTestInstance().orElse(null);
//
//		if (testInstance == null) {
//			return;
//		}
//
//		TestRun.prepareForNextTest();
//		TestRun.enterNoMockingZone();
//
//		try {
//			savePointForTest = new SavePoint();
//			createInstancesForTestedFieldsBeforeSetup(testInstance);
//		} finally {
//			TestRun.exitNoMockingZone();
//		}
//	}
//
//	@Override
//	public void beforeTestExecution(ExtensionContext context) {
//		Method testMethod = context.getTestMethod().orElse(null);
//		Object testInstance = context.getTestInstance().orElse(null);
//
//		if (testMethod == null || testInstance == null) {
//			return;
//		}
//
//		TestRun.enterNoMockingZone();
//
//		try {
//			savePointForTestMethod = new SavePoint();
//			createInstancesForTestedFieldsFromBaseClasses(testInstance);
//			parameterValues = createInstancesForAnnotatedParameters(testInstance, testMethod, null);
//			createInstancesForTestedFields(testInstance);
//		} finally {
//			TestRun.exitNoMockingZone();
//		}
//
//		TestRun.setRunningIndividualTest(testInstance);
//	}
//
//	@Override
//	public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
//		return parameterContext.isAnnotated(Tested.class) || parameterContext.isAnnotated(Mocked.class)
//				|| parameterContext.isAnnotated(Injectable.class) || parameterContext.isAnnotated(Capturing.class);
//	}
//
//	@Override
//	public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
//		int parameterIndex = parameterContext.getIndex();
//		return parameterValues[parameterIndex];
//	}
//
//	@Override
//	public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
//		thrownByTest = throwable;
//		throw throwable;
//	}
//
//	@Override
//	public void afterTestExecution(ExtensionContext context) {
//		if (savePointForTestMethod != null) {
//			TestRun.enterNoMockingZone();
//
//			try {
//				savePointForTestMethod.rollback();
//				savePointForTestMethod = null;
//
//				if (thrownByTest != null) {
//					filterStackTrace(thrownByTest);
//				}
//
//				Error expectationsFailure = RecordAndReplayExecution.endCurrentReplayIfAny();
//				clearTestedObjectsIfAny();
//
//				if (expectationsFailure != null) {
//					filterStackTrace(expectationsFailure);
//					throw expectationsFailure;
//				}
//			} finally {
//				TestRun.finishCurrentTestExecution();
//				TestRun.exitNoMockingZone();
//			}
//		}
//	}
//
//	@Override
//	public void afterEach(ExtensionContext context) {
//		if (savePointForTest != null) {
//			savePointForTest.rollback();
//			savePointForTest = null;
//		}
//	}
//
//	@Override
//	public void afterAll(ExtensionContext context) {
//		if (savePointForTestClass != null && isRegularTestClass(context)) {
//			savePointForTestClass.rollback();
//			savePointForTestClass = null;
//
//			clearFieldTypeRedefinitions();
//			TestRun.setCurrentTestClass(null);
//		}
//	}
}