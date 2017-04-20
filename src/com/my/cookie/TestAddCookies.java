package com.my.cookie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestAddCookies {
	public static BufferedReader bufferedReader;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("http://pet.goudaifu.com:8099/Home/UserHome/my_order");
		try{
			File cookieFile = new File("zhihu.cookie.txt");
			FileReader fr = new FileReader(cookieFile);
			bufferedReader = new BufferedReader(fr);
			String line;
			while((line = bufferedReader.readLine()) != null){
				StringTokenizer stringTokenizer = new StringTokenizer(line,";");
				while(stringTokenizer.hasMoreTokens()){
					String name = stringTokenizer.nextToken();
					String value = stringTokenizer.nextToken();
					String domain = stringTokenizer.nextToken();
					String path = stringTokenizer.nextToken();
					Date expiry = null;
					String dt;
					if(!(dt = stringTokenizer.nextToken()).equals("null")){
						expiry = new Date(dt);
					}
					boolean isSecure = new Boolean(stringTokenizer.nextToken()).booleanValue();
					Cookie cookie = new Cookie(name,
										value,
										domain,
										path,
										expiry,
										isSecure);
					driver.manage().addCookie(cookie);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		driver.get("http://pet.goudaifu.com:8099/Home/UserHome/my_order");
	}

}
