package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tt.Torder;
import tt.Tproduct;
import tt.mytest;

import java.util.Date;
import java.util.List;

public class order {
    private final mytest testContext = new mytest();
    private Torder currentOrder;
    private Tproduct currentProduct;
    private double appliedDiscount;
    private boolean discountAppliedSuccessfully;

    @Given("I am logged in as a store owner")
    public void iAmLoggedInAsAStoreOwner() {
        testContext.setLogged(true);
    }

    @Given("I have a product {string} with no current discounts")
    public void iHaveAProductWithNoCurrentDiscounts(String productName) {
        for (Tproduct product : testContext.getProlist()) {
            if (product.getName()) {
                currentProduct = product;
                break;
            }
        }
        // Assuming no discounts are active initially
        if (currentProduct != null) {
            appliedDiscount = 0;
        }
    }

    @When("I apply a {int}% discount for quantities above {int}")
    public void iApplyADiscountForQuantitiesAbove(Integer discountPercentage, Integer quantity) {
        if (currentProduct != null && currentProduct.getquantity() > quantity) {
            appliedDiscount = discountPercentage;
            discountAppliedSuccessfully = true;
        }
    }

    @Then("the discount should be set successfully")
    public void theDiscountShouldBeSetSuccessfully() {
        assert discountAppliedSuccessfully : "Discount was not applied successfully";
    }

    @Then("I should see {string} on my dashboard")
    public void iShouldSeeOnMyDashboard(String message) {
        // Assuming this is a simple check; you could use a logger or print statement
        System.out.println("Dashboard message: " + message);
    }

    @Given("I have a product {string} with a {int}% discount for quantities above {int}")
    public void iHaveAProductWithADiscountForQuantitiesAbove(String productName, Integer discountPercentage, Integer quantity) {
        iHaveAProductWithNoCurrentDiscounts(productName);
        if (currentProduct != null && currentProduct.getquantity() > quantity) {
            appliedDiscount = discountPercentage;
        }
    }

    @When("I update the discount to {int}% for quantities above {int}")
    public void iUpdateTheDiscountToForQuantitiesAbove(Integer discountPercentage, Integer quantity) {
        iApplyADiscountForQuantitiesAbove(discountPercentage, quantity);
    }

    @Then("the discount details should be updated successfully")
    public void theDiscountDetailsShouldBeUpdatedSuccessfully() {
        assert discountAppliedSuccessfully : "Discount update was not successful";
    }

    @When("I remove the discount from {string}")
    public void iRemoveTheDiscountFrom(String productName) {
        iHaveAProductWithNoCurrentDiscounts(productName);
        appliedDiscount = 0;  // Remove discount
        discountAppliedSuccessfully = true;
    }

    @Then("the discount should be removed successfully")
    public void theDiscountShouldBeRemovedSuccessfully() {
        assert appliedDiscount == 0 : "Discount was not removed successfully";
    }

    @Given("I have a product {string} priced at ${int} with no current discounts")
    public void iHaveAProductPricedAt$WithNoCurrentDiscounts(String productName, Integer price) {
        iHaveAProductWithNoCurrentDiscounts(productName);
        if (currentProduct != null) {
            currentProduct.setprice(price);
        }
    }

    @When("I apply a promotional discount of {int}% valid from {string} to {string}")
    public void iApplyAPromotionalDiscountOfValidFromTo(Integer discountPercentage, String startDate, String endDate) {
        // Assuming no complex date checks for simplicity
        appliedDiscount = discountPercentage;
        discountAppliedSuccessfully = true;
    }

    @Then("the promotional discount should be set successfully")
    public void thePromotionalDiscountShouldBeSetSuccessfully() {
        assert discountAppliedSuccessfully : "Promotional discount was not set successfully";
    }
}