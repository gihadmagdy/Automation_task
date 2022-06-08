Feature: feature to test login functionality


  Scenario Outline: check login is successful With valid credentials

    Given user is on login page
    When  user enter "<username>" and "<password>"
    And  clicks on login button
    Then user is navigated to home page
    When user select the cheapest item
    Then add to cart
    Then Proceed to check out
    Then Add reuired data
    Then Compelete check out process
    And Assert on compelation of order

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | locked_out_user |secret_sauce |
      | problem_user |secret_sauce  |
      | performance_glitch_user |secret_sauce  |