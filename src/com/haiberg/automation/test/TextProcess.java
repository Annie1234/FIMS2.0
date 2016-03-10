package com.haiberg.automation.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextProcess {

   public static void main(String[] args) throws IOException {
	   boolean res=isRunning("WINWORD.exe");
	   System.out.println(res);
   //    System.out.println(TextProcess.isRunning("WINWORD.exe"));
	  Runtime.getRuntime().exec("taskkill /F /IM WINWORD.EXE");
     
   }

   public static boolean isRunning(String exeName) {
       Process proc;
       try {
           proc = Runtime.getRuntime().exec("tasklist");
           BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
           String info = br.readLine();
           while (info != null) {
               System.out.println(info);
               if (info.indexOf(exeName) >= 0) {
                   return true;
               }
               info = br.readLine();
           }
       } catch (IOException e) {
           e.printStackTrace();
       } 
       System.out.println(false);
       return false;
   }
   

}