package tt;

import java.time.LocalDateTime;
import java.util.List;


public class Torder {
    private String oid;  // Unique order ID
    private String userEmail;  // Email of the user placing the order
    private LocalDateTime orderTime;  // The time the order was placed
    //private String description;  // Description or status of the order
    private double total;  // Total price of the order
    private List<Tproduct> products;  // List of products in the order

    // Constructor that initializes the order with the user's email and captures the current time
    public Torder(String oid, String userEmail, List<Tproduct> products) {
        this.oid = oid;
        this.userEmail = userEmail;  // Capture the user's email
        this.orderTime = LocalDateTime.now();  // Capture the current time
     //  this.description = description;
        this.products = products;
        this.total = calculateTotal(products); // Calculate total based on the products list
    }

    // Method to calculate the total price of the order
    private double calculateTotal(List<Tproduct> products) {
        double total = 0;
        for (Tproduct product : products) {
            total += product.getprice() * product.getquantity();
        }
        return total;
    }

    // Getters
    public String getOid() { return oid; }
    public String getUserEmail() { return userEmail; }
    public LocalDateTime getOrderTime() { return orderTime; }
   // public String getDescription() { return description; }
    public double getTotal() { return total; }
    public List<Tproduct> getProducts() { return products; }

    // Setters
   // public void setDescription(String description) { this.description = description; }

    // Adding and removing products
    public void addProduct(Tproduct product) {
        this.products.add(product);
        this.total = calculateTotal(this.products);
    }

    public void removeProduct(Tproduct product) {
        this.products.remove(product);
        this.total = calculateTotal(this.products);
    }

    @Override
    public String toString() {
        StringBuilder productDetails = new StringBuilder();
        for (Tproduct product : products) {
            productDetails.append(String.format("Product ID: %s, Name: %s, Quantity: %d, Price: %.2f\n",
                    product.getPid(), product.getproductName(), product.getquantity(), product.getprice()));
        }

        return String.format("Order ID: %s\nUser Email: %s\nOrder Time: %s\nTotal: %.2f\nProducts:\n%s",
                oid, userEmail, orderTime, total, productDetails.toString());
    }
}
