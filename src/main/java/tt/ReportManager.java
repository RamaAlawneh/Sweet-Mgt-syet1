package tt;


import tt.Tproduct;
import tt.Torder;
import java.util.*;

public class ReportManager {
    private Map<String, List<Torder>> storeOrders = new HashMap<>();
    private Map<String, List<Tproduct>> storeProducts = new HashMap<>();

    // Adding data to the report manager
    public void addOrder(String storeName, Torder order) {
        storeOrders.computeIfAbsent(storeName, k -> new ArrayList<>()).add(order);
    }

    public void addProduct(String storeName, Tproduct product) {
        storeProducts.computeIfAbsent(storeName, k -> new ArrayList<>()).add(product);
    }


    // Getting financial reports
    public double getTotalProfit(String storeName) {
        return storeOrders.getOrDefault(storeName, Collections.emptyList())
                .stream()
                .mapToDouble(Torder::getTotal)
                .sum();
    }

    public List<Tproduct> getBestSellingProducts(String storeName) {
        // Example logic: Return all products for simplicity
        return storeProducts.getOrDefault(storeName, Collections.emptyList());
    }

    public List<Torder> getOrders(String storeName) {
        return storeOrders.getOrDefault(storeName, Collections.emptyList());
    }

    public List<Tproduct> getProducts(String storeName) {
        return storeProducts.getOrDefault(storeName, Collections.emptyList());
    }
}