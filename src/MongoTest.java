import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoTest {
    public static void main(String[] args) {

        MongoClient client = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase db = client.getDatabase("adaptive_sorting");
        MongoCollection<Document> col = db.getCollection("user_behavior");

        Document doc = new Document("userId", 1)
                .append("lastSort", "price")
                .append("clicks", 5);

        col.insertOne(doc);
        System.out.println("Inserted user behavior into MongoDB");

        client.close();
    }
}

