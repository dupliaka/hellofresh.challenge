Feature: Log in

  Scenario: Registered user Joe Black login to see his account

    Given open page HOME
    And start signing in
    When signIn as Registered
    Then success sign in with Registered profile

