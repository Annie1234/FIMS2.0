package com.haiberg.automation.apps.client.ui.widgets;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import com.haiberg.automation.core.web.wigdets.BaseWidgets;
import com.haiberg.automation.core.web.wigdets.Locator;

public class UserLogoutWidgets extends BaseWidgets {

	public WebElement getLogoutButton() throws IOException{
		
		return getElement(new Locator("//*[@id='nav-body']/div/div/a[9]"));
	}
	
	public WebElement getLogconfirmButton() throws IOException{
		
		return getElement(new Locator("//*[@class='x-window x-layer x-window-ui-gray-hearder-window x-border-box']/div[2]/div/div/div[2]/div/div/a[1]/span/span/span[2]"));
	}
	
	public WebElement getVerifyText() throws IOException{
		
		return getElement(new Locator("//*[@id='loginBtn-btnInnerEl']"));
	}
	
	 public Boolean Ispresent() throws Exception{
		    
	    	boolean res=isElementPresent(new Locator("//*[@id='loginBtn-btnInnerEl']"), 6);
	    	return res;
	    }
}
