Feature: login

  Scenario: valid login
    Given I am not in system
    When set username "haya@gmail.com" and pass "123"
    Then login succeed


  Scenario Outline: invalid log in
    Given I am not in system
    When set invalid username <user_name> or invalid pass <pass>
    And set empty username <user_name> or empty  pass <pass>
    Then login failed
    Examples:
      | user_name | pass    |
      | "haya"    | "12349" |
      | "naa"    | "123" |
      | "hayak"    | "12349" |
      | ""    | "123" |
      | ""    | "1234" |
      | "haya"    | "" |
      | "hayak"    | "" |
      | ""    | "" |

  Scenario Outline: User Forgot Password
    Given I am not in system
    When set valid username <user_name> and  pass <pass>
    Then take new pass <newPass>
    Examples:
      | user_name | pass     | newPass |
      | "haya"    | "Forget" | "12345" |
      | "haa"    | "Forget" | "12345" |






