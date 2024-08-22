Feature: Monitoring and Reporting

  Scenario Outline: Monitor Profits and Generate Financial Reports
  Given I am logged into the system as a <role>
  When I navigate to the financial reports section
  And I select the store <store_name>
  And I select the date range "01-01-2024" to "31-01-2024"
  Then I should see the financial report for "Store A" for the selected date range
  And The report should include details of profits, expenses, and budget
    Examples:

     |role |  store_name |
     |"admin"| "store A" |
    |"Suppliers"|" store B"|


  Scenario Outline: Monitor Profits for Different Stores
  Given I am logged into the system as a <role>
  When I navigate to the profits section
  And I select the store <store_name>
  Then I should see the current profit for <store_name>
  And Display charts comparing profits over previous months
    Examples:
      |role |  store_name |
      |"admin"| "store A" |
      |"Suppliers"|" store B"|
      |  "admin" |"Store C" |
      |"Suppliers"|" store D"|


  Scenario Outline: View Best-Selling Products in Different Stores
  Given I am logged into the system as a <role>
  When I navigate to the best-selling products section
  And I select the store <store_name>
  Then I should see a list of the best-selling products for <store_name>
  And Each product should display the quantity sold and total revenue

    Examples:
      |role |  store_name |
      |"admin"| "store A" |
      |"Suppliers1"|" store A"|
      |  "admin" |"Store B" |
      |"Suppliers2"|" store B"|

  Scenario Outline: View User Statistics by Different Cities
  Given I am logged into the system as admine
  When I navigate to the user statistics section
  And I select the city <city_name>
  Then I should see statistics for registered users in <city_name>
  And The statistics should include the number of registered users, active users, and user demographics (age, gender)

    Examples:
    |city_name|
    |"Nablus"|
    |"Jenin"|
    |"Ramallah|
