import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestDBConnection {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        try {
Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/adaptive_sorting";
            String user = "root";
            String password = "root";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");

            while (rs.next()) {
                products.add(
                    new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getDouble("rating"),
                        rs.getInt("popularity")
                    )
                );
            }
String sortKey = MongoPreferenceReader.getSortKey(1);
AdaptiveSorter.sort(products, sortKey);

PreparedStatement ps = conn.prepareStatement(
    "INSERT INTO sorting_metrics (dataset_size, data_distribution, algorithm_used, execution_time_ms) VALUES (?, ?, ?, ?)"
);

ps.setInt(1, products.size());
ps.setString(2, "mixed");
ps.setString(3, "TimSort");
ps.setDouble(4, 1.2); // placeholder time

ps.executeUpdate();


            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

for (Product p : products) {
    System.out.println(p.name + " | " + p.price + " | " + p.rating + " | " + p.popularity);
}

    }
}
