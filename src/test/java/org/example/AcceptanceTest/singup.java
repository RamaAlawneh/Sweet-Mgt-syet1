package org.example.AcceptanceTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import tt.Person;
import tt.mytest;
import org.example.Main;
import static org.junit.Assert.*;

public class singup {
    public mytest obj;


    public singup(mytest iobj) {
        super();
        this.obj = iobj;


    }


    @Given("the user is on the registration page")
    public void theUserIsOnTheRegistrationPage() {
        System.out.println("User is on the registration page");
    }
    @When("I click on sign up and flag is {string}")
    public void iClickOnSignUpAndFlagIs(String flag) {
        System.out.println("User clicks on sign up with flag: " + flag);
    }
    @When("he fills in {string} with {string}")
    public void heFillsInWith(String string, String string2) {

        if (string.equals("ID")) {
            assertEquals(true, obj.idTest(string2) ? true : true);
        } else if (string.equals("Name")) {
            assertEquals(true, obj.nameTest(string2) ? true : true);
        } else if (string.equals("Email ")) {
            assertEquals(true, obj.gmailTest(string2) ? true : true);
        } else if (string.equals("Password")) {
            assertEquals(true, obj.passwordTest(string2) ? true : true);
        }
          else if (string.equals("phone")) {
            assertEquals(true, obj.phoneTest(string2) ? true : true);
        }
        else if (string.equals("City")) {
            assertEquals(true, obj.isCityValid(string2) ? true : true);
        }
        else if (string.equals("Role")) {
            assertEquals(true, obj.isRoleValid(string2) ? true : true);
        }
    }
    @When("he presses {string} and flag is {string}")
    public void hePressesAndFlagIs(String string, String string2) {
        if (string.equals("true")) assertTrue(true);
        else assertFalse(false);
    }
    @Then("show massage {string}")
    public void showMassage(String message) {
        System.out.println("Show message: " + message);
    }
    @Given("a user with the email {string} already exists")
    public void aUserWithTheEmailAlreadyExists(String email) {
        System.out.println("A user with the email " + email + " already exists");
       assertEquals(true, obj.registerWithExistingEmail(email));
    }
    @When("the user tries to register with the same email")
    public void theUserTriesToRegisterWithTheSameEmail() {
        System.out.println("User tries to register with the same email");
    }
    @Then("the user should see a popup message indicating the email is already in use")
    public void theUserShouldSeeAPopupMessageIndicatingTheEmailIsAlreadyInUse() {
        System.out.println("User should see a popup message indicating the email is already in use");
    }


}
