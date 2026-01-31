import java.util.*;

public class AdaptiveSorter {

    public static void sort(List<Product> products, String sortKey) {

        if (sortKey.equalsIgnoreCase("price")) {
            products.sort(Comparator.comparingDouble(p -> p.price));
        }
        else if (sortKey.equalsIgnoreCase("rating")) {
            products.sort((a, b) -> Double.compare(b.rating, a.rating));
        }
        else {
            System.out.println("Unknown sort key: " + sortKey);
        }
    }
}

