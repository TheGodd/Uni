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
public class AddInvoice {
    public static void addInvoice(String orderID, String receivedDate, String paidDate){
    try{
        MongoClient mongoClient = new MongoClient("192.168.1.11", 27017);
        DB db = mongoClient.getDB("Library");
        DBCollection collection = db.getCollection("Invoices");
        
        String json = "{'OrderID' : " + "'" + orderID + "'" + ","
                + "'Reveived_Date' : " + "'" + receivedDate + "'" + ","
                + "'Paid_date' : " + "'" + paidDate + "'" +  "}";
        
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
