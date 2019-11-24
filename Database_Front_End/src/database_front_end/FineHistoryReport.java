/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_front_end;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author golde
 */
public class FineHistoryReport {
    public void fineHistoryReport(String memName, String month){
    
    }
    public void WriteFile(){
        try{
            // Create new file
            String content = "This is the content to write into create file with delete";
            String path="C:\\Users\\golde\\Desktop\\Uni\\Uni\\Reports\\FineHistory\\Report.txt";
            File file = new File(path);

            // If file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }else if(file.exists()){
                file.delete();
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            // Write in file
            bw.write(content);

            // Close connection
            bw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    
    }
    
}
