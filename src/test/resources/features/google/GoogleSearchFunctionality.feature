Feature: Testing the Google Search Functionality
    #general description
  Scenario: Happy Path(positive)Testing for Search
    #test case
    Given User navigates to the google
    When User searches for CodeFish
    Then User validates first page returns more ten links

    Scenario: Happy Path(positive) Testing Result for Search

      Given User navigates to the google
      When User searches for Kyrgyz Food in USA
      Then User validates the result is less than three hundred million

Scenario: Testing loading time for turkish baklava search
  Given User navigates to the google
  When User search for turkish baklava
  Then User validates page loads less than one second


