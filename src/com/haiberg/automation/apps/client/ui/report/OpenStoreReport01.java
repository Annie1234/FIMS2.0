package com.haiberg.automation.apps.client.ui.report;

import java.util.HashMap;

import com.haiberg.automation.CoreAuto.Platform;

public class OpenStoreReport01 extends BaseReport {
	
	 public  void OpenStoreStart(String icon1,String icon2,String icon3, String icon4, String icon5, String icon6){
			
		 String num=String.valueOf(testcasenum);
		 demap=new HashMap<String, String>(); 
		 String details="Icon1:"+icon1+"    "+"Icon2:"+icon2+"    "+"Icon3:"+icon3;
		 
		 demap.put("details",details);
		 demap.put("reportname",Platform.filename);
		 demap.put("number",num);
		 
         testcasenum++;
	}
 

}
