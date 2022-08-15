@tag
Feature: Add items using todoItems POST API

  Scenario: Add Unique Item using POST request
    Given User enters the unique ToDo Item
    Then Item should be added successfully

  Scenario: Add duplicate item using POST request
    Given User enters the already existing ToDo Item
    Then User should get item already exist error

  Scenario: Add empty item using POST request
    Given User enters the empty ToDo Item
    Then User should get item can not be empty error

  Scenario: Mark item as completed using PUT request
    Given User marks item as completed
    Then User should not see the completed item in the list
