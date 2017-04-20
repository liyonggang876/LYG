package com.my.cookie;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestGetCookie {
	public static void main(String[] args){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://pet.goudaifu.com:8099/Login/user_login.html");
		driver.findElement(By.id("username")).sendKeys("666");
		driver.findElement(By.id("password")).sendKeys("1");
		driver.findElement(By.id("loginfrom")).click();
		File cookieFile = new File("zhihu.cookie.txt");
		
		try{
			cookieFile.delete();
			cookieFile.createNewFile();
			FileWriter fileWriter = new FileWriter(cookieFile);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			for(Cookie cookie : driver.manage().getCookies()){
				bufferedWriter.write((cookie.getName() + ";"
						+ cookie.getValue() + ";" 
						+ cookie.getDomain() + ";" 
						+ cookie.getPath() + ";" 
						+ cookie.getExpiry() + ";"
						+ cookie.isSecure()));
				bufferedWriter.newLine();
			}
			bufferedWriter.flush();
			bufferedWriter.close();
			fileWriter.close();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		driver.quit();
	}

}
