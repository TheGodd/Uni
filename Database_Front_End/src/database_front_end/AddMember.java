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
public class AddMember {
    public static void addMember(String firstname, String secondname, String address1,
            String city, String postcode, String email){
        try{
        MongoClient mongoClient = new MongoClient("192.168.1.11", 27017);
        //defines the ipaddress and the port to be used to connect
        DB db = mongoClient.getDB("Library");
        //selects the database to be used
        DBCollection collection = db.getCollection("Members");
        //chooses the collection to be used
        
        String json = "{'First_Name' : " + "'" + firstname + "'" + ","
                + "'Second_Name' : " + "'" + secondname + "'" + ","
                + "'Email' : " + "'" + email + "'" + ","
                + "'Phone_Number' : '02749263748',"
                + "'Address' : {'addressLine1' : " + "'" + address1 + "'" +"," +
                               "'City' : " + "'" + city + "'" + "," +
                               "Postcode' : " + "'" + postcode + "'" + "}" + "}";
        //makes string called json and makes it equal to json format insertion
        DBObject dbOBject = (DBObject)JSON.parse(json);
        collection.insert(dbOBject);
        //turns string json into a database object and inserts it as a document in collection

        }
        catch(Exception e){
        System.out.println(e);
        }
}
}
