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
    public void returnBook(String selectedBookName, String selectedMemberName, String returnDate, int diff){
            MongoClient mongoClient = new MongoClient("192.168.1.11", 27017);
            //defines the ipaddress and port to use to connect
            DB db = mongoClient.getDB("Library");
            //defines the database to use
            DBCollection collection = db.getCollection("Orders");
            //defines the collection to use
            
            DBCursor cursor = collection.find(
            new BasicDBObject(), new BasicDBObject("BookName", Boolean.TRUE)
            );
        
            DBCursor cursor2 = collection.find(
            new BasicDBObject(), new BasicDBObject("MemberName", Boolean.TRUE)
            );
            //uses a cursor to search the collection for all values in the BookName field
            DBCursor cursor3 = collection.find(
            new BasicDBObject(), new BasicDBObject("_id", Boolean.TRUE)
            );
            //uses a cursor to search the collection for all values in the BookName field
            String id = "0";
            
            while (cursor.hasNext()) {

                String a = cursor.next().get("BookName").toString();
                String b = cursor2.next().get("MemberName").toString();
                String c = cursor3.next().get("_id").toString();
                
                if(a.equals(selectedBookName) && b.equals(selectedMemberName)){
                    id = c;
                }
                
            }
            
            collection = db.getCollection("Invoices");
            cursor = collection.find(
            new BasicDBObject(), new BasicDBObject("OrderID", Boolean.TRUE)
            );
            while (cursor.hasNext()) {
                String d = cursor.next().get("OrderID").toString();
                if(id.equals(d)){
                    BasicDBObject newDocument = new BasicDBObject();
                    BasicDBObject searchQuery = new BasicDBObject().append("OrderID", id);
                    
                    newDocument.append("$set", new BasicDBObject().append("PaidDate", returnDate));
                    collection.update(searchQuery, newDocument);
                    
                    newDocument.append("$set", new BasicDBObject().append("AmmountPaid", diff));
                    collection.update(searchQuery, newDocument);
                    
                }
                
            }
            
            
    }
}
