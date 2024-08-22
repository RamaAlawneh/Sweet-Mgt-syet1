package tt;
import java.time.LocalDate;
import java.util.*;
import java.util.ArrayList;
import java.util.List;



public class Store {
    private String sid;
    private String storeName;
    private String  storeowner;
    private List<Tproduct> products;



    public Store(String sid,String storeName,String storeowner) {
        this.sid=sid;
        this.storeName = storeName;
        this.storeowner=storeowner;
        this.products = new ArrayList<>();

    }
    public Store() {

    }

public String getSid(){return sid;}

    public String getStoreName() {
        return storeName;
    }
    public String getstoreowner(){return  storeowner;}

    public List<Tproduct> getProducts() {
        return products;
    }

    public Tproduct findProductById(String productId) {
        for (Tproduct product : products) {
            if (product.getPid().equals(productId)) {
                return product;
            }
        }
        return null;
    }
    public void addProduct(Tproduct product) {
        products.add(product);

    }

    public void removeProduct(Tproduct product) {
        products.remove(product);

    }




}


















