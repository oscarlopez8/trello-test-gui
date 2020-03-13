Feature: Board

  Scenario: Creates a Board
    Given I am logged with valid user
    When I create a new Board with name "New Board to test"
    Then I should see the name of Board in BoardPage

  Scenario: Creates a public Board
    When I create a new board whit following information
      | name | New Board |
      | type | Público   |
    Then I should see the name of Board in BoardPage


#  Scenario: Deletes a Board
##    Given I am logged with valid user
##    When I delete a existing board with "New Board to test"
##    Then I should see the name of Board in BoardPage

