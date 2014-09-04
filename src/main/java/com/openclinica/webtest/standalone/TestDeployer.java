package com.openclinica.webtest.standalone;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import com.openclinica.webtest.tests.SessionManagementTest;

/*
 * Class to use as entry point to deploy tests.
 */
public class TestDeployer {

	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG allTests = new TestNG();
		allTests.setTestClasses(new Class[] {SessionManagementTest.class});
		allTests.addListener(tla);
		allTests.run();
	}

}
