/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_front_end;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author golde
 */
public class LoanHistoryReport {
    public void loanHistoryReport(String memName, String month) throws IOException{
        
        try{
        ArrayList<String[]> historyList = new ArrayList<String[]>();
        //creates an array list called historyList

        MongoClient mongoClient = new MongoClient("192.168.1.11", 27017);
        //defines the ipaddress and port to use to connect
        DB db = mongoClient.getDB("Library");
        //defines the database to use
        DBCollection collection = db.getCollection("Orders");
        //defines the collection to use
        DBCursor cursMemName = collection.find(
        new BasicDBObject(), new BasicDBObject("MemberName", Boolean.TRUE)
        );
        //uses a cursor to search the collection for all values in the MemberName field
        DBCursor cursBookName = collection.find(
        new BasicDBObject(), new BasicDBObject("BookName", Boolean.TRUE)
        );
        //uses a cursor to search the collection for all values in the BookName field
        DBCursor cursDateDue = collection.find(
        new BasicDBObject(), new BasicDBObject("DateDue", Boolean.TRUE)
        );
        //uses a cursor to search the collection for all values in the DateDue field
        DBCursor cursDateTaken = collection.find(
        new BasicDBObject(), new BasicDBObject("DateTaken", Boolean.TRUE)
        );
        //uses a cursor to search the collection for all values in the DateTaken field
        
        while (cursMemName.hasNext()) {
            //while cursMemName has the next value in the database do this
            String dateDueField = cursDateDue.next().get("DateDue").toString();
            //sets date equal to the current value of DueDate field
            String dateTakenField = cursDateTaken.next().get("DateTaken").toString();
            //sets date equal to the current value of DueDate field
            String memNameField = cursMemName.next().get("MemberName").toString();
            //creates string memNameField and make it equal to the current value in the MemberName field
            String bookNameField = cursBookName.next().get("BookName").toString();
            //creates string bookNameField and makes it equal to the current value in the Bookname field
            if(memName.equals(memNameField)){
            //if memNameField is equal to the member name selected then
            String date=dateTakenField;
            date = date.substring(date.indexOf("/") + 1);
            date = date.substring(0, date.indexOf("/"));
            //creates string date and makes it equal to a substring of dateTakenField that is the number of the month
            
            if(date.equals("1")||date.equals("01")&& month.equals("January")){historyList.add(new String[]{dateTakenField, dateDueField, bookNameField});}
            if(date.equals("2")||date.equals("02")&& month.equals("February")){historyList.add(new String[]{dateTakenField, dateDueField, bookNameField});}
            if(date.equals("3")||date.equals("03")&& month.equals("March")){historyList.add(new String[]{dateTakenField, dateDueField, bookNameField});}
            if(date.equals("4")||date.equals("04")&& month.equals("April")){historyList.add(new String[]{dateTakenField, dateDueField, bookNameField});}
            if(date.equals("5")||date.equals("05")&& month.equals("May")){historyList.add(new String[]{dateTakenField, dateDueField, bookNameField});}
            if(date.equals("6")||date.equals("06")&& month.equals("June")){historyList.add(new String[]{dateTakenField, dateDueField, bookNameField});}
            if(date.equals("7")||date.equals("07")&& month.equals("July")){historyList.add(new String[]{dateTakenField, dateDueField, bookNameField});}
            if(date.equals("8")||date.equals("08")&& month.equals("August")){historyList.add(new String[]{dateTakenField, dateDueField, bookNameField});}
            if(date.equals("9")||date.equals("09")&& month.equals("September")){historyList.add(new String[]{dateTakenField, dateDueField, bookNameField});}
            if(date.equals("10")&& month.equals("October")){historyList.add(new String[]{dateTakenField, dateDueField, bookNameField});}
            if(date.equals("11")&& month.equals("November")){historyList.add(new String[]{dateTakenField, dateDueField, bookNameField});}
            if(date.equals("12")&& month.equals("December")){historyList.add(new String[]{dateTakenField, dateDueField, bookNameField});}
            //if statements that determine which month has been selected and the month that the transaction took place is the same
            }
        }
        
        FileWriter writer = new FileWriter("LoanHistoryReport.txt");
        //creates a file writer that generates 
        writer.write(" "+month+System.lineSeparator()+" Date Taken  Date Due    Book Name"+System.lineSeparator());
        //writes the titles for the file to format it into a report
        for(int i =0; i < historyList.size(); i++){
            String line = Arrays.toString(historyList.get(i));
            writer.write(line + System.lineSeparator());
        }
        //for loop that writes rows from the arraylist historyList to a text document
        writer.close();
        //closes the writer saving the file
        ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "LoanHistoryReport.txt");
        pb.start();
        //opens the generated text file in notepad
        }
        catch(Exception e){
        System.out.println(e);
        }

    }
}
