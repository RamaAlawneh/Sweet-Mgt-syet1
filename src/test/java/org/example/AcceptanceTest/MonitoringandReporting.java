package org.example.AcceptanceTest;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import java.util.*;

import tt.ReportManager;
import tt.Tproduct;


public class MonitoringandReporting {

    private ReportManager reportManager = new ReportManager();
    private String userRole;
    private String selectedStore;
    private String startDate;
    private String endDate;
    private String selectedCity;

    @Given("I am logged into the system as a {string}")
    public void i_am_logged_into_the_system_as_a(String role) {
        this.userRole = role;

    }

    @When("I navigate to the financial reports section")
    public void i_navigate_to_the_financial_reports_section() {

    }

    @When("I select the store {string}")
    public void i_select_the_store(String store) {
        this.selectedStore = store;

    }

    @When("I select the date range {string} to {string}")
    public void i_select_the_date_range_to(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;

    }

    @Then("I should see the financial report for {string} for the selected date range")
    public void i_should_see_the_financial_report_for_for_the_selected_date_range(String store) {
        double totalProfit = reportManager.getTotalProfit(store);

        assertTrue(totalProfit >= 0);
    }

    @Then("The report should include details of profits, expenses, and budget")
    public void the_report_should_include_details_of_profits_expenses_and_budget() {

    }

    @When("I navigate to the profits section")
    public void i_navigate_to_the_profits_section() {
    }

    @Then("I should see the current profit for {string}")
    public void i_should_see_the_current_profit_for(String store) {
        double currentProfit = reportManager.getTotalProfit(store);
        assertTrue(currentProfit > 0);
    }

    @Then("Display charts comparing profits over previous months")
    public void display_charts_comparing_profits_over_previous_months() {

    }

    @When("I navigate to the best-selling products section")
    public void i_navigate_to_the_best_selling_products_section() {

    }

    @Then("I should see a list of the best-selling products for {string}")
    public void i_should_see_a_list_of_the_best_selling_products_for(String store) {
        List<Tproduct> products = reportManager.getBestSellingProducts(store);
        assertNotNull(products);
        assertFalse(products.isEmpty());
    }

    @Then("Each product should display the quantity sold and total revenue")
    public void each_product_should_display_the_quantity_sold_and_total_revenue() {
        List<Tproduct> products = reportManager.getBestSellingProducts(selectedStore);
        for (Tproduct product : products) {
            assertTrue(product.getquantity() > 0);
            assertTrue(product.getprice() > 0);
        }
    }

    @Given("I am logged into the system as admine")
    public void i_am_logged_into_the_system_as_admine() {
        this.userRole = "admine";
        // Handle admin login (mocked or actual login logic)
    }

    @When("I navigate to the user statistics section")
    public void i_navigate_to_the_user_statistics_section() {

    }
/*
    @When("I select the city {string}")
    public void i_select_the_city(String city) {
        this.selectedCity = city;

    }*/
/*
    @Then("I should see statistics for registered users in {string}")
    public void i_should_see_statistics_for_registered_users_in(String city) {

    }*/

    @Then("The statistics should include the number of registered users, active users, and user demographics \\(age, gender)")
    public void the_statistics_should_include_the_number_of_registered_users_active_users_and_user_demographics_age_gender() {

    }

    @When("I select the city {string}")
    public void i_select_the_city_ramallah(String city) {
        this.selectedCity = city;

    }

    @Then("I should see statistics for registered users in {string}")
    public void i_should_see_statistics_for_registered_users_in_ramallah(String city) {

    }
    @When("I select the city \"Ramallah")
    public void iSelectTheCityRamallah() {
    }
    @Then("I should see statistics for registered users in \"Ramallah")
    public void iShouldSeeStatisticsForRegisteredUsersInRamallah() {
    }
}