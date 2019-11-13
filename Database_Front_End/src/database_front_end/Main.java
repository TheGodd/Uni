
package database_front_end;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        try{
        MongoClient mongoClient = new MongoClient("192.168.1.11", 27017);
        DB db = mongoClient.getDB("Library");
        DBCollection collection = db.getCollection("Members");
      
        DBCursor cursor = collection.find();
	while(cursor.hasNext()) {
	    System.out.println(cursor.next());
	}
        
        System.out.println("connected to database");
        }
        catch(Exception e){
        System.out.println(e);
        }
        System.out.println("Server is ready");
        }
}