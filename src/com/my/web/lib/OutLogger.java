package com.my.web.lib;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.openqa.selenium.WebDriver;

public class OutLogger{
	//创建日志对象
	/*	Logger logger = Logger.getLogger(Class.class.getName());
		static FileHandler fileHandle = null;
		WebDriver driver = null;
		
		
		public  void outLoggerInfo(String message,String functionName){
			try{
				
				fileHandle = new FileHandler(BaseLib.SeleniumBaseLibLog);
				fileHandle.setLevel(Level.INFO);
				fileHandle.setFormatter(new SimpleFormatter());
				logger.addHandler(fileHandle);
				logger.info(message + "-执行的方法：" +  functionName + "成功");
			}catch(Exception e){
				e.printStackTrace();
			}			
		}
		
		public  void outLoggerInfo(String message,String functionName ,String url){
			try{
				
				fileHandle = new FileHandler(BaseLib.SeleniumBaseLibLog);
				fileHandle.setLevel(Level.INFO);
				fileHandle.setFormatter(new SimpleFormatter());
				logger.addHandler(fileHandle);
				logger.info(message + "-执行的方法：" +  functionName + "成功;当前页面" + url);
			}catch(Exception e){
				e.printStackTrace();
			}			
		}
		
		public void outLoggerSevere(String message,String functionName, String url){
			try{
				
				fileHandle = new FileHandler(BaseLib.SeleniumBaseLibLog);
				fileHandle.setLevel(Level.SEVERE);
				fileHandle.setFormatter(new SimpleFormatter());
				logger.addHandler(fileHandle);
				logger.info(message + "-执行的方法：" +  functionName + "失败;当前页面" + url);
			}catch(Exception e){
				e.printStackTrace();
			}			
		}
		
		public void outLoggerSevere(String message,String functionName){
			try{				
				fileHandle = new FileHandler(BaseLib.SeleniumBaseLibLog);
				fileHandle.setLevel(Level.SEVERE);
				fileHandle.setFormatter(new SimpleFormatter());
				logger.addHandler(fileHandle);
				logger.info(message + "-执行的方法：" +  functionName);
			}catch(Exception e){
				e.printStackTrace();
			}			
		}
		
		
		public static void outClose(){
			fileHandle.close();
		}*/
		
		
		/*public  String getMethodName() {  
	        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();  
	        StackTraceElement e = stacktrace[2];  
	        String methodName = e.getMethodName();  
	        return methodName;  
	    }*/
		
}
