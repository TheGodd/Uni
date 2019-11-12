
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
public class Database_Front_End {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        addBook add = new addBook();
        add.addbook();
        }
}