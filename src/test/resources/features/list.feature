Feature: List

  @CreateBoard
  Scenario: Creates a list
    When I select a board with name "NewBoardList"
    And I creat a new list with name "NewList"
    Then I should see the name of new list on board