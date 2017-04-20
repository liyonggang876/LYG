package com.my.web.lib;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetCookie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		String strUrl = "http://pet.goudaifu.com:8099/Home/UserHome/index.html";
		driver.get("http://pet.goudaifu.com:8099/Home/index");
		driver.manage().deleteAllCookies();
		Cookie ck = new Cookie("SeekerChatAuth","token=fas490lc745b98s49si857aek3");
		driver.manage().addCookie(ck);
		driver.get(strUrl);
		//fas490lc745b98s49si857aek3

	}

}
