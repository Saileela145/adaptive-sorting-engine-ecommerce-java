import java.sql.*;
import java.util.*;

public class ProductRepository {

    public static List<Product> fetchProducts() {
        List<Product> products = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/adaptive_sorting";
        String user = "root";
        String pass = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                "SELECT product_id, name, price, rating FROM products LIMIT 10"
            );

            while (rs.next()) {
                products.add(
                    new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getDouble("rating")
                    )
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }
}
