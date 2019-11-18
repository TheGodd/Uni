
package database_front_end;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
//import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.util.JSON;
import java.util.ArrayList;
import java.util.List;
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
            String y;
            int xy;
            int x = 0;
            //List<Integer> x = new ArrayList<Integer>();
             MongoClient mongoClient = new MongoClient("192.168.1.11", 27017);
        //defines the ipaddress and the port to be used to connect
        DB db = mongoClient.getDB("Library");
        //selects the database to be used
        DBCollection collection = db.getCollection("Orders");
        
        DBCursor cursor = collection.find(
        new BasicDBObject(), new BasicDBObject("_id", Boolean.TRUE)
         );
        //uses a cursor to search the collection for all values in the catagory field
        while (cursor.hasNext()) {
            y = cursor.next().get("_id").toString();
            xy = Integer.parseInt(y);
            //x.add(xy);
            //System.out.println(x);
            
            if(xy > x){
                x = xy;
            }
        }
        System.out.println(x);
        //while loop that runs until it has all the values in the catagory field
                    
        System.out.println("connected to database");
        }
        catch(Exception e){
        System.out.println(e);
        }
        System.out.println("Server is ready");
        }
}