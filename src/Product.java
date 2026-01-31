public class Product {

    public int id;
    public String name;
    public double price;
    public double rating;

    public Product(int id, String name, double price, double rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | ₹" + price + " | rating=" + rating;
    }
}
