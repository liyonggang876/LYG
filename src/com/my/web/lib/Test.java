package com.my.web.lib;

import java.io.File;
import java.io.IOException;







import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Test {
	public static void main(String[] args) throws SecurityException, IOException, InterruptedException{
		SeleniumBaseLib  sl = new SeleniumBaseLib();
		WebDriver driver = new FirefoxDriver();
		//driver.get(BaseLib.getConfigText("BaseUrl"));		
		//File file = new File("src/Select.html");
		//File file = new File("src/attribute.html");
		//File file = new File("src/frame.html");
		//File file = new File("src/js.html");
		
		//String filePath = "file:///" + file.getAbsolutePath();
		//System.out.println(filePath);
		//driver.get(filePath);
		//Thread.sleep(3000);
		//new Select(driver.findElement(By.name("select2"))).selectByVisibleText("IE8");
	
		//sl.sSelect(driver, By.name("select2"), "IE8");		
		//new Select(driver.findElement(By.name("select2"))).selectByVisibleText("IE7");
		
		//OutLogger log = new OutLogger();
		//By by = By.linkText("Visit Baidu!");
		//String title = "百度一下，你就知道";
		//String title = sl.sGetText(driver, by);
		//log.outLoggerInfo(by.toString(), sl.sGetCurrentUrl(driver) +":执行方法"+ log.getMethodName());
		//System.out.println(title);
		
		/*if(sl.sClick(driver, by)){
			if(sl.sGetCurrentWindowByTitle(driver, by, title)){
				log.outLoggerInfo(by.toString()+ ":" + title, log.getMethodName(), sl.sGetCurrentUrl(driver));
			}else{
				log.outLoggerSevere(by.toString()+ ":" + title,log.getMethodName(), sl.sGetCurrentUrl(driver));
			}
		}else{
			log.outLoggerSevere("没找到元素" + by.toString(), log.getMethodName(), sl.sGetCurrentUrl(driver));
		}*/
		
		/*driver.switchTo().frame("f_1");
		By by = By.id("btn1");		
		if(sl.sClick(driver, by)){
			String str = sl.sGetAlertText(driver);
			if(str != null){
				System.out.println(str);
				sl.sAcceptAlert(driver);
				sl.sToExitAllIframe(driver);
			}
			else{
				System.out.print("aaa");
			}
		}
		else{
			log.outLoggerSevere("aaaa", log.getMethodName(), sl.sGetCurrentUrl(driver));
		}
		BaseLib.theadTime();
		driver.switchTo().frame("f_2");
		sl.sClick(driver, By.id("btn2"));
	*/
		
	//By by = By.name("user");
	//System.out.println(sl.sIsEnable(driver, by));
	
	///sl.click(driver, By.name("radio"));
	//System.out.println(driver.findElement(By.name("radio")).isSelected());
	/*By by = By.id("myButton");	
	//sl.sRunJs(driver, by, "window.open()");
	sl.runJs(driver, by,"arguments[0].click()");
	BaseLib.theadTime();
	driver.quit();*/
		
		/*driver.get("http://www.baidu.com");
		driver.findElement(By.linkText("登录")).click();		
		driver.findElement(By.linkText("立即注册")).click();
		//sl.sSelectWindowTow(driver);
		sl.sGetCurrentWindowByTitle(driver, "注册百度帐号");
		driver.findElement(By.name("userName")).sendKeys("username");		
		driver.findElement(By.name("password")).sendKeys("password");
	*/
		/*try {
			BaseLib.createHtmlLog("aaa");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//SeleniumBaseLib.newSetup("tttt");
		sl.login(driver);
		//driver.get(DataInputStore.dLoginUrl);	
		
		
	}
}
