package com.haiberg.automation.apps.client.ui.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.ListOrderedMap;

import jxl.report.ReportEnginer;

import com.haiberg.automation.CoreAuto.Platform;

public class BaseReport {

static   int testcasenum=1;
public   static  Map<String, String> demap=null;	 
public    static ReportEnginer enginer = new ReportEnginer();
@SuppressWarnings("unchecked")
public    static Map<String, Object> context = (Map<String, Object>)new ListOrderedMap();
@SuppressWarnings("rawtypes")
public   static  List<Map> DT =new ArrayList<Map>();
		
	 
	 public  void ERportInit(String dn,String dd,String sys){
				
		 context.put("dn",dn);
		 context.put("dd",dd);
		 context.put("system",sys);
	}
 
	 
	 public  void Base2Start(String icon1,String icon2){
			
		 String num=String.valueOf(testcasenum);
		 demap=new HashMap<String, String>(); 
		 String details="Icon1:"+icon1+"    "+"Icon2:"+icon2;
		 
		 demap.put("details",details);
		 demap.put("reportname",Platform.filename);
		 demap.put("number",num);
		 
         testcasenum++;
	}
	 
	 
	 public  void Base3Start(String icon1,String icon2,String icon3){
			
		 String num=String.valueOf(testcasenum);
		 demap=new HashMap<String, String>(); 
		 String details="Icon1:"+icon1+"    "+"Icon2:"+icon2+"    "+"Icon3:"+icon3;
		 
		 demap.put("details",details);
		 demap.put("reportname",Platform.filename);
		 demap.put("number",num);
		 
         testcasenum++;
	}
	 
	 
	  public  void setreport(boolean result){

			String res;
			
			try {
				
				if(String.valueOf(result).equals("true"))
				
					res="PASS";
				
				else
					
					res="FAIL";
			
				demap.put("result",res);
				
			//	ExcelReport.DT.add(demap);
			
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
		
		
		public  void setTime(long runtime){
			
			demap.put("time",String.valueOf(runtime));
			DT.add(demap);
		}
}
