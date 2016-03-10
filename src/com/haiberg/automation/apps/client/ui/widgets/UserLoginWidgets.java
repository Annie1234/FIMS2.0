package com.haiberg.automation.apps.client.ui.widgets;

import org.openqa.selenium.WebElement;
import com.haiberg.automation.core.web.wigdets.BaseWidgets;
import com.haiberg.automation.core.web.wigdets.Locator;

/**  
* <p>Title: LoginWidgets</p>  
* <p>Project name: ZOEIIAuto</p>
* <p>Description: TODO</p> 
* @author Adeng 
* @date Sep 23, 2014 9:43:12 AM 
* @version 1.0   
* <p>Copyright: 2014 www.haiberg.de Inc. All rights reserved.</p>
*/
public class UserLoginWidgets extends BaseWidgets {
	
	
	
 	
	public WebElement getTextFieldUserName() throws Exception {
			
		return getElement(new Locator("//*[@id='username-inputEl']"));
	}
	
	public WebElement getTextFieldPassWord() throws Exception {
		
		return getElement(new Locator("//*[@id='password-inputEl']"));
	}

	public WebElement getButtonLogin() throws Exception {
		
		return getElement(new Locator("//*[@id='loginBtn-btnInnerEl']"));
	}
	
	
    public  WebElement getVerifyText() throws Exception {
		
		return getElement(new Locator("/html/body/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div[1]/div/div/label"));
	}                               
    
    public Boolean Ispresent() throws Exception{
    
    	boolean res=isElementPresent(new Locator("/html/body/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div[1]/div/div/label"), 10);
    	return res;
    }

}
