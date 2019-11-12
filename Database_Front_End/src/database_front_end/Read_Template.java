/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_front_end;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;


/**
 *
 * @author golde
 */
public class Read_Template {
    public static void Read(String args){
    try{
        MongoClient mongoClient = new MongoClient("192.168.1.11", 27017);
        DB db = mongoClient.getDB("Library");
        DBCollection collection = db.getCollection("Members");
      
        DBCursor cursor = collection.find();
        
        while(cursor.hasNext()){
            int i=1;
            System.out.println(cursor.next());
            i++;
        }
        }
        catch(Exception e){
        System.out.println(e);
        }
        System.out.println("Server is ready");
    }
}
