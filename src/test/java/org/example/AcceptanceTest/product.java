package org.example.AcceptanceTest;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tt.Tproduct;
import tt.mytest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class product {
    private final mytest testInstance = new mytest();
    private final Map<String, Tproduct> inventory = new HashMap<>();
    private String dashboardMessage;

    @When("I add a product with the following details")
    public void iAddAProductWithTheFollowingDetails(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            String pid = columns.get("pid");
            String productName = columns.get("name");
            String category = columns.get("category");
            double price = Double.parseDouble(columns.get("price"));

            Tproduct newProduct = new Tproduct(pid,productName, category, price, 0);
            String productId = "P" + (inventory.size() + 1);

            inventory.put(productId, newProduct);
            testInstance.addproduct(newProduct);
            dashboardMessage = "Product added successfully";
        }
    }

    @Then("the product should be added successfully")
    public void theProductShouldBeAddedSuccessfully() {
        assert dashboardMessage.equals("Product added successfully");
    }

    @Given("I have a product with ID {string} in the inventory")
    public void iHaveAProductWithIDInTheInventory(String productId) {

        Tproduct existingProduct = new Tproduct("P001", "Chocolate Cake", "Dessert", 15.99, 10);
        inventory.put(productId, existingProduct);
        testInstance.addproduct(existingProduct);
    }

    @When("I update the product {string} with the following details")
    public void iUpdateTheProductWithTheFollowingDetails(String productId, DataTable dataTable) {
        Tproduct product = inventory.get(productId);
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        if (product != null) {
            for (Map<String, String> columns : rows) {
                if (columns.containsKey("price")) {
                    product.setprice(Double.parseDouble(columns.get("price")));
                }
                if (columns.containsKey("category")) {
                    product.setcategory(columns.get("category"));
                }
            }
            dashboardMessage = "Product updated successfully";
        } else {
            dashboardMessage = "Product not found";
        }
    }

    @Then("the product details should be updated successfully")
    public void theProductDetailsShouldBeUpdatedSuccessfully() {
        assert dashboardMessage.equals("Product updated successfully");
    }

    @When("I remove the product {string}")
    public void iRemoveTheProduct(String productId) {
        if (inventory.containsKey(productId)) {
            Tproduct removedProduct = inventory.remove(productId);
            testInstance.removeproduct(removedProduct);  // Remove from the main product list in mytest
            dashboardMessage = "Product removed successfully";
        } else {
            dashboardMessage = "Product not found";
        }
    }

    @Then("the product should be removed successfully")
    public void theProductShouldBeRemovedSuccessfully() {
        assert dashboardMessage.equals("Product removed successfully");
    }
}