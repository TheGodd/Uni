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

/**
 *
 * @author golde
 */
public class ReturnBook {
    public void returnBook(String selectedBookName, String selectedMemberName, String returnDate){
             MongoClient mongoClient = new MongoClient("192.168.1.11", 27017);
            //defines the ipaddress and port to use to connect
            DB db = mongoClient.getDB("Library");
            //defines the database to use
            DBCollection collection = db.getCollection("Orders");
            //defines the collection to use
            
            DBCursor cursor = collection.find(
            new BasicDBObject(), new BasicDBObject("MemberName", Boolean.TRUE)
            );
        
            DBCursor cursor2 = collection.find(
            new BasicDBObject(), new BasicDBObject("BookName", Boolean.TRUE)
            );
            //uses a cursor to search the collection for all values in the BookName field
            DBCursor cursor3 = collection.find(
            new BasicDBObject(), new BasicDBObject("_id", Boolean.TRUE)
            );
            //uses a cursor to search the collection for all values in the BookName field
            
    }
}
