package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tt.mytest;

import static org.junit.Assert.*;

public class content {

    private mytest obj;

    public content() {
        this.obj = new mytest();
    }

    @Given("I am logged in as an admin")
    public void iAmLoggedInAsAnAdmin() {
        obj.setCurrentUserRole("admin");
        assertTrue("User should be logged in as admin", obj.isLoggedInAs("admin"));
    }

    @When("I approve a submitted recipe titled {string}")
    public void iApproveASubmittedRecipeTitled(String recipeTitle) {
        obj.approveRecipe(recipeTitle);
    }

    @Then("the recipe {string} should be publicly visible on the platform")
    public void theRecipeShouldBePubliclyVisibleOnThePlatform(String recipeTitle) {
        assertTrue("Recipe should be publicly visible", obj.isRecipePubliclyVisible(recipeTitle));
    }

    @When("I reject a submitted recipe titled {string} with reason {string}")
    public void iRejectASubmittedRecipeTitledWithReason(String recipeTitle, String reason) {
        obj.rejectRecipe(recipeTitle, reason);
    }

    @Then("the submitter should receive a notification {string}")
    public void theSubmitterShouldReceiveANotification(String notification) {
        assertEquals(notification, obj.getLastNotification());
    }

    @Then("the recipe {string} should not be publicly visible")
    public void theRecipeShouldNotBePubliclyVisible(String recipeTitle) {
        assertFalse("Recipe should not be publicly visible", obj.isRecipePubliclyVisible(recipeTitle));
    }

    @Given("the recipe {string} is publicly visible")
    public void theRecipeIsPubliclyVisible(String recipeTitle) {
        obj.makeRecipePubliclyVisible(recipeTitle);
    }

    @When("I delete the recipe {string}")
    public void iDeleteTheRecipe(String recipeTitle) {
        obj.deleteRecipe(recipeTitle);
    }

    @Then("the recipe {string} should no longer be visible on the platform")
    public void theRecipeShouldNoLongerBeVisibleOnThePlatform(String recipeTitle) {
        assertFalse("Recipe should no longer be visible", obj.isRecipePubliclyVisible(recipeTitle));
    }

    @When("I view feedback for the recipe titled {string}")
    public void iViewFeedbackForTheRecipeTitled(String recipeTitle) {
        obj.viewRecipeFeedback(recipeTitle);
    }

    @Then("I should see all user comments and ratings for {string}")
    public void iShouldSeeAllUserCommentsAndRatingsFor(String recipeTitle) {
        assertTrue("All comments and ratings should be visible", obj.areAllCommentsAndRatingsVisible(recipeTitle));
    }

    @Given("there is a feedback comment {string} on the recipe titled {string}")
    public void thereIsAFeedbackCommentOnTheRecipeTitled(String feedback, String recipeTitle) {
        obj.addFeedbackToRecipe(recipeTitle, feedback);
    }

    @When("I remove the inappropriate feedback on {string}")
    public void iRemoveTheInappropriateFeedbackOn(String recipeTitle) {
        obj.removeFeedbackFromRecipe(recipeTitle, "Inappropriate language");
    }

    @Then("the feedback should no longer be visible under the {string} recipe")
    public void theFeedbackShouldNoLongerBeVisibleUnderTheRecipe(String recipeTitle) {
        assertFalse("Feedback should no longer be visible", obj.isFeedbackVisible(recipeTitle, "Inappropriate language"));
    }

    @Given("there is a feedback question {string} on the recipe {string}")
    public void thereIsAFeedbackQuestionOnTheRecipe(String question, String recipeTitle) {
        obj.addFeedbackToRecipe(recipeTitle, question);
    }

    @When("I respond to the feedback with {string}")
    public void iRespondToTheFeedbackWith(String response) {
        obj.respondToFeedback(response);
    }

    @Then("my response should be visible under the feedback question")
    public void myResponseShouldBeVisibleUnderTheFeedbackQuestion() {
        assertTrue("Response should be visible under the feedback question", obj.isFeedbackResponseVisible());
    }
/*
    @Given("I am logged in as a user")
    public void iAmLoggedInAsAUser() {
        obj.setCurrentUserRole("user");
        assertTrue("User should be logged in as user", obj.isLoggedInAs("user"));
    }*/

    @When("I post a new dessert recipe with the title {string} and description {string}")
    public void iPostANewDessertRecipeWithTheTitleAndDescription(String title, String description) {
        obj.submitNewRecipe(title, description);
    }

    @Then("the recipe should be visible on my profile awaiting admin approval")
    public void theRecipeShouldBeVisibleOnMyProfileAwaitingAdminApproval() {
        assertTrue("Recipe should be visible on profile awaiting approval", obj.isRecipeAwaitingApprovalOnProfile());
    }

    @Given("I have posted a dessert recipe titled {string}")
    public void iHavePostedADessertRecipeTitled(String recipeTitle) {
        obj.submitNewRecipe(recipeTitle, "Description");
    }

    @When("I delete the dessert recipe")
    public void iDeleteTheDessertRecipe() {
        obj.deleteOwnRecipe("Chocolate Cake");
    }

    @Then("the recipe should no longer be visible on my profile")
    public void theRecipeShouldNoLongerBeVisibleOnMyProfile() {
        assertFalse("Recipe should no longer be visible on profile", obj.isRecipeVisibleOnProfile("Chocolate Cake"));
    }

    @Given("I have tried the recipe titled {string}")
    public void iHaveTriedTheRecipeTitled(String recipeTitle) {
        obj.markRecipeAsTried(recipeTitle);
    }

    @When("I leave feedback on the {string} recipe with the comment {string}")
    public void iLeaveFeedbackOnTheRecipeWithTheComment(String recipeTitle, String comment) {
        obj.leaveFeedbackOnRecipe(recipeTitle, comment);
    }

    @Then("my feedback should be visible under the {string} recipe")
    public void myFeedbackShouldBeVisibleUnderTheRecipe(String recipeTitle) {
        assertTrue("Feedback should be visible under the recipe", obj.isFeedbackVisible(recipeTitle, "Great taste, but needs more baking time."));
    }

    @Given("I have left feedback with titled {string} with the comment {string}")
    public void iHaveLeftFeedbackWithTitledWithTheComment(String recipeTitle, String comment) {
        obj.leaveFeedbackOnRecipe(recipeTitle, comment);
    }

    @When("I delete my feedback on the {string}")
    public void iDeleteMyFeedbackOnThe(String recipeTitle) {
        obj.deleteFeedbackOnRecipe(recipeTitle, "Very powerful and easy to use!");
    }

    @Then("my feedback should no longer be visible under the {string} recipe")
    public void myFeedbackShouldNoLongerBeVisibleUnderTheRecipe(String recipeTitle) {
        assertFalse("Feedback should no longer be visible under the recipe", obj.isFeedbackVisible(recipeTitle, "Very powerful and easy to use!"));
    }
    @Then("my feedback should no longer be visible under the {string}")
    public void myFeedbackShouldNoLongerBeVisibleUnderThe(String  recipeTitle) {
        boolean feedbackVisible = obj.isFeedbackVisible(recipeTitle, "feedback content");

        // Assert that the feedback is no longer visible
        assertFalse("Feedback should no longer be visible under the " + recipeTitle + " recipe", feedbackVisible);
    }

    }

