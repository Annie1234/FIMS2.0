package com.haiberg.automation.apps.client.ui.tasks;

import com.haiberg.automation.CoreAuto.Platform;
import com.haiberg.automation.apps.client.ui.widgets.UserLogoutWidgets;
import com.haiberg.automation.core.web.WebBrowser;
import com.haiberg.automation.CoreAuto.CoreAutomation;

import java.io.IOException;
import java.text.SimpleDateFormat;


public class UserLogoutTask {

    boolean result = false;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
	String currentTime = sdf.format(System.currentTimeMillis());
	UserLogoutWidgets ulw = new UserLogoutWidgets();
	CoreAutomation coreauto=new CoreAutomation();
	Platform plf =new Platform();
	

	public boolean ClickLogoutButton() throws IOException{
		
		ulw.getLogoutButton().click();
		plf.sleep(500);
		result = true;
		
		return result;
	}
	
	public boolean ClickConfirmButton() throws IOException{
		
		ulw.getLogconfirmButton().click();
		plf.sleep(200);
		result=true;
		
		return result;
	}
	
	public  boolean verifyResult(String text, String res) throws Exception {

		if(ulw.Ispresent())
		result = coreauto.assertElement(ulw.getVerifyText(),text);

		if(String.valueOf(result).equals(res))
			
			return result;
		
		else
			{
		
			return false;
			}
	}
}
