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
            
            DBCursor cursBookName = collection.find(
            new BasicDBObject(), new BasicDBObject("BookName", Boolean.TRUE)
            );
            //uses a cursor to search the collection for all values in the BookName field
            DBCursor cursMemName = collection.find(
            new BasicDBObject(), new BasicDBObject("MemberName", Boolean.TRUE)
            );
            //uses a cursor to search the collection for all values in the MemberName field
            DBCursor cursID = collection.find(
            new BasicDBObject(), new BasicDBObject("_id", Boolean.TRUE)
            );
            //uses a cursor to search the collection for all values in the BookName field
            String id = "0";
            //makes string id and sets it equal to 0
            
            while (cursBookName.hasNext()) {
            //while cursBookName has the next value in the database do this
                String bookNameField = cursBookName.next().get("BookName").toString();
                //creates string bookNameField and makes it equal to the field BookName
                String memNameField = cursMemName.next().get("MemberName").toString();
                //creates string memNameField and makes it equal to the field MemberName
                String idField = cursID.next().get("_id").toString();
                //creates string cursID and makes it equal to the field _id
                
                if(bookNameField.equals(selectedBookName) && memNameField.equals(selectedMemberName)){
                //if bookNameField is equal to selectedBookName and memNameField is equal to selectedMemberName
                    id = idField;
                    //makes id equal to idField
                }
            }
            collection = db.getCollection("Invoices");
            //makes collection its looking at be Invoices
            cursBookName = collection.find(
            new BasicDBObject(), new BasicDBObject("OrderID", Boolean.TRUE)
            );
            //uses a cursor to search the collection for all values in the BookName field
            while (cursBookName.hasNext()) {
            //while cursBookName has the next value in the database do this
                String orderIdField = cursBookName.next().get("OrderID").toString();
                //creates String orderIdField and makes it equal to the OrderId Field
                if(id.equals(orderIdField)){
                //if id is equal to orderIdField then do this
                    BasicDBObject newDocument = new BasicDBObject();
                    BasicDBObject searchQuery = new BasicDBObject().append("OrderID", id);
                    //Search for rhe document with the OrderID with the value id
                    
                    newDocument.append("$set", new BasicDBObject().append("PaidDate", returnDate));
                    collection.update(searchQuery, newDocument);
                    //change the found document to have a PaidDate of returnDate
                    
                    newDocument.append("$set", new BasicDBObject().append("AmmountPaid", diff));
                    collection.update(searchQuery, newDocument);
                    //change the found document to have the AmmountPaid of diff
                }
                
            }
            
            
    }
}