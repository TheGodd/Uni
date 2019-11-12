/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_front_end;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

/**
 *
 * @author golde
 */
public class addBook {
    public static void addbook(){
    try{
        MongoClient mongoClient = new MongoClient("192.168.1.11", 27017);
        DB db = mongoClient.getDB("Library");
        DBCollection collection = db.getCollection("Books");
      
        String bookName = "'Treasure Island'";
        String catagoryID = "'5dca9b6949245f1bbcc79ff8'";
        String Auther = "'Robert Louis Stevenson'";
        
        
        String json = "{'Book_Name' : " + bookName + ","
                + "'Auther' : " + Auther + ","
                + "'Catagory_ID' : " + catagoryID + "}";
        DBObject dbOBject = (DBObject)JSON.parse(json);
        collection.insert(dbOBject);
        
        
        System.out.println("connected to database");
        }
        catch(Exception e){
        System.out.println(e);
        }
        System.out.println("Server is ready");
    }
}
