package com.Cucumber.Steps;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

@SpringBootTest
public class UserSteps {

    User user = new User();
    String testName = "";
    @Autowired
    UserService userService = new UserService();
    Iterable<User> users;
    List<User> userList;
    int userId;
    int totalNrOfUsers;

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

    //==========================================

    @Given("a new user and set the name to {string}")
    public void a_new_user_and_set_the_name_to(String string) {
        user.setName(string);
        userService.saveUser(user);
    }
    @When("i get all users and check the last on the list")
    public void i_get_all_users_and_check_the_last_on_the_list() {
        users = userService.getAllUsers();
        userList = StreamSupport.stream(users.spliterator(), false).collect(Collectors.toList());
        user = userList.get(userList.size() - 1);
        user = userService.getUserById(user.getId());
    }
    @Then("its name is {string}")
    public void its_name_is(String string) {
        assertEquals(string, user.getName());
    }

    //=======================================

    @Given("the last user on the list")
    public void the_last_user_on_the_list() {
        users = userService.getAllUsers();
        userList = StreamSupport.stream(users.spliterator(), false).collect(Collectors.toList());
        user = userList.get(userList.size() - 1);
    }
    @When("i update its name to {string}")
    public void i_update_its_name_to(String string) {
        user.setName(string);
        userId = user.getId();
        userService.updateUser(user, userId);
    }
    @Then("name of the last user in db is {string}")
    public void name_of_the_last_user_in_db_is(String string) {
        users = userService.getAllUsers();
        userList = StreamSupport.stream(users.spliterator(), false).collect(Collectors.toList());
        user = userList.get(userList.size() - 1);
        assertEquals(string, user.getName());
    }

    //==============================================

    @Given("the number of users")
    public void the_number_of_users() {
        users = userService.getAllUsers();
        userList = StreamSupport.stream(users.spliterator(), false).collect(Collectors.toList());
        totalNrOfUsers = userList.size();
        user = userList.get(totalNrOfUsers - 1);
    }
    @When("i delete the last user")
    public void i_delete_the_last_user() {
        userService.deleteUser(user.getId());
    }

    @Then("its users total number is less by one")
    public void its_total_number_is_less_by_one() {
        users = userService.getAllUsers();
        userList = StreamSupport.stream(users.spliterator(), false).collect(Collectors.toList());
        assertEquals((long)totalNrOfUsers - 1, userList.size());
    }
}
