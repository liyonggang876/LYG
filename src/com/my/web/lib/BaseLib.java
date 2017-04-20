package com.my.web.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.MissingResourceException;
import java.util.Properties;


public class BaseLib {

	static HTMLReport hr=new HTMLReport();
	public static String HtmlLog;
	public static String SeleniumBaseLibLog;
	
	/*public static String getPropertyString(String key ) {

		String propertyFileName = System.getProperty("src/")+"config.properties";      //����ļ�·��
	    Properties properties = new Properties();
		    
		    try {
		properties.load(new FileInputStream(propertyFileName));    //��ȡ�ļ��е�����
		}catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
		        if (key == null || key.equals("") || key.equals("null")) {
		            return "";
		        }
		        String result = "";
		        try {
		            result = properties.getProperty(key);        //ȡkeyֵ
		        } catch (MissingResourceException e) {
		            e.printStackTrace();
		        }
		        return result;
		    }*/
	
 public static void newSleep(int p_time){
		
		try {
			Thread.sleep(p_time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
 public static String getCurrentTime() throws Exception {

		Calendar ca = Calendar.getInstance();
		int year = ca.get(Calendar.YEAR);// ��ȡ���
		int month = ca.get(Calendar.MONTH);// ��ȡ�·�
		int day = ca.get(Calendar.DATE);// ��ȡ��
		int minute = ca.get(Calendar.MINUTE);// ��
		int hour = ca.get(Calendar.HOUR);// Сʱ
		int second = ca.get(Calendar.SECOND);// ��
		return (String.valueOf(year) + "-" + String.valueOf(month + 1) + "-"
				+ String.valueOf(day) + "-" + String.valueOf(hour) + "-"
				+ String.valueOf(minute) + "-" + String.valueOf(second));

	}
 
 
	
	public static void createHtmlLog(String p_caseName) throws Exception{
	
	String RESULTS_BASE_PATH = "Log" + File.separator
				+ "loggingResults";
	
	String resultsPath = new File(RESULTS_BASE_PATH).getAbsolutePath();
	
	String resultHtmlFileName = resultsPath + File.separator
			+ p_caseName + "_" + BaseLib.getCurrentTime() + "_"
				+ getBrowserName() + "_log.html";
	HtmlLog=resultHtmlFileName;
	
	String resultSeleniumLogFileName = resultsPath + File.separator
			+ p_caseName + "_" + BaseLib.getCurrentTime() + "_"
			+ "_seleniumLog.log";
	SeleniumBaseLibLog=resultSeleniumLogFileName;
	
	if (!new File(RESULTS_BASE_PATH).exists()) {
		new File(RESULTS_BASE_PATH).mkdirs();
	}
	
	    System.out.println("���� HTML��־ ---"+resultHtmlFileName);
		hr.setup(resultHtmlFileName);
		
		
	}
	public static void closeLog(){
		hr.closeLog();
	}
	
	public static void writeToLog(String p_info,Object p_expected, Object p_actual, String p_result){
		hr.logWriter(p_info, p_expected, p_actual, p_result);
	}
	
	// ����������������Ϣ
		public static String getBrowser(){
			String browser = null;
			
			try{
				if (getConfigText("FireFoxBrowser")!= null)
					browser = DataInputStore.dFirefox;
				else if (getConfigText("IEBrowser") != null)
					browser = DataInputStore.dIE;
				else if (getConfigText("ChromeBrowser")!= null)
					browser = DataInputStore.dChrome;
				else if (getConfigText("Browser")!= null)
					browser = DataInputStore.dSafari;
				else if (getConfigText("OperaBrowser")!= null)
					browser = DataInputStore.dOpera;
				else
					browser = DataInputStore.dIE;
			}catch (Exception e)
			{
				e.printStackTrace();
				
			}
			
			return browser;
		}
		
		public static String getBrowserName() throws Exception{
			
			String str=getBrowser();
			if (str.contains("*iexplore"))
			    return "ie";
			else if (str.contains("*chrome"))
			   return "firefox";
			else if (str.contains("*googlechrome"))
			   return "chrome";
			else if (str.contains("*safari"))
			   return "safari";
			else if (str.contains("*safari"))
				return "opera";
			else return null;
			
		}
	
	public static String getConfigText(String key) {
		//OutLogger log = new OutLogger();
		File file = new File("src/config.properties");
		if (file.exists()) {		  
			  InputStream inputstream;
			try {
				inputstream = new FileInputStream(file);
				 Properties properties = new Properties();
				  try {
					properties.load(inputstream);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  //log.outLoggerInfo(MessageOutput.mGet + "�����ļ�" + MessageOutput.mPass, log.getMethodName());
				  System.out.println("��ȡ�����ļ�properties�µ�:"+key+"="+properties.getProperty(key)+ "�ɹ���");
				  //return properties.getProperty(key);
				  
				  
				  	if (key == null || key.equals("") || key.equals("null")) {
			            return "";
			        }
			        String result = "";
			        try {
			            result = properties.getProperty(key);        //ȡkeyֵ
			        } catch (MissingResourceException e) {
			            e.printStackTrace();
			        }
			        return result;
				  
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}		 
		  
		}else{
			//log.outLoggerSevere(MessageOutput.mGet + "�����ļ�" + MessageOutput.mFail, log.getMethodName());
			 System.out.println("��ȡ�����ļ�properties�µ�"+key+"ʧ�ܣ�");
			return null;
		}
		
	}
	
	
	public static void theadTime(){
		long time = DataInputStore.sleepime;
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	public static void main(String[] args) throws Exception{
		String a = getConfigText("passWord");
		System.out.println(a);
	}
	
	//��ȡtalbe�е�ֵ
	/*public void tableTest() {       
        driver.get("http://www.w3school.com.cn/html/html_tables.asp");       
        //���ȵõ�����tr�ļ���    
        List<WebElement> rows = driver.findElements(By.cssSelector(".dataintable tr"));     
        //��֤��������    
        assertEquals(11,rows.size());    
         //��ӡ�����е�Ԫ�������    
        for (WebElement row : rows) {     
            //�õ���ǰtr��td�ļ���    
            List<WebElement> cols =  row.findElements(By.tagName("td"));     
            for (WebElement col : cols) {    
                System.out.print(col.getText());//�õ�td����ı�    
            }    
            System.out.println();    
        }    
        driver.close();    
    }    */
	

	
	public static String getMethodName() {  
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();  
        StackTraceElement e = stacktrace[2];  
        String methodName = e.getMethodName();  
        return methodName;  
    }
	
	
}



