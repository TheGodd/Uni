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
public class addMember {
    public static void addmember(){
        try{
        MongoClient mongoClient = new MongoClient("192.168.1.11", 27017);
        DB db = mongoClient.getDB("Library");
        DBCollection collection = db.getCollection("Members");
      
        String address1 = "'25 Egerton Road'";
        String city = "'Bristol'";
        String postcode = "'BS7 8PL'";
        String email = "'jacksonjames@funkymail.com'";
        String firstname = "'Jackson'";
        String secondname = "'James'";
        
        String json = "{'First_Name' : " + firstname + ","
                + "'Second_Name' : " + secondname + ","
                + "'Email' : " + email + ","
                + "'Phone_Number' : '02749263748',"
                + "'Address' : {'addressLine1' : " + address1 +"," +
                               "'City' : " + city + "," +
                               "Postcode' : " + postcode + "}" + "}";
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
