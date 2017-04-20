package com.suite.web;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.my.web.lib.BaseLib;
import com.my.web.lib.SeleniumBaseLib;

public class Juint2 {
	WebDriver driver = null;
	SeleniumBaseLib  sl =  new SeleniumBaseLib();	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SeleniumBaseLib.newClassStart("Jnuit2");				
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		SeleniumBaseLib.newClassStop();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void test() {
		//fail("Not yet implemented");
		System.out.println("111");
		sl.newverifyEquals("111111111", "11", "22", "cc", "dd");
	}

}
