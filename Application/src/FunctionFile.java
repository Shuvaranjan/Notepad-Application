import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
/*
 * Author- Shuvaranjan Sarkar
 */
public class FunctionFile{
    Gui gui;
    String fileName;
    String fileAddress;
    public FunctionFile(Gui gui){
        this.gui = gui;

    }
    
    // finctions to create a New File
    // whenever some one click on the new items
    public void newFile(){
        gui.textArea.setText(null);// erase the current text
        gui.window.setTitle("New"); // set the default new name of the new File

    }

    // funtion to open existing file
    public void newOpen(){
        // to display dialog file
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        //logic to open Any files
        if (fd.getFile()!=null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            // System.out.println(fileName + fileAddress);
            gui.window.setTitle(fileName);
            
        }

        // display the content of this file
        //using buffer-reader
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
            gui.textArea.setText("");

            String line = null;
            while ((line = br.readLine()) != null) {
                gui.textArea.append(line + "\n");
                
            }

            br.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    // funtion save
    public void newSave(){
if (fileName==null) {
    saveAs();
    
}else{
    
    try {
        FileWriter fw = new FileWriter(fileAddress + fileName);
        fw.write(gui.textArea.getText());
        gui.window.setTitle(fileName);
        fw.close();
      

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    }

    // funtion save as
    public void saveAs(){

        
        FileDialog fd = new FileDialog(gui.window,"Save As", FileDialog.SAVE);
        fd.setVisible(true);
        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
            
        }

        try {
            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(gui.textArea.getText());
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//Print Operation
    public void Print(){
        try {
          
            gui.textArea.print();
            
        } catch (PrinterException e) {
            
            e.printStackTrace();
        }
    }
    //exit operation
    public void exit(){
        System.exit(0);
    }
}
