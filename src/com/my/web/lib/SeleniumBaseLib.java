package com.my.web.lib;




import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class SeleniumBaseLib {
	OutLogger log = new OutLogger();	
	private static FileHandler fileHandle;
	private static Logger logger = Logger.getLogger(SeleniumBaseLib.class.getName());
	String spilt = "**********************************************************";
	
	//判断元素是否存在
	public boolean  isElementExist(WebDriver driver, By selector){
		BaseLib.theadTime();
		try{
			driver.findElement(selector);
			BaseLib.getMethodName();
			logger.info(spilt);
			 logger.info(selector.toString() + MessageOutput.mExist +";执行方法:" + BaseLib.getMethodName());
			//log.outLoggerInfo(selector.toString()+MessageOutput.mExist,BaseLib.getMethodName());
			//log.outLoggerInfo(selector.toString()+MessageOutput.mExist);
			
			return true;
		}
		catch(NoSuchElementException e){
			logger.info(spilt);
			logger.severe(selector.toString()+MessageOutput.mNot+MessageOutput.mExist  +";执行方法:" + BaseLib.getMethodName());
			//log.outLoggerSevere(selector.toString()+MessageOutput.mNot+MessageOutput.mExist,BaseLib.getMethodName());
			return false;
		}		
	}
	
	
	public static By parseObject(String p_object) {
		String newObjecyt = null;
		if (p_object.startsWith("//*[@id=")) {
			return By.xpath(p_object);
		} else if (p_object.startsWith("link=") || p_object.startsWith("Link=")) {
			newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
			return By.linkText(newObjecyt);
		} else if (p_object.startsWith("xpath=")) {
			newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
			return By.xpath(newObjecyt);
		} else if (p_object.startsWith("id=")) {
			newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
			return By.id(newObjecyt);
		} else if (p_object.startsWith("css=")) {
			newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
			return By.cssSelector(newObjecyt);
		} else if (p_object.startsWith("class=")) {
			newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
			return By.className(newObjecyt);
		} else if (p_object.startsWith("tagName=")) {
			newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
			return By.tagName(newObjecyt);
		}  else if (p_object.startsWith("name=")) {
			newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
			return By.name(newObjecyt);
		} else
			return null;
	}
	
	//点击
	public boolean click(WebDriver driver , By by) {
		BaseLib.theadTime();
		if(isElementExist(driver,by)){
			driver.findElement(by).click();
			logger.info(spilt);
			logger.info(MessageOutput.mclick + by.toString() + MessageOutput.mPass + ";执行方法:" + BaseLib.getMethodName());
			//log.outLoggerInfo(MessageOutput.mclick + by.toString() + MessageOutput.mPass,BaseLib.getMethodName());
			return true;
		}else{
			logger.info(spilt);
			logger.severe(MessageOutput.mclick + by.toString() + MessageOutput.mNot + MessageOutput.mExist + ";执行方法：" + BaseLib.getMethodName());
			//log.outLoggerSevere(MessageOutput.mclick + by.toString() + MessageOutput.mNot + MessageOutput.mExist, BaseLib.getMethodName());
			return false;
		}		
	}
	
	//输入文本
	public boolean sendkeys(WebDriver driver, By by, String inputString){
		BaseLib.theadTime();
		if(isElementExist(driver,by)){
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(inputString);
			logger.info(spilt);
			logger.info(MessageOutput.mInput + by.toString() + inputString + MessageOutput.mPass + ";执行方法:" + BaseLib.getMethodName());
			//log.outLoggerInfo(MessageOutput.mInput + by.toString() + inputString + MessageOutput.mPass, BaseLib.getMethodName());
			return true;
		}
		else{
			logger.info(spilt);
			logger.severe(MessageOutput.mInput + by.toString() + inputString + MessageOutput.mPass + ";执行方法:" + BaseLib.getMethodName());
			//log.outLoggerInfo(MessageOutput.mInput + by.toString() + inputString + MessageOutput.mPass, BaseLib.getMethodName());
			return false;
		}
	}
	
	//获取当前页面的title
	public String getTitle(WebDriver driver){
		BaseLib.theadTime();
		return driver.getTitle();
	}
	
	//获取当前页面的链接
	public String getCurrentUrl(WebDriver driver){
		BaseLib.theadTime();
		return driver.getCurrentUrl();
	}
	
	//设置浏览器最大化
	public void maxSize(WebDriver driver){
		BaseLib.theadTime();
		driver.manage().window().maximize();
	}
	
	//前进
	public void forward(WebDriver driver){
		BaseLib.theadTime();
		driver.navigate().forward();
	}
	
	//浏览器后退
	public void back(WebDriver driver){
		BaseLib.theadTime();
		driver.navigate().back();
	}
	
	//select
	//sl.sSelect(driver, By.name("select2"), "IE8");
	public boolean select(WebDriver driver, By by, String text){
		BaseLib.theadTime();
		if(isElementExist(driver,by)){
			new Select(driver.findElement(by)).selectByVisibleText(text);
			logger.info(spilt);
			logger.info(by.toString()+"值" + text + "选择成功;执行方法:" + BaseLib.getMethodName());
			//log.outLoggerInfo(by.toString()+"值" + text + "选择成功", BaseLib.getMethodName());
			return true;
		}else{
			logger.info(spilt);
			logger.severe(by.toString()+"值" + text + "元素不存在;执行方法:" + BaseLib.getMethodName());
			//log.outLoggerSevere(by.toString()+"值" + text + "元素不存在", BaseLib.getMethodName());
			return false;
		}		
	}	
	
	//全选
	public boolean selectAll(WebDriver driver, By by){
		BaseLib.theadTime();
		if(isElementExist(driver,by)){
			driver.findElement(by).sendKeys(Keys.CONTROL + "a");
			logger.info(spilt);
			logger.info(by.toString()+"全选"+MessageOutput.mPass + ";执行方法:" +BaseLib.getMethodName());
			//log.outLoggerInfo(by.toString()+"全选"+MessageOutput.mPass, BaseLib.getMethodName());
			return true;
		}else{
			logger.info(spilt);
			logger.severe(by.toString()+"全选"+MessageOutput.mFail + ";执行方法:" + BaseLib.getMethodName());
			//log.outLoggerSevere(by.toString()+"全选"+MessageOutput.mFail, BaseLib.getMethodName());
			return false;
		}
	}
	
	//获取属性值 ，定位一个元素，在通过该元素获取属性值
	public String getAttribute(WebDriver driver, By by, String attriBute){
		BaseLib.theadTime();
		String str = null;
		if(isElementExist(driver,by)){
			str = driver.findElement(by).getAttribute(attriBute);
			logger.info(spilt);
			logger.info(by.toString()+"获取属性值"+ attriBute + MessageOutput.mPass + ";属性值为:" + str + ";执行方法:"+ BaseLib.getMethodName());
			//log.outLoggerInfo(by.toString()+"获取属性值"+ attriBute +MessageOutput.mPass, BaseLib.getMethodName());
			return str;
		}else{
			logger.info(spilt);
			logger.severe(by.toString()+"获取属性值"+ attriBute +MessageOutput.mFail + ";执行方法:" + BaseLib.getMethodName());
			//log.outLoggerSevere(by.toString()+"获取属性值"+ attriBute +MessageOutput.mFail, BaseLib.getMethodName());
			return str;
		}
	}
	
	//获取指定元素的的文本值
	public String getText(WebDriver driver, By by){
		BaseLib.theadTime();
		String str = null;
		if(isElementExist(driver,by)){
			str = driver.findElement(by).getText();
			logger.info(spilt);
			logger.info(by.toString()+"获取文本"+MessageOutput.mPass + ";执行方法:" + BaseLib.getMethodName());
			//log.outLoggerInfo(by.toString()+"获取文本"+MessageOutput.mPass, BaseLib.getMethodName());
			return str;
		}else{
			logger.info(spilt);
			logger.severe(by.toString()+"获取文本"+MessageOutput.mFail + ";执行方法:" + BaseLib.getMethodName());
			//log.outLoggerSevere(by.toString()+"获取文本"+MessageOutput.mFail, BaseLib.getMethodName());
			return str;
		}
	}

	//切换窗口，用循环,用title判断
	public boolean getCurrentWindowByTitle(WebDriver driver, String title){
		BaseLib.theadTime();
		boolean flag = false;
		for(String s : driver.getWindowHandles()){
			driver.switchTo().window(s);
			if(driver.getTitle().equals(title)){
				flag = true;				
				break;
			}
		}
		if(flag){
			logger.info(spilt);
			logger.info("切换窗口成功,当前页面:"+driver.getCurrentUrl());
			//log.outLoggerInfo("切换窗口成功,当前页面:" , driver.getCurrentUrl());
		}else{
			logger.info(spilt);
			logger.severe("切换窗口失败,当前页面:" +driver.getCurrentUrl());
			//log.outLoggerSevere("切换窗口失败,当前页面:" , driver.getCurrentUrl());
		}
		return flag;
	}
	
	//切换窗口,两个窗口，title一致
	public boolean selectWindowTow(WebDriver driver){
		BaseLib.theadTime();
		boolean flag = false;
		try{
			Set<String> handles = driver.getWindowHandles();
			String handle = driver.getWindowHandle();
			handles.remove(handle);
			driver.switchTo().window(handles.iterator().next());
			logger.info(spilt);
			logger.info("两个窗口切换成功;当前窗口:"+ getCurrentUrl(driver));
			//log.outLoggerInfo("两个窗口切换成功", BaseLib.getMethodName(), getCurrentUrl(driver));
			flag = true;
		}catch(NoSuchWindowException e){
			logger.info(spilt);
			logger.severe("两个窗口切换失败;当前窗口:"+ getCurrentUrl(driver));
			//log.outLoggerSevere("两个窗口切换失败", BaseLib.getMethodName(), getCurrentUrl(driver));
			return flag;
		}
		return flag;
	}
	
	
	//切换iframe
	public void toIframe(WebDriver driver, String value){
		BaseLib.theadTime();
		driver.switchTo().frame(value);
	}
	
	//跳出所有的iframe 
	public void toExitAllIframe(WebDriver driver){
		BaseLib.theadTime();
		driver.switchTo().defaultContent();
	}
	
	//accept alert(),点击确认
	public void acceptAlert(WebDriver driver){
		BaseLib.theadTime();
		driver.switchTo().alert().accept();
	}
	
	//点击取消按钮，或者关闭对话框
	public void disAlert(WebDriver driver){
		BaseLib.theadTime();
		driver.switchTo().alert().dismiss();
	}
	
	
	//获取alert文本值
	public String getAlertText(WebDriver driver){
		BaseLib.theadTime();
		String str = null;
		str = driver.switchTo().alert().getText();		
		return str;		
	}
	
	//判断是否为 isEnabled
	public boolean isEnable(WebDriver driver, By by){
		BaseLib.theadTime();
		boolean flag = false;
		if(isElementExist(driver, by)){
			flag = driver.findElement(by).isEnabled();
		}
		return flag;		
	}
	
	//是否被选中
	public boolean isSelect(WebDriver driver, By by){
		BaseLib.theadTime();
		boolean flag = false;
		if(isElementExist(driver, by)){
			flag = driver.findElement(by).isSelected();
		}
		return flag;
	}
	
	//执行js代码
	public boolean runJs(WebDriver driver, By by, String js){
		BaseLib.theadTime();
		if(isElementExist(driver, by)){
			((JavascriptExecutor)driver).executeScript(js, driver.findElement(by));	
			logger.info(spilt);
			logger.info(by.toString()+":执行js" + js + "成功;"+ BaseLib.getMethodName());
			//log.outLoggerInfo(by.toString()+":" + js, BaseLib.getMethodName(),getCurrentUrl(driver));
			return true;
		}
		else{
			logger.info(spilt);
			logger.severe(by.toString()+":执行js" + js + "失败;"+ BaseLib.getMethodName());
			//log.outLoggerSevere(by.toString()+":" + js, BaseLib.getMethodName(),getCurrentUrl(driver));
			return false;
		}
	}
	
	//设置页面加载超时时间
	public static void pageLoadTimeout(WebDriver driver){
		BaseLib.theadTime();
		//log.outLoggerInfo("aa", "aa");
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(BaseLib.getConfigText("pageLoadTimeout")), TimeUnit.SECONDS);
		//log.outLoggerInfo("bb", "bb");
	}
	
	//设置对象超时时间
	public void implicitlyWait(WebDriver driver){
		BaseLib.theadTime();
		driver.manage().timeouts().implicitlyWait(Long.parseLong(BaseLib.getConfigText("implicitlyWaitTime")), TimeUnit.SECONDS);
	}
	
	//重写断言
	public void newverifyEquals(String p_m,Object p_expected,Object p_actual,String functionName, String url){
		BaseLib.theadTime();	
		if (p_expected.equals(p_actual)) {
				//writeToLog();
				//log.outLoggerInfo("执行：" + p_m + "期望结果：" + p_expected + ";实际结果：" + p_actual, functionName, url);
				logger.info(spilt);	
				logger.info(p_m + "-期望结果:" + p_expected + "-实际结果:" + p_actual + ";执行通过" + "-执行方法:" + functionName + "-当前URL:" + url);
				//BaseLib.writeToLog("aa", "aa", "oo", "aa");
				BaseLib.writeToLog(p_m, p_expected, p_actual, "PASS");
			}					
			else{
				//writeToLog();
				//log.outLoggerSevere("执行：" + p_m + "期望结果：" + p_expected + ";实际结果：" + p_actual, functionName, url);
				logger.info(spilt);
				logger.severe(p_m + "-期望结果:" + p_expected + "-实际结果:" + p_actual + ";执行失败;" + "-执行方法:" + functionName + "-当前URL:" + url);
				BaseLib.writeToLog(p_m, p_expected, p_actual, "FAIL");
				
				}
	}
	
	public void newAssertEquals(String p_m,Object p_expected,Object p_actual,String functionName, String url){
		BaseLib.theadTime();	
		if (p_expected.equals(p_actual)) {
				//writeToLog();
				//log.outLoggerInfo(p_m + ":期望结果：" + p_expected + ";实际结果：" + p_actual, functionName, url);
				logger.info(spilt);	
				logger.info(p_m + "-期望结果:" + p_expected + "-实际结果:" + p_actual + ";执行通过" + "-执行方法:" + functionName + "-当前URL:" + url);
			
				//BaseLib.writeToLog("aa", "aa", "oo", "aa");
				BaseLib.writeToLog(p_m, p_expected, p_actual, "PASS");
		}					
			else{
				//writeToLog();
				logger.info(spilt);
				logger.severe(p_m + "-期望结果:" + p_expected + "-实际结果:" + p_actual + ";执行失败;" + "-执行方法:" + functionName + "-当前URL:" + url);
				//logger.severe(MessageOutput.mActualResult+MessageOutput.mExpectedResult+MessageOutput.mNot);
				BaseLib.writeToLog(p_m, p_expected, p_actual, "FAIL");
				
				}
	}
	
	//用例执行异常，没有获取相关的元素值，报错
		public void functionRunError(String testName){
			logger.severe("用例：" + testName + "执行出错，可能是没有获取到相关元素的值！");
		}
		
	
	/*public static  void newSetup(String p_caseName) {
		try{
			BaseLib.theadTime();
			BaseLib.createHtmlLog(p_caseName);			
		}catch (Exception e) {
			e.printStackTrace();
			//logger.severe(MessageOutput.mInput+MessageOutput.mPass);
			System.exit(1);			
		}

	}
	*/
	
	//before override
	public  void newBefore(WebDriver driver){		
		driver.manage().window().maximize();		
		driver.manage().timeouts().pageLoadTimeout(DataInputStore.dPageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(DataInputStore.dImplicitlyWaitTime, TimeUnit.SECONDS);		
	}
	
	public  void newAfter(WebDriver driver){
		

	}
	
	
	//before class 执行
	public static void newClassStart(String fileName){
		try {
			//创建HMMLLOG
			BaseLib.createHtmlLog(fileName);
			fileHandle = new FileHandler(BaseLib.SeleniumBaseLibLog);
			fileHandle.setLevel(Level.INFO);
			fileHandle.setFormatter(new SimpleFormatter());
			logger.addHandler(fileHandle);
			logger.info("*******************" + fileName + "*******************");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//After class 执行
	public static void newClassStop(){
		BaseLib.theadTime();
		BaseLib.closeLog();
		//OutLogger.outClose();
		fileHandle.close();		
	}
	
	//读取配置文件，登录操作
	public static boolean login(WebDriver driver){
		
		driver.get(DataInputStore.dLoginUrl);		
		WebElement userName = driver.findElement(By.xpath(DataInputStore.dUserNameXpath));
		userName.clear();
		userName.sendKeys(DataInputStore.dUserName);
		WebElement passWord = driver.findElement(By.xpath(DataInputStore.dPassWordXpath));
		passWord.clear();
		passWord.sendKeys(DataInputStore.dPassWord);
		driver.findElement(By.xpath(DataInputStore.dLoginXpath)).click();
			if(driver.getCurrentUrl().equals(DataInputStore.dLoginOKUrl)){
				logger.info("*************登录成功*************************");
				//Cookie e =driver.manage().getCookieNamed(DataInputStore.dCookieName);
				//driver.get(DataInputStore.dCookieUrl);
				//driver.manage().addCookie(e);
				//driver.get(DataInputStore.dCookieUrl);
				//((JavascriptExecutor)driver).executeScript("window.open('http://pet.goudaifu.com:8099/Home/UserHome/procure_catelogure')");
				return true;
			}
			else{
				logger.severe("*************登录失败*************************");
				return false;
			}
		
	}
	
	
}
