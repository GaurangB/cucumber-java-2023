@ui @smoke
Feature:login

  @login7
  Scenario Outline: Verify login feature 7
    Given User is already on sign in page
    When user enters <userName> and <password>
    And click on signIn button
    #Then user navigates to homePage

    Examples:
      | userName      | password     |
      | standard_user | secret_sauce |

  @login8
  Scenario: Verify login feature 8
    Given User is already on sign in page
    When user enters standard_user and secret_sauce
    And click on signIn button
    #Then user navigates to homePage