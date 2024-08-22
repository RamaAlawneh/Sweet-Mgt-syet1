Feature:order

Scenario: Apply a volume-based discount
Given I am logged in as a store owner
And I have a product "Vanilla Cake" with no current discounts
When I apply a 10% discount for quantities above 20
Then the discount should be set successfully
And I should see "Discount applied successfully" on my dashboard

Scenario: Update an existing discount
Given I am logged in as a store owner
And I have a product "Chocolate Cake" with a 5% discount for quantities above 10
When I update the discount to 15% for quantities above 15
Then the discount details should be updated successfully
And I should see "Discount updated successfully" on my dashboard

Scenario: Remove a discount from a product
Given I am logged in as a store owner
And I have a product "Cheese Cake" with a 20% discount for quantities above 30
When I remove the discount from "Cheese Cake"
Then the discount should be removed successfully
And I should see "Discount removed successfully" on my dashboard

Scenario: Apply a time-limited promotional discount
Given I am logged in as a store owner
And I have a product "Red Velvet Cake" priced at $30 with no current discounts
When I apply a promotional discount of 25% valid from "2021-12-01" to "2021-12-31"
Then the promotional discount should be set successfully
And I should see "Promotional discount applied successfully" on my dashboard