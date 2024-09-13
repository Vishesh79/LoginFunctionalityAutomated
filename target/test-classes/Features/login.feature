Feature: Login Functionality for Amazon E-commerce Website

  Background: 
    Given I am on the Amazon page

  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully

  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see an error message indicating "<error_message>"

    Examples: 
      | username             | password        | error_message              |
      | validemail@gmail.com | invalidPassword | Your password is incorrect |
      | validemail@gmail.com | invalidPassword | Your password is incorrect |
      | validemail@gmail.com | abccc           | Your password is incorrect |
