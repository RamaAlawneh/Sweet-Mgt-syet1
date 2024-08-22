Feature: Exploration and Purchase of Desserts

  Scenario: Browse dessert recipes
    Given I am a registered user and logged in
    When I browse the dessert recipes section
    Then I should see a list of available dessert recipes

  Scenario: Search for chocolate recipes
    Given I am logged in as a user
    When I search for dessert recipes using the keyword "chocolate"
    Then I should see a list of dessert recipes that include "chocolate"

  Scenario: Filter by gluten-free desserts
    Given I am logged in as a user
    And I am browsing dessert recipes
    When I filter recipes by the dietary need "gluten-free"
    Then I should see a list of gluten-free dessert recipes

  Scenario: Filter by nut-free desserts
    Given I am logged in as a user
    And I am browsing dessert recipes
    When I filter recipes by the allergy "nut-free"
    Then I should see a list of nut-free dessert recipes

  Scenario: Purchase Lemon Cheesecake
    Given I am logged in as a user
    And I am viewing a dessert recipe titled "Lemon Cheesecake"
    When I choose to purchase the Lemon Cheesecake directly from the store owner
    And I complete the payment process
    Then I should receive a confirmation of my dessert purchase
