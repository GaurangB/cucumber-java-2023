@ui @smoke
Feature:login

  @login
  Scenario Outline: Verify login feature 1
    Given User is already on sign in page
    When user enters <userName> and <password>
    And click on signIn button
    #Then user navigates to homePage

    Examples:
      | userName      | password     |
      | standard_user | secret_sauce |

  @login2
  Scenario: Verify login feature 2
    Given User is already on sign in page
    When user enters standard_user and secret_sauce
    And click on signIn button
    #Then user navigates to homePage