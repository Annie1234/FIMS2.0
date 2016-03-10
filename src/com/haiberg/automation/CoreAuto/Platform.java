package com.haiberg.automation.CoreAuto;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.haiberg.automation.util.Config;

public class Platform {
	
	 public static String hostname,date,filename,methodname;
	
	 InetAddress address;
	 String classname;
	 
	 
	 public String getHostName(){
		
		try {
			
			address = InetAddress.getLocalHost();
			hostname=address.getHostName();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		return hostname;
	}
	
	
	public String getTestDate(){
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    date=df.format(new Date());
		return date;
	}
	
	
	public  String getCaller() {  
		
	    StackTraceElement stack[] = (new Throwable()).getStackTrace();  	         
	    StackTraceElement s = stack[4];  
	    classname=s.getClassName();  
	    
	    return classname;
	}
	
	
	public String getCallingMethodName(){
		            
	   // String funcName2 = new Throwable().getStackTrace()[1].getMethodName();  
	    String className4 = Thread.currentThread().getStackTrace()[2].getMethodName();  
	    
	    return className4; 
	    
	}
	
	 
	 public String generateMethodname(){
		 
		 methodname=getCaller().replace("com.haiberg.automation.apps.client.crworkflow.", "");
		 return methodname;
		 
	 }
	
	 public  String getFileName() throws Exception{
		 
		    String wordlogpath=Config.getProperty("LogWordPath");
		    String path=wordlogpath+"Client_";
			filename=path+generateMethodname()+"_"+generateRandomFilename()+"doc";
			
			return filename;
			
		}
	 
	 public String generateRandomFilename(){  
	       
			String RandomFilename = "";  
		    Random rand = new Random();
		    Calendar calCurrent = Calendar.getInstance();  
		    int random = rand.nextInt();  
		    int intDay = calCurrent.get(Calendar.DATE);  
		    int intMonth = calCurrent.get(Calendar.MONTH) + 1;  
		    int intYear = calCurrent.get(Calendar.YEAR);  
		    String now = String.valueOf(intYear) + "_" + String.valueOf(intMonth) + "_" + String.valueOf(intDay) + "_";  
		    RandomFilename = now + String.valueOf(random > 0 ? random : ( -1) * random) + ".";  
		    
		    return RandomFilename;  
		 }
	 
	 

		private  String getClassAndMethodName(){
			
			String screenshotName = getCallingMethodName().replace("com.haiberg.automation.apps.", "");
			screenshotName = screenshotName.replace("(", "");
			screenshotName = screenshotName.replace(")", "");
			screenshotName = screenshotName.concat("_");
			
			return screenshotName;
		}
	
		
		
		public  String getPicFrontName(String message){
			
			String returnMessage = null;
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
	    	String mDateTime=formatter.format(cal.getTime());
	    	System.out.println(message);
			if(message.indexOf(".")>0){
				message = message.trim();
				returnMessage = getClassAndMethodName()+ message.substring(0, message.indexOf("."));
			}else if((message.indexOf(".")<=0)||(message.indexOf(".")>3)||(message.indexOf("A")<0)){
				returnMessage = getClassAndMethodName()+"A"+mDateTime;
			}
			return returnMessage.concat("_");
		}

		
	 
	 
	public  void sleep(int sec){
		
		try {
			
			Thread.sleep(sec);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
