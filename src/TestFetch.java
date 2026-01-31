import java.util.*;

public class TestFetch {

    public static void main(String[] args) {

        int userId = 1; // demo user

        List<Product> products = ProductRepository.fetchProducts();

        System.out.println("=== BEFORE SORT ===");
        for (Product p : products) System.out.println(p);

        String sortKey = MongoPreferenceReader.getSortKey(userId);
        System.out.println("\nSort preference from MongoDB: " + sortKey);

        AdaptiveSorter.sort(products, sortKey);

        System.out.println("\n=== AFTER SORT (" + sortKey + ") ===");
        for (Product p : products) System.out.println(p);
    }
}
