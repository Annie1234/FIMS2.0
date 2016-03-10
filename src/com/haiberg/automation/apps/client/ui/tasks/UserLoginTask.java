package com.haiberg.automation.apps.client.ui.tasks;

import com.haiberg.automation.CoreAuto.Platform;
import com.haiberg.automation.apps.client.ui.widgets.UserLoginWidgets;
import com.haiberg.automation.CoreAuto.CoreAutomation;
import java.text.SimpleDateFormat;

/**  
* <p>Title: UserLoginTask</p>  
* <p>Project name: ZOEIIAuto</p>
* <p>Description: User Login task.TODO</p> 
* @author Adeng 
* @date Sep 23, 2014 3:37:18 PM 
* @version 1.0   
* <p>Copyright: 2014 www.haiberg.de Inc. All rights reserved.</p>
*/
public class UserLoginTask {

	static boolean result = false;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
	String currentTime = sdf.format(System.currentTimeMillis());
	
	
	UserLoginWidgets loginwidgets=new UserLoginWidgets();
	
	
	Platform plf=new Platform();
	CoreAutomation coreauto =new CoreAutomation();
	
	
	public boolean InputUserName(String name) throws Exception{
	    
		loginwidgets.getTextFieldUserName().sendKeys(name);
		result = true;
		
		return result;
    }

	
	public boolean InputPassword(String password) throws Exception{
		
		loginwidgets.getTextFieldPassWord().sendKeys(password);
		result = true;
		
		return result;
    }
	
	public boolean ClickSubmitButton() throws Exception{
		
		loginwidgets.getButtonLogin().click();
		plf.sleep(1000);
		result = true;
		
		return result;
    }

	
	public boolean verifyResult(String text, String res) throws Exception {

		//WebBrowser.waitForReady();
		
		if(loginwidgets.Ispresent())
	  
		result = coreauto.assertElement(loginwidgets.getVerifyText(),text);
		
		else
		   result=false;
		
		System.out.println("result="+result);
		
		if(String.valueOf(result).equals(res))
			
			return result;
		
		else			
		
			return false;
		
	}
	
}
