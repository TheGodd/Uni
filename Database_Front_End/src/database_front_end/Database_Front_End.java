
package database_front_end;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
//import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.util.JSON;
//import org.bson.Document;
/**
 *
 * @author george
 */
public class Database_Front_End {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        try{
        MongoClient mongoClient = new MongoClient("192.168.1.11", 27017);
        DB db = mongoClient.getDB("Library");
        DBCollection collection = db.getCollection("Members");
      
        String address1 = "'23 Egerton Road'";
        String city = "'Bristol'";
        String postcode = "'BS7 8HN'";
        String email = "'jasonjones@funkymail.com'";
        String firstname = "'Jason'";
        String secondname = "'Jones'";
        
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

