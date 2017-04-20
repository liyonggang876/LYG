package com.my.web.lib;

public interface DataInputStore {
	
	 String dURL=BaseLib.getConfigText("BaseUrl");
	 String dFirefox=BaseLib.getConfigText("FireFoxBrowser");
	 String dChrome=BaseLib.getConfigText("ChromeBrowser");
	 String dSafari=BaseLib.getConfigText("SafariBrowser");
	 String dOpera=BaseLib.getConfigText("OperaBrowser");
	 String dIE=BaseLib.getConfigText("IEBrowser");
	 long sleepime = Long.parseLong(BaseLib.getConfigText("Sleepime"));
	 
	 int dWaitTime=Integer.parseInt(BaseLib.getConfigText("WaitTime"));
	 
	 String dValue_myInfoLink_oldPwd="123456";
	 String dValue_myInfoLink_newPwd="123456";
	 String dValue_myInfoLink_confirmPwd="123456";
	 
	 String dLoginUrl=BaseLib.getConfigText("LoginUrl");
	 String dLoginOKUrl=BaseLib.getConfigText("LoginOKUrl");
	 String dUserName=BaseLib.getConfigText("UserName");
	 String dPassWord=BaseLib.getConfigText("PassWord");
	 String dUserNameXpath=BaseLib.getConfigText("UserNameXpath");
	 String dPassWordXpath=BaseLib.getConfigText("PassWordXpath");
	 String dLoginXpath=BaseLib.getConfigText("LoginXpath");
	 String dCookieName=BaseLib.getConfigText("CookieName");
	 String dCookieUrl=BaseLib.getConfigText("CookieUrl");
	 
			 
	 
	 
	
	 long dPageLoadTimeout= Long.parseLong(BaseLib.getConfigText("PageLoadTimeout"));
	 long dImplicitlyWaitTime = Long.parseLong(BaseLib.getConfigText("ImplicitlyWaitTime"));

}