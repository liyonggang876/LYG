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
	
	//�ж�Ԫ���Ƿ����
	public boolean  isElementExist(WebDriver driver, By selector){
		BaseLib.theadTime();
		try{
			driver.findElement(selector);
			BaseLib.getMethodName();
			logger.info(spilt);
			 logger.info(selector.toString() + MessageOutput.mExist +";ִ�з���:" + BaseLib.getMethodName());
			//log.outLoggerInfo(selector.toString()+MessageOutput.mExist,BaseLib.getMethodName());
			//log.outLoggerInfo(selector.toString()+MessageOutput.mExist);
			
			return true;
		}
		catch(NoSuchElementException e){
			logger.info(spilt);
			logger.severe(selector.toString()+MessageOutput.mNot+MessageOutput.mExist  +";ִ�з���:" + BaseLib.getMethodName());
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
	
	//���
	public boolean click(WebDriver driver , By by) {
		BaseLib.theadTime();
		if(isElementExist(driver,by)){
			driver.findElement(by).click();
			logger.info(spilt);
			logger.info(MessageOutput.mclick + by.toString() + MessageOutput.mPass + ";ִ�з���:" + BaseLib.getMethodName());
			//log.outLoggerInfo(MessageOutput.mclick + by.toString() + MessageOutput.mPass,BaseLib.getMethodName());
			return true;
		}else{
			logger.info(spilt);
			logger.severe(MessageOutput.mclick + by.toString() + MessageOutput.mNot + MessageOutput.mExist + ";ִ�з�����" + BaseLib.getMethodName());
			//log.outLoggerSevere(MessageOutput.mclick + by.toString() + MessageOutput.mNot + MessageOutput.mExist, BaseLib.getMethodName());
			return false;
		}		
	}
	
	//�����ı�
	public boolean sendkeys(WebDriver driver, By by, String inputString){
		BaseLib.theadTime();
		if(isElementExist(driver,by)){
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(inputString);
			logger.info(spilt);
			logger.info(MessageOutput.mInput + by.toString() + inputString + MessageOutput.mPass + ";ִ�з���:" + BaseLib.getMethodName());
			//log.outLoggerInfo(MessageOutput.mInput + by.toString() + inputString + MessageOutput.mPass, BaseLib.getMethodName());
			return true;
		}
		else{
			logger.info(spilt);
			logger.severe(MessageOutput.mInput + by.toString() + inputString + MessageOutput.mPass + ";ִ�з���:" + BaseLib.getMethodName());
			//log.outLoggerInfo(MessageOutput.mInput + by.toString() + inputString + MessageOutput.mPass, BaseLib.getMethodName());
			return false;
		}
	}
	
	//��ȡ��ǰҳ���title
	public String getTitle(WebDriver driver){
		BaseLib.theadTime();
		return driver.getTitle();
	}
	
	//��ȡ��ǰҳ�������
	public String getCurrentUrl(WebDriver driver){
		BaseLib.theadTime();
		return driver.getCurrentUrl();
	}
	
	//������������
	public void maxSize(WebDriver driver){
		BaseLib.theadTime();
		driver.manage().window().maximize();
	}
	
	//ǰ��
	public void forward(WebDriver driver){
		BaseLib.theadTime();
		driver.navigate().forward();
	}
	
	//���������
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
			logger.info(by.toString()+"ֵ" + text + "ѡ��ɹ�;ִ�з���:" + BaseLib.getMethodName());
			//log.outLoggerInfo(by.toString()+"ֵ" + text + "ѡ��ɹ�", BaseLib.getMethodName());
			return true;
		}else{
			logger.info(spilt);
			logger.severe(by.toString()+"ֵ" + text + "Ԫ�ز�����;ִ�з���:" + BaseLib.getMethodName());
			//log.outLoggerSevere(by.toString()+"ֵ" + text + "Ԫ�ز�����", BaseLib.getMethodName());
			return false;
		}		
	}	
	
	//ȫѡ
	public boolean selectAll(WebDriver driver, By by){
		BaseLib.theadTime();
		if(isElementExist(driver,by)){
			driver.findElement(by).sendKeys(Keys.CONTROL + "a");
			logger.info(spilt);
			logger.info(by.toString()+"ȫѡ"+MessageOutput.mPass + ";ִ�з���:" +BaseLib.getMethodName());
			//log.outLoggerInfo(by.toString()+"ȫѡ"+MessageOutput.mPass, BaseLib.getMethodName());
			return true;
		}else{
			logger.info(spilt);
			logger.severe(by.toString()+"ȫѡ"+MessageOutput.mFail + ";ִ�з���:" + BaseLib.getMethodName());
			//log.outLoggerSevere(by.toString()+"ȫѡ"+MessageOutput.mFail, BaseLib.getMethodName());
			return false;
		}
	}
	
	//��ȡ����ֵ ����λһ��Ԫ�أ���ͨ����Ԫ�ػ�ȡ����ֵ
	public String getAttribute(WebDriver driver, By by, String attriBute){
		BaseLib.theadTime();
		String str = null;
		if(isElementExist(driver,by)){
			str = driver.findElement(by).getAttribute(attriBute);
			logger.info(spilt);
			logger.info(by.toString()+"��ȡ����ֵ"+ attriBute + MessageOutput.mPass + ";����ֵΪ:" + str + ";ִ�з���:"+ BaseLib.getMethodName());
			//log.outLoggerInfo(by.toString()+"��ȡ����ֵ"+ attriBute +MessageOutput.mPass, BaseLib.getMethodName());
			return str;
		}else{
			logger.info(spilt);
			logger.severe(by.toString()+"��ȡ����ֵ"+ attriBute +MessageOutput.mFail + ";ִ�з���:" + BaseLib.getMethodName());
			//log.outLoggerSevere(by.toString()+"��ȡ����ֵ"+ attriBute +MessageOutput.mFail, BaseLib.getMethodName());
			return str;
		}
	}
	
	//��ȡָ��Ԫ�صĵ��ı�ֵ
	public String getText(WebDriver driver, By by){
		BaseLib.theadTime();
		String str = null;
		if(isElementExist(driver,by)){
			str = driver.findElement(by).getText();
			logger.info(spilt);
			logger.info(by.toString()+"��ȡ�ı�"+MessageOutput.mPass + ";ִ�з���:" + BaseLib.getMethodName());
			//log.outLoggerInfo(by.toString()+"��ȡ�ı�"+MessageOutput.mPass, BaseLib.getMethodName());
			return str;
		}else{
			logger.info(spilt);
			logger.severe(by.toString()+"��ȡ�ı�"+MessageOutput.mFail + ";ִ�з���:" + BaseLib.getMethodName());
			//log.outLoggerSevere(by.toString()+"��ȡ�ı�"+MessageOutput.mFail, BaseLib.getMethodName());
			return str;
		}
	}

	//�л����ڣ���ѭ��,��title�ж�
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
			logger.info("�л����ڳɹ�,��ǰҳ��:"+driver.getCurrentUrl());
			//log.outLoggerInfo("�л����ڳɹ�,��ǰҳ��:" , driver.getCurrentUrl());
		}else{
			logger.info(spilt);
			logger.severe("�л�����ʧ��,��ǰҳ��:" +driver.getCurrentUrl());
			//log.outLoggerSevere("�л�����ʧ��,��ǰҳ��:" , driver.getCurrentUrl());
		}
		return flag;
	}
	
	//�л�����,�������ڣ�titleһ��
	public boolean selectWindowTow(WebDriver driver){
		BaseLib.theadTime();
		boolean flag = false;
		try{
			Set<String> handles = driver.getWindowHandles();
			String handle = driver.getWindowHandle();
			handles.remove(handle);
			driver.switchTo().window(handles.iterator().next());
			logger.info(spilt);
			logger.info("���������л��ɹ�;��ǰ����:"+ getCurrentUrl(driver));
			//log.outLoggerInfo("���������л��ɹ�", BaseLib.getMethodName(), getCurrentUrl(driver));
			flag = true;
		}catch(NoSuchWindowException e){
			logger.info(spilt);
			logger.severe("���������л�ʧ��;��ǰ����:"+ getCurrentUrl(driver));
			//log.outLoggerSevere("���������л�ʧ��", BaseLib.getMethodName(), getCurrentUrl(driver));
			return flag;
		}
		return flag;
	}
	
	
	//�л�iframe
	public void toIframe(WebDriver driver, String value){
		BaseLib.theadTime();
		driver.switchTo().frame(value);
	}
	
	//�������е�iframe 
	public void toExitAllIframe(WebDriver driver){
		BaseLib.theadTime();
		driver.switchTo().defaultContent();
	}
	
	//accept alert(),���ȷ��
	public void acceptAlert(WebDriver driver){
		BaseLib.theadTime();
		driver.switchTo().alert().accept();
	}
	
	//���ȡ����ť�����߹رնԻ���
	public void disAlert(WebDriver driver){
		BaseLib.theadTime();
		driver.switchTo().alert().dismiss();
	}
	
	
	//��ȡalert�ı�ֵ
	public String getAlertText(WebDriver driver){
		BaseLib.theadTime();
		String str = null;
		str = driver.switchTo().alert().getText();		
		return str;		
	}
	
	//�ж��Ƿ�Ϊ isEnabled
	public boolean isEnable(WebDriver driver, By by){
		BaseLib.theadTime();
		boolean flag = false;
		if(isElementExist(driver, by)){
			flag = driver.findElement(by).isEnabled();
		}
		return flag;		
	}
	
	//�Ƿ�ѡ��
	public boolean isSelect(WebDriver driver, By by){
		BaseLib.theadTime();
		boolean flag = false;
		if(isElementExist(driver, by)){
			flag = driver.findElement(by).isSelected();
		}
		return flag;
	}
	
	//ִ��js����
	public boolean runJs(WebDriver driver, By by, String js){
		BaseLib.theadTime();
		if(isElementExist(driver, by)){
			((JavascriptExecutor)driver).executeScript(js, driver.findElement(by));	
			logger.info(spilt);
			logger.info(by.toString()+":ִ��js" + js + "�ɹ�;"+ BaseLib.getMethodName());
			//log.outLoggerInfo(by.toString()+":" + js, BaseLib.getMethodName(),getCurrentUrl(driver));
			return true;
		}
		else{
			logger.info(spilt);
			logger.severe(by.toString()+":ִ��js" + js + "ʧ��;"+ BaseLib.getMethodName());
			//log.outLoggerSevere(by.toString()+":" + js, BaseLib.getMethodName(),getCurrentUrl(driver));
			return false;
		}
	}
	
	//����ҳ����س�ʱʱ��
	public static void pageLoadTimeout(WebDriver driver){
		BaseLib.theadTime();
		//log.outLoggerInfo("aa", "aa");
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(BaseLib.getConfigText("pageLoadTimeout")), TimeUnit.SECONDS);
		//log.outLoggerInfo("bb", "bb");
	}
	
	//���ö���ʱʱ��
	public void implicitlyWait(WebDriver driver){
		BaseLib.theadTime();
		driver.manage().timeouts().implicitlyWait(Long.parseLong(BaseLib.getConfigText("implicitlyWaitTime")), TimeUnit.SECONDS);
	}
	
	//��д����
	public void newverifyEquals(String p_m,Object p_expected,Object p_actual,String functionName, String url){
		BaseLib.theadTime();	
		if (p_expected.equals(p_actual)) {
				//writeToLog();
				//log.outLoggerInfo("ִ�У�" + p_m + "���������" + p_expected + ";ʵ�ʽ����" + p_actual, functionName, url);
				logger.info(spilt);	
				logger.info(p_m + "-�������:" + p_expected + "-ʵ�ʽ��:" + p_actual + ";ִ��ͨ��" + "-ִ�з���:" + functionName + "-��ǰURL:" + url);
				//BaseLib.writeToLog("aa", "aa", "oo", "aa");
				BaseLib.writeToLog(p_m, p_expected, p_actual, "PASS");
			}					
			else{
				//writeToLog();
				//log.outLoggerSevere("ִ�У�" + p_m + "���������" + p_expected + ";ʵ�ʽ����" + p_actual, functionName, url);
				logger.info(spilt);
				logger.severe(p_m + "-�������:" + p_expected + "-ʵ�ʽ��:" + p_actual + ";ִ��ʧ��;" + "-ִ�з���:" + functionName + "-��ǰURL:" + url);
				BaseLib.writeToLog(p_m, p_expected, p_actual, "FAIL");
				
				}
	}
	
	public void newAssertEquals(String p_m,Object p_expected,Object p_actual,String functionName, String url){
		BaseLib.theadTime();	
		if (p_expected.equals(p_actual)) {
				//writeToLog();
				//log.outLoggerInfo(p_m + ":���������" + p_expected + ";ʵ�ʽ����" + p_actual, functionName, url);
				logger.info(spilt);	
				logger.info(p_m + "-�������:" + p_expected + "-ʵ�ʽ��:" + p_actual + ";ִ��ͨ��" + "-ִ�з���:" + functionName + "-��ǰURL:" + url);
			
				//BaseLib.writeToLog("aa", "aa", "oo", "aa");
				BaseLib.writeToLog(p_m, p_expected, p_actual, "PASS");
		}					
			else{
				//writeToLog();
				logger.info(spilt);
				logger.severe(p_m + "-�������:" + p_expected + "-ʵ�ʽ��:" + p_actual + ";ִ��ʧ��;" + "-ִ�з���:" + functionName + "-��ǰURL:" + url);
				//logger.severe(MessageOutput.mActualResult+MessageOutput.mExpectedResult+MessageOutput.mNot);
				BaseLib.writeToLog(p_m, p_expected, p_actual, "FAIL");
				
				}
	}
	
	//����ִ���쳣��û�л�ȡ��ص�Ԫ��ֵ������
		public void functionRunError(String testName){
			logger.severe("������" + testName + "ִ�г���������û�л�ȡ�����Ԫ�ص�ֵ��");
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
	
	
	//before class ִ��
	public static void newClassStart(String fileName){
		try {
			//����HMMLLOG
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
	
	//After class ִ��
	public static void newClassStop(){
		BaseLib.theadTime();
		BaseLib.closeLog();
		//OutLogger.outClose();
		fileHandle.close();		
	}
	
	//��ȡ�����ļ�����¼����
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
				logger.info("*************��¼�ɹ�*************************");
				//Cookie e =driver.manage().getCookieNamed(DataInputStore.dCookieName);
				//driver.get(DataInputStore.dCookieUrl);
				//driver.manage().addCookie(e);
				//driver.get(DataInputStore.dCookieUrl);
				//((JavascriptExecutor)driver).executeScript("window.open('http://pet.goudaifu.com:8099/Home/UserHome/procure_catelogure')");
				return true;
			}
			else{
				logger.severe("*************��¼ʧ��*************************");
				return false;
			}
		
	}
	
	
}
