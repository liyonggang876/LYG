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


//������������
//@FixMethodOrder(value=MethodSorters.NAME_ASCENDING)   //������ĸ˳������
//@FixMethodOrder(value=MethodSorters.JVM)   // jvm����

//@RunWith(SortedRunner.class)
//@RunWith(OrderedRunner.class)
public class CopyOfJunitDemo {
	WebDriver driver = null;
	SeleniumBaseLib  sl =  new SeleniumBaseLib();	
	
	@BeforeClass
	public static void setUpBeforeClass() {		
		SeleniumBaseLib.newClassStart("CopyOfJunitDemo");		
	}

	@AfterClass
	public static void tearDownAfterClass() {
		SeleniumBaseLib.newClassStop();
	}

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get(DataInputStore.dURL);
		sl.newBefore(driver);
		
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
		//BaseLib.closeLog();
		
		driver.quit();
	}
	
	
	@Test	
	public void testLogin1() {		
		//wl.login(driver,sl);		
		//Assert.assertEquals(sl.getTitle(driver), "����ɹ��̳�-һվʽ����ҽԺ�ɹ�ƽ̨");
		sl.newverifyEquals("111", "11", "11","1", "1");
	}
	
	@Test	
	public void testLogin2() {		
		//wl.login(driver,sl);
		//driver.get(BaseLib.getConfigText("BaseUrl"));
		//Assert.assertEquals(sl.getTitle(driver), "����ɹ��̳�-һվʽ����ҽԺ�ɹ�ƽ̨");
		sl.newverifyEquals("2", "2", "2","2", "2");
	}
	
	@Test	
	public void testLogin3() {		
		//wl.login(driver,sl);
		//driver.get(BaseLib.getConfigText("BaseUrl"));
		//Assert.assertEquals(sl.getTitle(driver), "����ɹ��̳�-һվʽ����ҽԺ�ɹ�ƽ̨");
		sl.newverifyEquals("3", "3", "3","3", "3");
	}
}
