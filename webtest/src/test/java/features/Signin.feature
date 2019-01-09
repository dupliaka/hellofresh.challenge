Feature: Sign in

  Scenario: User signs in for the first time to operate with account

    Given open page HOME
    And start signing in
    When signIn with new account
    And fill John profile
    Then success sign in with John profile