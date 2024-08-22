Feature: Product Management

  Scenario: Add a New Product
    Given I am logged in as a store owner
    When I add a product with the following details
      | name          | category  | price |
      | Chocolate Cake| Desserts  | 20.00 |
    Then the product should be added successfully
    And I should see "Product added successfully" on my dashboard


  Scenario: Update an Existing Product
    Given I am logged in as a store owner
    And I have a product with ID "1001" in the inventory
    When I update the product "1001" with the following details
      | price | category          |
      | 15.00 | Premium Desserts  |
    Then the product details should be updated successfully
    And I should see "Product updated successfully" on my dashboard


  Scenario: Remove a Product
    Given I am logged in as a store owner
    And I have a product with ID "1002" in the inventory
    When I remove the product "1002"
    Then the product should be removed successfully
    And I should see "Product removed successfully" on my dashboard


  Scenario: Apply a volume-based discount
    Given I am logged in as a store owner
    And I have a product "Vanilla Cake" with no current discounts
    When I apply a 10% discount for quantities above 20
    Then the discount should be set successfully
    And I should see "Discount applied successfully" on my dashboard


  Scenario: Apply a time-limited promotional discount
    Given I am logged in as a store owner
    And I have a product "Red Velvet Cake" priced at $30 with no current discounts
    When I apply a promotional discount of 25% valid from "2021-12-01" to "2021-12-31"
    Then the promotional discount should be set successfully
    And I should see "Promotional discount applied successfully" on my dashboard
