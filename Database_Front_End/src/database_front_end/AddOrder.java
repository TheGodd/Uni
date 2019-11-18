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
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

/**
 *
 * @author golde
 */
public class AddOrder {
    public static void addOrder(String bookName, String author, String catagory, String memName, String dateTaken, String dateDue){
     try{
         String y;
         int xy;
         int x = 0;
        MongoClient mongoClient = new MongoClient("192.168.1.11", 27017);
        //defines the ipaddress and the port to be used to connect
        DB db = mongoClient.getDB("Library");
        //selects the database to be used
        DBCollection collection = db.getCollection("Orders");
        //chooses the collection to be used
        DBCursor cursor = collection.find(
        new BasicDBObject(), new BasicDBObject("_id", Boolean.TRUE)
         );
        //uses a cursor to search the collection for all values in the catagory field
        while (cursor.hasNext()) {
            y = cursor.next().get("_id").toString();
            xy = Integer.parseInt(y);
            if(xy > x){
                x = xy;
                
            }
        }
        //while loop that is used to find the highest ID number
        x++;
        int ID = x;
        //ID is generated using the highest current ID and adding one to it
               
        String json = "{'_id' : " + "'" + ID + "'" + ","
                + "'BookName' : " + "'" + bookName + "'" + ","
                + "'Author' : " + "'" + author + "'" + ","
                + "'Catagory' : " + "'" + catagory + "'" + ","
                + "'MemberName' : " + "'" + memName + "'" + ","
                + "'DateTaken' : " + "'" + dateTaken + "'" + ","
                + "'DateDue' : "+ "'" + dateDue + "'" + "}";
        //makes string called json and makes it equal to json format insertion
        
        DBObject dbOBject = (DBObject)JSON.parse(json);
        collection.insert(dbOBject);
        //turns string json into a database object and inserts it as a document in collection
        
        collection = db.getCollection("Invoices");
        
        json = "{'OrderID' : " + "'" + ID + "'" + ","
                + "'ReceivedDate' : " + "'" + dateTaken + "'" + ","
                + "'PaidDate' : " + "' '" + "}";
        //makes string called json and makes it equal to json format insertion
        
        dbOBject = (DBObject)JSON.parse(json);
        collection.insert(dbOBject);
        //turns string json into a database object and inserts it as a document in collection
        
        System.out.println("connected to database");
        }
        catch(Exception e){
        System.out.println(e);
        }
        System.out.println("Server is ready");
    }
}
