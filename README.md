# junit5-poc

Junit 5 + JMockit POC with legacy tests

Tests with:
 - Plain Junit4 - 4.12
 - Junit4 + JMockit 1.41 - Last version with support @RunWith(JMockit.class)
 - Plain Junit5 - 5.5.2
 - Junit5 + JMockit 1.41 - @ExtendWith
 
 NOTE: New JMockit versions should try to use the JMockit VM agent as per documentation.
 
 
 ## JMockit 1.41 to 1.48 migrations notes:
 
 - Eclipse: -javaagent:${project_loc}/lib/jmockit-1.48.jar
 - Build tool:	https://jmockit.github.io/tutorial/Introduction.html#runningTests
 - Remove @RunWith(JMockit.class) from Test Classes
 - Junit5 tests should use the provided extension: mockit.integration.junit5.JMockitExtension instead
 - Partial Mocking:
 	from: new Expectations(MySupport.class) 
 	to:   new Expectations(new MySupport())
 