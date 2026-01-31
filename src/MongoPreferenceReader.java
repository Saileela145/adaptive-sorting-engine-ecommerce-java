import com.mongodb.client.*;
import org.bson.Document;

public class MongoPreferenceReader {

    public static String getSortKey(int userId) {

        MongoClient client = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase db = client.getDatabase("adaptive_sorting");
        MongoCollection<Document> col = db.getCollection("user_behavior");

        Document doc = col.find(new Document("userId", userId)).first();
        client.close();

        if (doc == null) return "price";
        return doc.getString("lastSort");
    }
}
