package com.haiberg.automation.test;   

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

/**  
 * <p>Title: TestData</p>  
 * <p>Project name: ZOEIIAuto</p>
 * <p>Description: TODO</p> 
 * @author Adeng 
 * @date Sep 25, 2014 9:50:50 AM 
 * @version 1.0   
 * <p>Copyright: 2014 www.haiberg.de Inc. All rights reserved.</p>
 */
public class TestData {

    
    public static void main(String[] args) { 
    	/*
    	 ArrayList  <Hashtable<String, String>> al=new  ArrayList  <Hashtable<String, String>>();
         Hashtable<String, String> ht = new Hashtable<String, String>();

    	ht.put("bb","df");
    	al.add(ht);
    	ht.put("cc", "dc");
    	al.add(ht);
    	ht.put("dd", "dgvr");
    	al.add(ht);
    	
    	
    	Hashtable[] array=new Hashtable[al.size()]; 
    	
        for(int i=0;i<al.size();i++){  
        	
            array[i]=(Hashtable)al.get(i);  
            System.out.println(array[i]);
        }  
         
        */
    	
       String des="End";
       String tt="PASS.End";
       String aa=tt.substring(5);
       if (aa.equals("End"))
       {
          System.out.println("ok");
       }
}
}