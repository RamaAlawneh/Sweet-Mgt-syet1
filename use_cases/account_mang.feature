Feature: Account Management


  Scenario Outline: Create a new account from admin
    Given I am an admin
    When I click on addacc and flag is 'true'
    And I fill in 'ID' with '<ID>'
    And I fill in 'Name' with '<Name>'
    And I fill in 'Email' with '<Email>'
    And I fill in 'Password' with '<Password>'
    And I fill in 'Role' with '<Role>'
    And I press 'add account' and flag is 'true'
    Then show message 'Create a new account is successfully'

    Examples:
      | ID   | Name   | Password     | Email               | Role   |
      | 1  | "owner"  | password123  | owner@gmail.com   | owner  |
      | 2  | "user"  | mypass321         | user@gmail.com          | user   |
      | 3  | "supplier"  | mypass321        | supplier@gmail.com          |  supplier   |

  Scenario: Delete an account from admin
    Given I am an admin
    When I delete the account with Email "supplier@gmail.com" and it exists
    Then the user account deletion succeeds

  Scenario: Admin deletes a non-existent account
    Given I am an admin
    When I delete the account with Email "supplier1@gmail.com" and it does not exist
    Then the system should print 'error delete'

  Scenario: Add account with a duplicate email
    Given I am an admin
    When I click on addacc and flag is 'true'
    And the email "lama@gmail.com" already exists
    Then the user should see a popup message indicating the email is already in use




  Scenario Outline: Delete own account
    Given I am logged in as a <role>
    When I request to delete my account with Email "<email>"
    Then my account deletion succeeds

    Examples:
      | role    | email               |
      | "user "   | "user@example.com"    |
      | "owner  " |" owner@example.com "  |
      |" supplier"| "supplier@gmail.com"  |




  Scenario Outline: Update own account
    Given I am logged in as a <role>
    When I update my account details with Email "<email>", name "<name>", and phone "<phone>"
    Then my account update succeeds

    Examples:
      | role     | email              | name        | phone       |
      | user     | user@example.com   | John Doe    | 1234567890  |
      | owner    | owner@example.com  | Jane Smith  | 0987654321  |
      | supplier | supplier@gmail.com | Supplier Z  | 5551234567  |


















