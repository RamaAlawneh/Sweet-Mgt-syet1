package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tt.mytest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class exploration {
    public mytest obj;

    public exploration(mytest iobj) {
        super();
        this.obj = iobj;
    }

    @Given("I am a registered user and logged in")
    public void iAmARegisteredUserAndLoggedIn() {
        obj.setLogged(true);  // Ensure the user is logged in
        assertTrue("User should be logged in", obj.isUserLoggedIn());
        System.out.println("User is registered and logged in.");
    }

    @When("I browse the dessert recipes section")
    public void iBrowseTheDessertRecipesSection() {
        obj.browseDessertRecipes();
        System.out.println("Browsing dessert recipes section.");
    }

    @Then("I should see a list of available dessert recipes")
    public void iShouldSeeAListOfAvailableDessertRecipes() {
        assertTrue("Dessert recipes should be visible", obj.isDessertRecipesListVisible());
        System.out.println("List of available dessert recipes is visible.");
    }
/*
    @Given("I am logged in as a user")
    public void iAmLoggedInAsAUser() {
        boolean isLoggedIn = obj.isUserLoggedIn();
        assertTrue("User should be logged in", isLoggedIn);
        System.out.println("User is logged in.");
    }*/

    @When("I search for dessert recipes using the keyword {string}")
    public void iSearchForDessertRecipesUsingTheKeyword(String keyword) {
        obj.searchDessertRecipes(keyword);
        System.out.println("Searching for dessert recipes with keyword: " + keyword);
    }

    @Then("I should see a list of dessert recipes that include {string}")
    public void iShouldSeeAListOfDessertRecipesThatInclude(String keyword) {
        boolean resultsContainKeyword = obj.dessertRecipesContainKeyword(keyword);
        assertTrue("Dessert recipes list should include keyword: " + keyword, resultsContainKeyword);
        System.out.println("List of dessert recipes includes keyword: " + keyword);
    }

    @Given("I am browsing dessert recipes")
    public void iAmBrowsingDessertRecipes() {
        obj.browseDessertRecipes();
        System.out.println("User is browsing dessert recipes.");
    }

    @When("I filter recipes by the dietary need {string}")
    public void iFilterRecipesByTheDietaryNeed(String dietaryNeed) {
        obj.filterRecipesByDietaryNeed(dietaryNeed);
        System.out.println("Filtering recipes by dietary need: " + dietaryNeed);
    }

    @Then("I should see a list of gluten-free dessert recipes")
    public void iShouldSeeAListOfGlutenFreeDessertRecipes() {
        assertTrue("List should contain gluten-free recipes", obj.isGlutenFreeRecipeListVisible());
        System.out.println("List of gluten-free dessert recipes is visible.");
    }

    @When("I filter recipes by the allergy {string}")
    public void iFilterRecipesByTheAllergy(String allergy) {
        obj.filterRecipesByAllergy(allergy);
        System.out.println("Filtering recipes by allergy: " + allergy);
    }

    @Then("I should see a list of nut-free dessert recipes")
    public void iShouldSeeAListOfNutFreeDessertRecipes() {
        assertTrue("List should contain nut-free recipes", obj.isNutFreeRecipeListVisible());
        System.out.println("List of nut-free dessert recipes is visible.");
    }

    @Given("I am viewing a dessert recipe titled {string}")
    public void iAmViewingADessertRecipeTitled(String recipeTitle) {
        obj.viewDessertRecipe(recipeTitle);
        System.out.println("Viewing dessert recipe titled: " + recipeTitle);
    }

    @When("I choose to purchase the Lemon Cheesecake directly from the store owner")
    public void iChooseToPurchaseTheLemonCheesecakeDirectlyFromTheStoreOwner() {
        obj.chooseToPurchaseRecipe("Lemon Cheesecake");
        System.out.println("Choosing to purchase Lemon Cheesecake directly from the store owner.");
    }

    @When("I complete the payment process")
    public void iCompleteThePaymentProcess() {
        obj.completePayment();
        System.out.println("Completing the payment process.");
    }

    @Then("I should receive a confirmation of my dessert purchase")
    public void iShouldReceiveAConfirmationOfMyDessertPurchase() {
        assertTrue("Should receive a confirmation of the dessert purchase", obj.isPurchaseConfirmed());
        System.out.println("Received confirmation of dessert purchase.");
    }
}
