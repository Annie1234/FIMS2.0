package com.haiberg.automation.apps.client.ui.widgets;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.haiberg.automation.core.web.wigdets.BaseWidgets;
import com.haiberg.automation.core.web.wigdets.Locator;

public class HomePageWidgets extends BaseWidgets{
	
	public WebElement getTicket() throws IOException {
		
		return  getElement(new Locator("//*[@id='homegrid-body']/div[1]/div[2]/table[1]"));
	}
	
	 public void DoubleClickTicket02() throws IOException{
	    
		   WebElement ticket=getElement(new Locator("//*[@id='homegrid-body']/div[1]/div[2]/table[1]"));
	       Actions action = new Actions(driver); 
		   action.doubleClick(ticket).perform();
	    	
	}
	
	public void DoubleClickTicket03() throws IOException{
		    
		   WebElement ticket=getElement(new Locator("//*[@id='homegrid-body']/div[1]/div[2]/table[4]"));
	       Actions action = new Actions(driver); 
		   action.doubleClick(ticket).perform();
	    	
	}
	 
	public void DoubleClickTicket04() throws IOException{
	    
		   WebElement ticket=getElement(new Locator("//*[@id='homegrid-body']/div[1]/div[2]/table[3]"));
	       Actions action = new Actions(driver); 
		   action.doubleClick(ticket).perform();
	    	
	}
	
	public void DoubleClickTicket05() throws IOException{
	    
		   WebElement ticket=getElement(new Locator("//*[@id='homegrid-body']/div[1]/div[2]/table[1]"));
	       Actions action = new Actions(driver); 
		   action.doubleClick(ticket).perform();
	    	
	}
	 
	public WebElement getHomeTicketColor02() throws IOException {
			
			return  getElement(new Locator("//*[@id='homegrid-body']/div[1]/div[2]/table[1]/tbody/tr/td[1]"));
	}
	
	
	public WebElement getHomeTicketColor03() throws IOException {
		
		return  getElement(new Locator("//*[@id='homegrid-body']/div[1]/div[2]/table[4]/tbody/tr/td[1]"));
	}
	
	public WebElement getHomeTicketColor04() throws IOException {
		
		return  getElement(new Locator("//*[@id='homegrid-body']/div[1]/div[2]/table[3]/tbody/tr/td[1]"));
	}
	
	public WebElement getHomeTicketColor05() throws IOException {
		
		return  getElement(new Locator("//*[@id='homegrid-body']/div[1]/div[2]/table[1]/tbody/tr/td[1]"));
	}
	 
	public boolean getRedColor(WebElement el) throws IOException{
				
			return el.getCssValue("background-color").equals("rgba(204, 0, 0, 1)");
						
	}
	
	public boolean getYellowColor(WebElement el) throws IOException{
		
		return el.getCssValue("background-color").equals("rgba(255, 255, 0, 1)");
					
	}
	
	public boolean getGrayColor(WebElement el) throws IOException{
		
		return el.getCssValue("background-color").equals("rgba(155, 155, 155, 1)");
					
	}
	
	public WebElement getDoneNavibar() throws IOException{
		
		return  getElement(new Locator("//*[@id='menuErledigt-btnInnerEl']"));
					
	}
	
}
