package org.example.AcceptanceTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import tt.Person;
import tt.mytest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Login {


    public Login(mytest iobj) {
        super();
        this.obj = iobj;
        Person u1 = new Person("1", "haya", "123", "haya@gmail.com", "Qalqilya", "0599221233", "user");
        Person u2 = new Person("2", "rama", "123456", "rama@gmail.com", "nablus", "0599221233", "user");
        obj.addUser(u1);
        obj.addUser(u2);


    }
    public boolean forget = false;
    public mytest obj;
    @Given("I am not in system")
    public void iAmNotInSystem() {
        obj.iAmNotInSystem(obj);

    }
    @When("set username {string} and pass {string}")
    public void setUsernameAndPass(String string, String string2) {
        obj.setUsernameAndPassAndPassFromSystem(string,string2);
    }
    @Then("login succeed")
    public void loginSucceed() {
        assertTrue("Login should succeed", obj.getValidation());
    }
    @When("set invalid username {string} or invalid pass {string}")
    public void setInvalidUsernameOrInvalidPass(String string, String string2) {
        obj. setUsernameAndPassAndPassFromSystem(string,string2);

    }
    @When("set empty username {string} or empty  pass {string}")
    public void setEmptyUsernameOrEmptyPass(String string, String string2) {
obj.setEmptyUsernameOrEmptyPass(string, string2);
    }
    @Then("login failed")
    public void loginFailed() {
        assertFalse("Login should fail", obj.getValidation());

    }

    @When("set valid username {string} and  pass {string}")
    public void setValidUsernameAndPass(String user_name, String pass) {
        obj.validUserPass(user_name,pass);
        forget=obj.getForget();
    }



    @Then("take new pass {string}")
    public void takeNewPass(String newPass) {
        obj.takePass(newPass);
        assertTrue("New password should be updated", obj.getPasswordUpdated());

    }




}