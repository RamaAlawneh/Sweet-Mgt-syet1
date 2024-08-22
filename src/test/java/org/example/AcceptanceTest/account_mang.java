package org.example.AcceptanceTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;

public class account_mang {
    @Given("I am an admin")
    public void iAmAnAdmin() {

    }

    @When("I click on addacc and flag is {string}")
    public void iClickOnAddaccAndFlagIs(String string) {

    }

    @When("I fill in {string} with {string}")
    public void iFillInWith(String string, String string2) {

    }

    @When("I press {string} and flag is {string}")
    public void iPressAndFlagIs(String string, String string2) {

    }

    @Then("show message {string}")
    public void showMessage(String string) {

    }

    @When("I delete the account with Email {string} and it exists")
    public void iDeleteTheAccountWithEmailAndItExists(String string) {

    }

    @Then("the user account deletion succeeds")
    public void theUserAccountDeletionSucceeds() {

    }

    @When("I delete the account with Email {string} and it does not exist")
    public void iDeleteTheAccountWithEmailAndItDoesNotExist(String string) {

    }

    @Then("the system should print {string}")
    public void theSystemShouldPrint(String string) {

    }

    @When("the email {string} already exists")
    public void theEmailAlreadyExists(String string) {

    }

    @Given("I am logged in as a {string}")
    public void iAmLoggedInAsA(String string) {

    }

    @When("I request to delete my account with Email \"\"user@example.com\"\"")
    public void iRequestToDeleteMyAccountWithEmailUserExampleCom() {

    }

    @Then("my account deletion succeeds")
    public void myAccountDeletionSucceeds() {

    }

    @Given("I am logged in as a supplier")
    public void iAmLoggedInAsASupplier() {

    }

    @When("I update my account details with Email {string} and new data \"\\{\"name\": \"Supplier Z\",  \"phone\": \"{int}\"}\"")
    public void iUpdateMyAccountDetailsWithEmailAndNewData(String string, Integer int1) {
    }

    @Then("my account update succeeds")
    public void myAccountUpdateSucceeds() {

    }


    @When("I request to delete my account with Email {string} owner@example.com {string}")
    public void iRequestToDeleteMyAccountWithEmailOwnerExampleCom(String string, String string2) {

    }


    @When("I request to delete my account with Email \"\"supplier@gmail.com\"\"")
    public void iRequestToDeleteMyAccountWithEmailSupplierGmailCom() {

    }

    @Given("I am logged in as a owner")
    public void iAmLoggedInAsAOwner() {

    }
    @When("I update my account details with Email {string}, name {string}, and phone {string}")
    public void iUpdateMyAccountDetailsWithEmailNameAndPhone(String string, String string2, String string3) {

    }

    @Given("I am logged in as a user")
    public void iAmLoggedInAsAUser() {

    }
}

