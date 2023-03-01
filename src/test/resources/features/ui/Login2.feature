@ui @smoke
Feature:login

  @login3
  Scenario Outline: Verify login feature 3
    Given User is already on sign in page
    When user enters <userName> and <password>
    And click on signIn button
    Then user navigates to homePage

    Examples:
      | userName      | password     |
      | standard_user | secret_sauce |

  @login4
  Scenario: Verify login feature 4
    Given User is already on sign in page
    When user enters standard_user and secret_sauce
    And click on signIn button
    #Then user navigates to homePage