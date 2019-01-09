@big
Feature: Purchase

  Scenario: User signs in for the first time to operate with account

    Given open page HOME
    And start signing in
    When signIn as Registered
    And open catalog for Women
    And choose catalog item Faded Short Sleeve T-shirts
    And pass ProductViewPage

    And pass CartNotificationPage
    And pass SummaryPage
    And pass AddressesPage
    And pass ShippingPage
    And pass PaymentPage
    And pass OrderSummaryPage

    Then order is confirmed


