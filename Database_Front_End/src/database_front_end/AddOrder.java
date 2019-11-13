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
public class AddOrder {
    public static void addOrder(){
     try{
        MongoClient mongoClient = new MongoClient("192.168.1.11", 27017);
        DB db = mongoClient.getDB("Library");
        DBCollection collection = db.getCollection("Orders");
      
        String BookID = "'5dca9cfd49245f51503d2d7c'";
        String MemberID = "'5dca8dea49245f1d9817cc88'";
        String Date_Taken = "'12.11.2019'";
        String Date_Due = "'13.11.2019'";
        
        
        String json = "{'BookID' : " + BookID + ","
                + "'MemberID' : " + MemberID + ","
                + "'Date_Taken' : " + Date_Taken + ","
                + "'Date_Due' : "+ Date_Due + "}";
        
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
