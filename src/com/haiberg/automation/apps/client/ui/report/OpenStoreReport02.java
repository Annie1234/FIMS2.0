package com.haiberg.automation.apps.client.ui.report;

import java.util.HashMap;

import com.haiberg.automation.CoreAuto.Platform;

public class OpenStoreReport02 extends BaseReport {
	
	 public  void OpenStoreStart(String icon1,String icon2,String icon3, String icon4, String icon5, String icon6,String icon7, String icon8, String icon9, String icon10,String icon11,String icon12,String icon13,String icon14){
			
		 String num=String.valueOf(testcasenum);
		 demap=new HashMap<String, String>(); 
		 String details="Icon1:"+icon1+"    "+"Icon2:"+icon2+"    "+"Icon3:"+icon3+"    "+"Icon4:"+icon4+"    "+"Icon5:"+icon5+"    "+"Icon6:"+icon6+"    "+"Icon7:"+icon7+"    "+"Icon8:"+icon8+"    "+"Icon9:"+icon9+"    "+"Icon10:"+icon10+"    "+"Icon11:"+icon11+"    "+"Icon12:"+icon12+"    "+"Icon13:"+icon13+"    "+"Icon14:"+icon14;
		 
		 demap.put("details",details);
		 demap.put("reportname",Platform.filename);
		 demap.put("number",num);
		 
         testcasenum++;
	}
 

}
