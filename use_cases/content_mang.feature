Feature: Content Management

  # Admin Scenarios
  Scenario: Approve a Submitted Recipe
    Given I am logged in as an admin
    When I approve a submitted recipe titled "Chocolate Cake"
    Then the recipe "Chocolate Cake" should be publicly visible on the platform

  Scenario: Reject a Submitted Recipe
    Given I am logged in as an admin
    When I reject a submitted recipe titled "Chocolate Cake" with reason "Incomplete ingredient list"
    Then the submitter should receive a notification "Incomplete ingredient list"
    And the recipe "Chocolate Cake" should not be publicly visible

  Scenario: Delete a Publicly Visible Recipe
    Given I am logged in as an admin
    And the recipe "Lemon Tart" is publicly visible
    When I delete the recipe "Lemon Tart"
    Then the recipe "Lemon Tart" should no longer be visible on the platform

  Scenario: View Feedback for a Recipe
    Given I am logged in as an admin
    When I view feedback for the recipe titled "Banana Bread"
    Then I should see all user comments and ratings for "Banana Bread"

  Scenario: Remove Inappropriate Feedback
    Given I am logged in as an admin
    And there is a feedback comment "Inappropriate language" on the recipe titled "Apple Pie"
    When I remove the inappropriate feedback on "Apple Pie"
    Then the feedback should no longer be visible under the "Apple Pie" recipe

  Scenario: Respond to a Feedback Question
    Given I am logged in as an admin
    And there is a feedback question "Can I use a substitute for butter?" on the recipe "Chocolate Chip Cookies"
    When I respond to the feedback with "You can use margarine as a substitute."
    Then my response should be visible under the feedback question

  # User Scenarios
  Scenario: Post a New Recipe as a User
    Given I am logged in as a user
    When I post a new dessert recipe with the title "Chocolate Cake" and description "Step-by-step guide"
    Then the recipe should be visible on my profile awaiting admin approval

  Scenario: Delete a User-Posted Recipe
    Given I am logged in as a user
    And I have posted a dessert recipe titled "Chocolate Cake"
    When I delete the dessert recipe
    Then the recipe should no longer be visible on my profile

  Scenario: provide feedback
    Given I am logged in as a user
    And I have tried the recipe titled "Banana Bread"
    When I leave feedback on the "Banana Bread" recipe with the comment "Great taste, but needs more baking time."
    Then my feedback should be visible under the "Banana Bread" recipe

  Scenario: Delete User Feedback
    Given I am logged in as a user
    And I have left feedback with titled "Banana Bread" with the comment "Very powerful and easy to use!"
    When I delete my feedback on the "Banana Bread"
    Then my feedback should no longer be visible under the "Banana Bread"
