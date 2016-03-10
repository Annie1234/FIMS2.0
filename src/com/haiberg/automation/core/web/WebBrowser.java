package com.haiberg.automation.core.web;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import com.haiberg.automation.util.Config;

/**  
* <p>Title: WebBrowser</p>  
* <p>Project name: FIMS2.0</p>
* <p>Description: web browser options.TODO</p> 
* @author Adeng 
* @date Jan 23, 2016 5:19:43 PM 
* @version 1.0   
* <p>Copyright: 2015 www.haiberg.de Inc. All rights reserved.</p>
*/
public class WebBrowser {
	
	private static WebDriver driver;
	
	/** 
	* <p>Title: browserinit</p>
	* <p>Description:browser init. TODO</p>
	* @throws Exception
	* <p>Return Type: void</p>
	*/ 
	public static void broserinitRemote(DesiredCapabilities caps) throws Exception{
		
		driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
	}
	
	public static void browserinit() throws Exception{
		
		String type;
		type=Config.getProperty("browserType");
		
		if(type.equals("chrome")){
			String driverpath=Config.getProperty("ChromeDriverPath");
			//System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
			System.out.println("path"+driverpath);
			System.setProperty("webdriver.chrome.driver",driverpath);	
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(type.equals("firefox")){
			
			//System.setProperty ( "webdriver.firefox.driver" , "C:\\Program Files\\Mozilla Firefox\\firefox.exe" ); 
			driver = new FirefoxDriver();
			driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
		}
		else{
			
			System.out.println("No this browser!");
		}
	 
	}
	
	public static String captureScreenshot(String filename){
	
		String path=null;
		
		try { 
			String screeshotpath=Config.getProperty("ScreeshotPath");
			path=screeshotpath+filename+".png";
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
			FileUtils.copyFile (srcFile,new File(path)); 
			
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
		
		return path;
	}
	
	public static WebDriver getbrowser(){
	
		return driver;
	
	}
	
	/** 
	* <p>Title: loadUrl</p>
	* <p>Description:load url form properties. TODO</p>
	* @param url
	* <p>Return Type: void</p>
	*/ 
	public static void loadUrl(String url){
	
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		
        try { 
			
        	driver.get(url);
			
		} catch (TimeoutException e) { 
			
			System.out.println("Timeout");
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.stop()");
		}
	   
	}
	
	public void waitForReady(long a){
		
		try {
			Thread.sleep(a);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static void shutdown(){
		
		driver.quit();
	
	}
	
	public static void waitForReady() {
			// TODO Auto-generated method stub
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}