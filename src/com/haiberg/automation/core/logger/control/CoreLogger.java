package com.haiberg.automation.core.logger.control;

import java.util.*;  
import java.io.File;
import java.io.IOException;
import java.lang.String;
import com.haiberg.automation.core.web.WebBrowser;
import com.haiberg.automation.util.Config;
import com.haiberg.automation.CoreAuto.Platform;

public class CoreLogger {

	// Dispatch doc = null;
	 Platform plf=new Platform();
	 LogSteps ls=new LogSteps();
	// WordManager msWordManager =null;
	 
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
    
    public String getTemplatePath(){
    	
    	 try {
    		 
			String templatepath=Config.getProperty("TemplatePath");
			
			return templatepath;
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	 	return null;
    }
   
    /** 
    * <p>Title: info</p>
    * <p>Description: It is about log info.TODO</p>
    * @param a
    * <p>Return Type: void</p>
    */ 
    public void info(String info){
    	
    	String first,second,description,end;
    	first=info.substring(0, 1);
    	second=info.substring(1, 2);
    	description=info.substring(3);
    	end=info.substring(6,7);
    	
    	if(first.equals("F")){
    		
    		ls.logFstart(second,description,getTemplatePath());
    	}
    	
    	else if(first.equals("A")){
    		
    		ls.logAstart(second,description,getTemplatePath());
    	}
    	
    	else if(first.equals("P")){
    		
    		if(end.equals("E")){
    			
    			ls.LogEstart("--OK-- The End",getTemplatePath());
    			
    		}
    	    else{
    	    	
    	    	ls.logPstart("It is OK!",getTemplatePath());
    		}
    		
    	}
    	
    	else{
    		
    		ls.logVstart(info,getTemplatePath());
    	}
    	
    }
  
    public  void error(String error){
    	
    	String result,path;
    	result=error.substring(0,4);
    	System.out.println("screen result="+result);
    	WordManager.getInstance().copyParagraphFromAnotherDoc(getTemplatePath(), 5);// red fail
    	WordManager.getInstance().replaceAllText("$result2$", result);
    	//path=WebBrowser.captureScreenshot(error);
    	path=WebBrowser.captureScreenshot(result);
    	System.out.println("screen result="+plf.getPicFrontName(path));
    	WordManager.getInstance().insertImage(path);
    	WordManager.getInstance().copyParagraphFromAnotherDoc(getTemplatePath(), 8);
    	WordManager.getInstance().replaceAllText("$methodname$", Platform.filename);
    	WordManager.getInstance().replaceAllText("$result$", result);
    	WordManager.getInstance().replaceAllText("$testdate$", Platform.date);
    	WordManager.getInstance().save(Platform.filename);
    	WordManager.getInstance().close();
       
		
		System.out.println("Word close!");
    	
    }
    
   
    
/*	public  String getFileName(){
		
		filename="h:/AutoLogs/Client_"+methodname+"_"+generateRandomFilename()+"doc";
		
		return filename;
		
	}
	*/
	/** 
	* <p>Title: Generatefilr</p>
	* <p>Description: generate a log file first. TODO</p>
	* @param filename
	* <p>Return Type: void</p>
	*/ 
	public void Generatefilr(String filename){
	
		File d = new File(filename);
		
        try {
        	
			d.createNewFile();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 /** 
	* <p>Title: caseStart</p>
	* <p>Description: when case begin to test, the template should be initialized!</p>
	* <p>Return Type: void</p>
	 * @throws Exception 
	*/ 
	public  void caseStart() throws Exception{
		
		 System.out.println("Casestart");
		// WordManager.msWordManager = new WordManager(true); 
		 String filename=plf.getFileName();		 
         Generatefilr(filename);
         System.out.println("filename"+filename);
       
         WordManager.getInstance().openDocument(filename); 
    
        // WordManager.getInstance().copyParagraphFromAnotherDoc("D:\\Annie\\Template\\TestLog.doc", 1);
         WordManager.getInstance().copyParagraphFromAnotherDoc(getTemplatePath(), 1);
         WordManager.getInstance().replaceAllText("$hostname$",plf.getHostName());
         WordManager.getInstance().replaceAllText("$testdate$",plf.getTestDate());
         WordManager.getInstance().replaceAllText("$filename$",filename);

	}
	
}
