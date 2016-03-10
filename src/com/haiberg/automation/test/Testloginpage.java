package com.haiberg.automation.test;   

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.haiberg.automation.CoreAuto.CoreAutomation;

/**  
 * <p>Title: Testloginpage</p>  
 * <p>Project name: ZOEIIAuto</p>
 * <p>Description: TODO</p> 
 * @author Adeng 
 * @date Sep 24, 2014 9:18:19 AM 
 * @version 1.0   
 * <p>Copyright: 2014 www.haiberg.de Inc. All rights reserved.</p>
 */
public class Testloginpage {
	
	static boolean result;
	 static WebDriver driver;
	 public static void main(String []args){
     WebElement est; 
	 String text;
	 System.setProperty("webdriver.chrome.driver","H:\\Tools\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("http://10.134.0.54:8080/");
	 try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	est=driver.findElement(By.xpath("//*[@name='users.username']"));
	est.sendKeys("tivon");
	est=driver.findElement(By.xpath("//*[@name='users.password']"));
	est.sendKeys("123");
	est=driver.findElement(By.xpath("//*[@class='login_btn'][@type='submit']"));
	est.click();
	
	//String a=LoginWidgets.getTextFieldDashb1().getClassname();
    //driver.findElement(By.xpath("//*[@id='p_p_id_ZOEII_WAR_ZOEIIportlet_']/div/div/div/div[3]/div[2]")).getAttribute("class");

	/*est=(WebElement) LoginWidgets.getTextFieldDashb();
	result=est.getText().startsWith("Dash");
	//result = CoreAutomation.Assert.assertElement(LoginWidgets.getTextFieldDashb(),"Dash"); */
//	System.out.println("ttttt==="+a);
	
	 }
}
