package com.haiberg.automation.test;

import com.haiberg.automation.core.web.WebBrowser;
import com.haiberg.automation.util.Config;
import com.haiberg.automation.util.Misc;

public class Testsetup {

	
	
	public static void main(String []args)
	{
		//Misc.setExecutionENV();
		try {
			WebBrowser.browserinit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			WebBrowser.loadUrl(Config.getProperty("ZOEII_Login"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebBrowser.waitForReady();  
		
	}
}
