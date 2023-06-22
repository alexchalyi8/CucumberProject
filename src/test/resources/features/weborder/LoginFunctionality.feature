Feature: login functionality for WebOrder website
  Scenario:Happy path (correct username correct password)

    When User provides 'guest1@microworks.com','Guest1!' and click Login button
    Then User validate website 'ORDER DETAILS - Weborder'

  Scenario: Negative Login(Correct username - Wrong Password)
    When User provides 'guest1@microworks.com','trdtrs!' and click Login button
    Then User validate the error message 'Sign in Failed'
#
  Scenario: Negative Login(Wrong username - Correct Password)
    When User provides 'cdegfcd@gmail.com','Guest1!' and click Login button
    Then User validate the error message 'Sign in Failed'
#
  Scenario: Negative Login(Empty username - Empty Password)
    When User provides '','' and click Login button
    Then User validate the error message 'Sign in Failed'