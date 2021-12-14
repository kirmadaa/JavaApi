package com.Cucumber.Steps;

import com.User;
import org.springframework.boot.test.context.SpringBootTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

@SpringBootTest
public class UserSteps {

    User user = new User();
    String testName = "";

    @Given("Name the user as {string}")
    public void name_the_user_as(String string) {
        user.setName(string);
    }
    @When("I will check the user name")
    public void i_will_check_the_user_name() {
        testName = user.getName();
    }
    @Then("The user name is {string}")
    public void the_user_name_is(String string) {
        assertEquals(string, testName);
    }
}
