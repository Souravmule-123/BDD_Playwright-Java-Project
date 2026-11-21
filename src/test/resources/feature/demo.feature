Feature: This feature is to validate test scenario


  @Test1
  Scenario: To login SauceDemo Page
    Given I launch the "SauceDemo" Application
    And I  enter the "Username" and "Password"

  @Test2
  Scenario: click Method
    Given I launch the "SauceDemo" Application
    Then I enter the Username
    And I clear the text on the entire field
    And I enter the keyboard typing action
    And I  enter the "Username" and "Password"
    Then I click on sauce labs bagPack

  @Test3
  Scenario: Keyboard Method(pending)
    Given I launch the "SauceDemo" Application
    And I enter the keyboard typing action

  @Test4
  Scenario: Drag&Drop Method
    Given I launch the "SauceDemo" Application

  @Frank
  Scenario: Frank Scenario execution
    Given I launch the "Frank1" Application

  @Test5
  Scenario: mouseHover Method
    Given I launch the "SauceDemo" Application
    And I  enter the "Username" and "Password"
    And I mouseHover on Sauce Labs Backpack

  @Test6
  Scenario: log printing statement
    Given I launch the "SauceDemo" Application
    Then I want a url of the page

  @Test7
  Scenario: Navigation Method
    Given I launch the "SauceDemo" Application
    Then I want move back reload the page

  @Test8
  Scenario: Dropdown Method
    Given I launch the "SauceDemo" Application
    And I  enter the "Username" and "Password"
    Then Select the category from A To Z

  @Test9
  Scenario: assertion in Playwright
    Given I launch the "SauceDemo" Application
    And I  enter the "Username" and "Password"
    Given I launch the verify the "Products" title name
    Then I verify the text is swagLabs

