Feature: Login
  Scenario: login with valid credentials
    Given I am on the login page
    When I set user and password with "oscar.lopez@fundacion-jala.org" and "O3728236l"
    Then I should be on the users home page

