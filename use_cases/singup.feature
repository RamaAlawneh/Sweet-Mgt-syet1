Feature: singup


  Scenario Outline: a successful signup
    Given the user is on the registration page
    When I click on sign up and flag is 'true'
    And he fills in 'ID' with '<ID>'
    And he fills in 'Name' with '<Name>'
    And he fills in 'Email' with '<Email>'
    And he fills in 'Password' with '<Password>'
    And he fills in 'Role' with '<Role>'
    And he fills in 'Phone' with '<phone>'
    And he fills in 'City' with '<City>'
    And he presses 'sign up' and flag is 'true'
    Then show massage 'information has been entered successfully'

    Examples:
      | ID  | Name   | Password     | Email            | Role   |phone                |City      |
      | 13  | "masa" | password123  | masa@gmail.com   | owner  |"phone": "1234567890"|"Tulkarm" |
      | 56  | "rama" | mypass321    | rama@gmail.com   | user   |"phone": "1234567890"|"Nablus"  |
      | 45  | "dima" | mypass321    | dima@gmail.com   |supplier|"phone": "1234567890"|"Qalqilya"|





  Scenario Outline: errors with input
    Given the user is on the registration page
    When I click on sign up and flag is 'true'
    And he fills in 'ID' with '<ID>'
    And he fills in 'Name' with '<Name>'
    And he fills in 'Email' with '<Email>'
    And he fills in 'Password' with '<Password>'
    And he fills in 'Phone' with '<phone>'

    And he fills in 'Role' with '<Role>'
    And he fills in 'City' with '<City>'

    And he presses 'sign up' and flag is 'true'
    Then show massage 'failed to sign up try again'



    Examples:
      | ID   | Name    | Password     | Email           | Role |phone                  |City|
      | 123  | "Ahmad" | password123  | ahmad@gmail.com | admin| "phone": "1234567890" |"Qalqilya"|
      | 456  | "maya"  | mypass321    | marygmail.com   | user | "phone": "1234567890" |"Qalqilya"|
      | 456  | ""      | mypass3212   | my@gmail.com    | user | "phone": "1234567890" |"Qalqilya"|
      |      | "masa"  | pass456      | masa@gmail.com  | user | "phone": "1234567890" |"Tulkarm" |
      | 78   | "hanan" |              | hana@gmail.com  | user | "phone": "1234567890" |"Tulkarm" |
      |  87  | "mira"  | pass45678    |                 | user | "phone": "1234567890" |"Nablus"  |
      |  hh  | "mira"  | pass45678    | mira@gmail.com  | user | "phone": "1234567890" |"Nablus"  |
      |  10  | "marah" | pass45678    |marah@gmail.com  |      | "phone": "1234567890" |"Nablus"  |
      |  20  | "mai"   | pass45678    |mai@gmail.com    |user  | "phone": "1234567890" |          |



  Scenario: sing up  with a duplicate email
    Given a user with the email "haya@gmail.com" already exists
    When the user tries to register with the same email
    Then the user should see a popup message indicating the email is already in use