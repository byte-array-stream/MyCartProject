package com.mycart.service.testcaserunner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.mycart.service.testcases.MyCartServiceAffiliatedTest;
import com.mycart.service.testcases.MyCartServiceEmployeeTest;
import com.mycart.service.testcases.MyCartServiceOrdinaryTest;
import com.mycart.service.testcases.MyCartServiceRegularTest;

@RunWith(Suite.class)
@SuiteClasses({MyCartServiceAffiliatedTest.class, MyCartServiceEmployeeTest.class,
			   MyCartServiceOrdinaryTest.class, MyCartServiceRegularTest.class})
public class MyCartTestSuiteRunner {
	
}
