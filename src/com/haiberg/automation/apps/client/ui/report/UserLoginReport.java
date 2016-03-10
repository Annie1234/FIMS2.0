package com.haiberg.automation.apps.client.ui.report;   

import java.util.HashMap;

import com.haiberg.automation.CoreAuto.Platform;


/**  
 * <p>Title: UserLoginReport</p>  
 * <p>Project name: ZOEIIAuto</p>
 * <p>Description: TODO</p> 
 * @author Adeng 
 * @date Sep 28, 2014 4:54:13 PM 
 * @version 1.0   
 * <p>Copyright: 2014 www.haiberg.de Inc. All rights reserved.</p>
 */
	public class UserLoginReport extends BaseReport {
	/** 
	* <p>Title: loginstart</p>
	* <p>Description: initailize the details about the test data TODO</p>
	* @param username
	* @param password
	* <p>Return Type: void</p>
	*/ 
		 public  void LoginStart(String icon1,String icon2,String icon3){
				
			 String num=String.valueOf(testcasenum);
			 demap=new HashMap<String, String>(); 
			 String details="Icon1:"+icon1+"    "+"Icon2:"+icon2+"    "+"Icon3:"+icon3;
			 
			 demap.put("details",details);
			 demap.put("reportname",Platform.filename);
			 demap.put("number",num);
			 
	         testcasenum++;
		}
	 
	 

}
