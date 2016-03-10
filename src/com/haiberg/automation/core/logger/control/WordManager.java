package com.haiberg.automation.core.logger.control;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class WordManager {
   
	
    private Dispatch doc;
    private ActiveXComponent word=null;;
   // static  Process[] process;
    private Dispatch documents=null;
    private Dispatch selection;
    private boolean saveOnExit = true;
    
    private static WordManager uniqueWordManager;
    
    public static synchronized WordManager getInstance(){
    	
    	if(uniqueWordManager==null){
    		
    		uniqueWordManager=new WordManager(true);
    	}
    	
    	return uniqueWordManager;
    }
    
    public WordManager(boolean visible) {
    	
    	 ComThread.InitSTA(true);
    	 ComThread.startMainSTA();
    
    	  System.out.println("init!!");
    	  
    	 if (word == null) {
    	
             word = new ActiveXComponent("Word.Application");
          
             word.setProperty("Visible", new Variant(visible));//If the word file can be visible.
            
         }
    	 
         if (documents == null)
        	
             documents = word.getProperty("Documents").toDispatch();
         
	}

    
    public WordManager() {
		// TODO Auto-generated constructor stub
	}


	public void setSaveOnExit(boolean saveOnExit) {
    	
        this.saveOnExit = saveOnExit;
    }

 
    public void createNewDocument() {
    	
        doc = Dispatch.call(documents, "Add").toDispatch();
        selection = Dispatch.get(word, "Selection").toDispatch();
    }

   
    public void openDocument(String docPath) {
    	
        closeDocument();
        doc = Dispatch.call(documents, "Open", docPath).toDispatch();
       
        selection = Dispatch.get(word, "Selection").toDispatch();
    }

   
    public void moveUp(int pos) {
    	
        if (selection == null)
            selection = Dispatch.get(word, "Selection").toDispatch();
        
        for (int i = 0; i < pos; i++)
            Dispatch.call(selection, "MoveUp");

    }


    public void moveDown(int pos) {
    	
        if (selection == null)
            selection = Dispatch.get(word, "Selection").toDispatch();
        
        for (int i = 0; i < pos; i++)
            Dispatch.call(selection, "MoveDown");
    }

  
    public void moveLeft(int pos) {
    	
        if (selection == null)
            selection = Dispatch.get(word, "Selection").toDispatch();
        
        for (int i = 0; i < pos; i++) {
            Dispatch.call(selection, "MoveLeft");
        }
    }

  
    public void moveRight(int pos) {
    	
        if (selection == null)
            selection = Dispatch.get(word, "Selection").toDispatch();
        
        for (int i = 0; i < pos; i++)
            Dispatch.call(selection, "MoveRight");
    }

 
    public void moveStart() {
    	
        if (selection == null)
            selection = Dispatch.get(word, "Selection").toDispatch();
        
        Dispatch.call(selection, "HomeKey", new Variant(6));
    }

    
    public boolean find(String toFindText) {
    	
        if (toFindText == null || toFindText.equals(""))
        
        return false;
       
        Dispatch find = word.call(selection, "Find").toDispatch();
        Dispatch.put(find, "Text", toFindText);
        Dispatch.put(find, "Forward", "True");
        Dispatch.put(find, "Format", "True");
        Dispatch.put(find, "MatchCase", "True");
        Dispatch.put(find, "MatchWholeWord", "True");
     
        return Dispatch.call(find, "Execute").getBoolean();
    }

  
    public boolean replaceText(String toFindText, String newText) {
    	
        if (!find(toFindText))
        	
        return false;
        
        Dispatch.put(selection, "Text", newText);
        
        return true;
    }

  
    public void replaceAllText(String toFindText, String newText) {
    	
        while (find(toFindText)) {
        	
            Dispatch.put(selection, "Text", newText);
            Dispatch.call(selection, "MoveRight");
            
        }
    }

   
    public void insertText(String newText) {
    	
        Dispatch.put(selection, "Text", newText);
    }

   
    public boolean replaceImage(String toFindText, String imagePath) {
    	
        if (!find(toFindText))
        	
        return false;
        
        Dispatch.call(Dispatch.get(selection, "InLineShapes").toDispatch(),"AddPicture", imagePath);
        
        return true;
    }

    
    public void replaceAllImage(String toFindText, String imagePath) {
    	
        while (find(toFindText)) {
        	
            Dispatch.call(Dispatch.get(selection, "InLineShapes").toDispatch(), "AddPicture", imagePath);
            Dispatch.call(selection, "MoveRight");
        }
    }

    
    public void insertImage(String imagePath) {
    	
        Dispatch.call(Dispatch.get(selection, "InLineShapes").toDispatch(), "AddPicture", imagePath);
    }

 
    public void mergeCell(int tableIndex, int fstCellRowIdx, int fstCellColIdx,int secCellRowIdx, int secCellColIdx) {
    
        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
        Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex)).toDispatch();
        Dispatch fstCell = Dispatch.call(table, "Cell",new Variant(fstCellRowIdx), new Variant(fstCellColIdx)).toDispatch();
        Dispatch secCell = Dispatch.call(table, "Cell",new Variant(secCellRowIdx), new Variant(secCellColIdx)).toDispatch();
        Dispatch.call(fstCell, "Merge", secCell);
    }

    
    public void putTxtToCell(int tableIndex, int cellRowIdx, int cellColIdx, String txt) {
     
        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
        Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex)).toDispatch();
        Dispatch cell = Dispatch.call(table, "Cell", new Variant(cellRowIdx), new Variant(cellColIdx)).toDispatch();
        Dispatch.call(cell, "Select");
        Dispatch.put(selection, "Text", txt);
    }


    public void copy(String toCopyText) {
    	
        moveStart();
        
        if (this.find(toCopyText)) {
        	
            Dispatch textRange = Dispatch.get(selection, "Range").toDispatch();
            Dispatch.call(textRange, "Copy");
        }
    }


    public void paste(String pos) {
    	
        moveStart();
        
        if (this.find(pos)) {
        	
            Dispatch textRange = Dispatch.get(selection, "Range").toDispatch();
            Dispatch.call(textRange, "Paste");
        }
    }

 
    public void copyTable(String pos, int tableIndex) {
    	
        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
        Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex)).toDispatch();
        Dispatch range = Dispatch.get(table, "Range").toDispatch();
        Dispatch.call(range, "Copy");
        
        if (this.find(pos)) {
        	
            Dispatch textRange = Dispatch.get(selection, "Range").toDispatch();
            Dispatch.call(textRange, "Paste");
        }
    }

   
    public void copyParagraphFromAnotherDoc(String anotherDocPath, int paragraphIndex) {
    	
        Dispatch wordContent = Dispatch.get(doc, "Content").toDispatch(); 
        Dispatch.call(wordContent, "InsertAfter", "$selection$");
        copyParagraphFromAnotherDoc(anotherDocPath, paragraphIndex, "$selection$");
    }

  
    public void copyParagraphFromAnotherDoc(String anotherDocPath, int paragraphIndex, String pos) {
    	
        Dispatch doc2 = null;
        
        try {
    
            doc2 = Dispatch.call(documents, "Open", anotherDocPath) .toDispatch();
            Dispatch paragraphs = Dispatch.get(doc2, "Paragraphs").toDispatch();
            Dispatch paragraph = Dispatch.call(paragraphs, "Item", new Variant(paragraphIndex)).toDispatch();
            Dispatch range = Dispatch.get(paragraph, "Range").toDispatch();
            Dispatch.call(range, "Copy");
            
            if (this.find(pos)) {
            	
                Dispatch textRange = Dispatch.get(selection, "Range").toDispatch();
                Dispatch.call(textRange, "Paste");
            }
        	} catch (Exception e) {
        		
            e.printStackTrace();
            
        	} finally {
        		
            if (doc2 != null) {
            	
                Dispatch.call(doc2, "Close", new Variant(saveOnExit));
             //   System.out.println("havaSTA"+ComThread.haveSTA);
                doc2 = null;
               
            }
        }
    }


    public void copyTableFromAnotherDoc(String anotherDocPath, int tableIndex, String pos) {
    	
        Dispatch doc2 = null;
        try {
        	
            doc2 = Dispatch.call(documents, "Open", anotherDocPath).toDispatch();
            Dispatch tables = Dispatch.get(doc2, "Tables").toDispatch();
            Dispatch table = Dispatch.call(tables, "Item",new Variant(tableIndex)).toDispatch();
            Dispatch range = Dispatch.get(table, "Range").toDispatch();
            Dispatch.call(range, "Copy");
            
            	if (this.find(pos)) {
            	
            		Dispatch textRange = Dispatch.get(selection, "Range").toDispatch();
            		Dispatch.call(textRange, "Paste");
            	}
        	} catch (Exception e) {
        		
            e.printStackTrace();
            
        	} finally {
        		
            if (doc2 != null) {
            	
                Dispatch.call(doc2, "Close", new Variant(saveOnExit));
            
                doc2 = null;
            }
        }
    }

    public void copyImageFromAnotherDoc(String anotherDocPath, int shapeIndex, String pos) {
    	
        Dispatch doc2 = null;
        
        try {
        	
            doc2 = Dispatch.call(documents, "Open", anotherDocPath).toDispatch();
            Dispatch shapes = Dispatch.get(doc2, "InLineShapes").toDispatch();
            Dispatch shape = Dispatch.call(shapes, "Item", new Variant(shapeIndex)).toDispatch();
            Dispatch imageRange = Dispatch.get(shape, "Range").toDispatch();
            Dispatch.call(imageRange, "Copy");
            
            if (this.find(pos)) {
            	
                Dispatch textRange = Dispatch.get(selection, "Range").toDispatch();
                Dispatch.call(textRange, "Paste");
            }
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            
        } finally {
        	
            if (doc2 != null) {
            	
                Dispatch.call(doc2, "Close", new Variant(saveOnExit));
          
                doc2 = null;
            }
        }
    }

    public void createTable(String pos, int numCols, int numRows) {
    	
        if (find(pos)) {
        	
            Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
            Dispatch range = Dispatch.get(selection, "Range").toDispatch();
            Dispatch newTable = Dispatch.call(tables, "Add", range,new Variant(numRows), new Variant(numCols)).toDispatch();
            Dispatch.call(selection, "MoveRight");
        }
    }

 
    public void addTableRow(int tableIndex, int rowIndex) {
    
        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
        Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex)).toDispatch();
        Dispatch rows = Dispatch.get(table, "Rows").toDispatch();
        Dispatch row = Dispatch.call(rows, "Item", new Variant(rowIndex)).toDispatch();
        Dispatch.call(rows, "Add", new Variant(row));
    }

    public void addFirstTableRow(int tableIndex) {
    
        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
        Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex)) .toDispatch();
        Dispatch rows = Dispatch.get(table, "Rows").toDispatch();
        Dispatch row = Dispatch.get(rows, "First").toDispatch();
        Dispatch.call(rows, "Add", new Variant(row));
    }

    
    public void addLastTableRow(int tableIndex) {
 
        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
        Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex)).toDispatch();
        Dispatch rows = Dispatch.get(table, "Rows").toDispatch();
        Dispatch row = Dispatch.get(rows, "Last").toDispatch();
        Dispatch.call(rows, "Add", new Variant(row));
    }

    public void addRow(int tableIndex) {
    	
        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
        Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex)).toDispatch();
        Dispatch rows = Dispatch.get(table, "Rows").toDispatch();
        Dispatch.call(rows, "Add");
    }

 
    public void addCol(int tableIndex) {
  
        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
        Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex)) .toDispatch();
        Dispatch cols = Dispatch.get(table, "Columns").toDispatch();
        Dispatch.call(cols, "Add").toDispatch();
        Dispatch.call(cols, "AutoFit");
    }


    public void addTableCol(int tableIndex, int colIndex) {
  
        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
        Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex)).toDispatch();
        Dispatch cols = Dispatch.get(table, "Columns").toDispatch();
        System.out.println(Dispatch.get(cols, "Count"));
        Dispatch col = Dispatch.call(cols, "Item", new Variant(colIndex)).toDispatch();
        // Dispatch col = Dispatch.get(cols, "First").toDispatch();
        Dispatch.call(cols, "Add", col).toDispatch();
        Dispatch.call(cols, "AutoFit");
    }

 
    public void addFirstTableCol(int tableIndex) {
    	
        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
        Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex)).toDispatch();
        Dispatch cols = Dispatch.get(table, "Columns").toDispatch();
        Dispatch col = Dispatch.get(cols, "First").toDispatch();
        Dispatch.call(cols, "Add", col).toDispatch();
        Dispatch.call(cols, "AutoFit");
    }


    public void addLastTableCol(int tableIndex) {
    	
        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
        Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex)) .toDispatch(); 
        Dispatch cols = Dispatch.get(table, "Columns").toDispatch();
        Dispatch col = Dispatch.get(cols, "Last").toDispatch();
        Dispatch.call(cols, "Add", col).toDispatch();
        Dispatch.call(cols, "AutoFit");
    }

  
    public void autoFitTable() {
    	
        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
        int count = Dispatch.get(tables, "Count").toInt();
        
        for (int i = 0; i < count; i++) {
        	
            Dispatch table = Dispatch.call(tables, "Item", new Variant(i + 1)).toDispatch();
            Dispatch cols = Dispatch.get(table, "Columns").toDispatch();
            Dispatch.call(cols, "AutoFit");
        }
    }

   
    public void callWordMacro() {
    	
        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
        int count = Dispatch.get(tables, "Count").toInt();
        Variant vMacroName = new Variant("Normal.NewMacros.tableFit");
        Variant vParam = new Variant("param1");
        Variant para[] = new Variant[] { vMacroName };
        
        for (int i = 0; i < para.length; i++) {
        	
            Dispatch table = Dispatch.call(tables, "Item", new Variant(i + 1)).toDispatch();
            Dispatch.call(table, "Select");
            Dispatch.call(word, "Run", "tableFitContent");
        }
    }


    public void setFont(boolean bold, boolean italic, boolean underLine,String colorSize, String size, String name) {
    	
        Dispatch font = Dispatch.get(selection, "Font").toDispatch();
        Dispatch.put(font, "Name", new Variant(name));
        Dispatch.put(font, "Bold", new Variant(bold));
        Dispatch.put(font, "Italic", new Variant(italic));
        Dispatch.put(font, "Underline", new Variant(underLine));
        Dispatch.put(font, "Color", colorSize);
        Dispatch.put(font, "Size", size);
    }

 
   public void save(String savePath) {
    	
        Dispatch.call( (Dispatch) Dispatch.call(word, "WordBasic").getDispatch(),"FileSaveAs", savePath);
    }
   
 /*
    private void save(ActiveXComponent word,String outputPath){
    	  Dispatch.call(Dispatch.call(word, "WordBasic").getDispatch(), "FileSaveAs",outputPath);
    	 }

    
    public void saveDoc(String outPutDocPath){
    	 
    	//  ComThread.InitSTA();
    	
    	  this.save(word,outPutDocPath);
    	  this.close1(documents);
    	  word.invoke("Quit", new Variant[0]);
    	 
    	  ComThread.Release();
    	 }
     */
   public void closeDocument() {
    	
        if (doc != null) {
        	
            Dispatch.call(doc, "Save");
            Dispatch.call(doc, "Close", new Variant(saveOnExit));
      
            doc = null;      
        }
        
       
    }

    private void close1(Dispatch doc){
    	
    	  Dispatch.call(doc, "Close",new Variant(true));
    }
  
    public void close() {
    	
        closeDocument();
       
        if (word != null) {
        	
            Dispatch.call(word, "Quit");
          
            word = null;
            
        }
        
        selection = null;
        documents = null;
        WordManager.uniqueWordManager=null;
           
        ComThread.Release();
		ComThread.quitMainSTA();
        System.out.println("release!!");
			
	}

    public void printFile() {
    	
        if (doc != null) {
        	
            Dispatch.call(doc, "PrintOut");
        }
    }
}