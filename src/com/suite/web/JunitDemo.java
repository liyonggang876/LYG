package com.suite.web;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.my.web.lib.BaseLib;
import com.my.web.lib.DataInputStore;
import com.my.web.lib.SeleniumBaseLib;


//测试用例排序
//@FixMethodOrder(value=MethodSorters.NAME_ASCENDING)   //按照字母顺序排序
//@FixMethodOrder(value=MethodSorters.JVM)   // jvm排序

//@RunWith(SortedRunner.class)
//@RunWith(OrderedRunner.class)
public class JunitDemo {
	WebDriver driver = new FirefoxDriver();
	SeleniumBaseLib  sl =  new SeleniumBaseLib();	
	
	@BeforeClass
	public static void setUpBeforeClass() {		
		SeleniumBaseLib.newClassStart("JnuitDemo");			
	}

	@AfterClass
	public static void tearDownAfterClass() {
		SeleniumBaseLib.newClassStop();
	}

	@Before
	public void setUp() throws Exception {
		
		driver.get(DataInputStore.dURL);
		sl.newBefore(driver);
		sl.login(driver);//登录操作
		
		/*driver = new FirefoxDriver();
		driver.get(BaseLib.getConfigText("BaseUrl"));
		driver.manage().window().maximize();		
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(BaseLib.getConfigText("pageLoadTimeout")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(BaseLib.getConfigText("implicitlyWaitTime")), TimeUnit.SECONDS);		
*/
	}

	@After
	public void tearDown()  {
		sl.newAfter(driver);		
		driver.quit();
	}
	
	
	@Test	
	public void testLogin1() {		
		//wl.login(driver,sl);		
		//Assert.assertEquals(sl.getTitle(driver), "联宠采购商城-一站式动物医院采购平台");
		sl.newAssertEquals("测试2", "aa", "aa","testLogin()2", "tttt");
	}
	
	@Test	
	public void testLogin2() {		
		//wl.login(driver,sl);
		//driver.get(BaseLib.getConfigText("BaseUrl"));
		//Assert.assertEquals(sl.getTitle(driver), "联宠采购商城-一站式动物医院采购平台");
		sl.newAssertEquals("测试2", "aa", "bb","testLogin()2", driver.getCurrentUrl());
	}
	
	@Test	
	public void testLogin3() {		
		//wl.login(driver,sl);
		//driver.get(BaseLib.getConfigText("BaseUrl"));
		//Assert.assertEquals(sl.getTitle(driver), "联宠采购商城-一站式动物医院采购平台");
		sl.newAssertEquals("测试2", "cc", "cc","testLogin()3", driver.getCurrentUrl());
	}
}
