
#1-Login successfully weborder page parameterize username and password in feature file

  #2 click the order box and next button
  #3 send invitees section to "I LOVE SELENIUM"
  #4 send inviteList "email@gmail.com" and "email2@gmail.com"
  #5 choose the delivery option "My House" and validate adress(contains) "3137 Laguna"
  #6 click group order button
  #7 Validate the header "View Group Order"(think about thread.sleep)
  #8 Validate the description contains(Your group order is now pending) from description


Feature: Testing group food order process for webOrder website

Scenario: Place the group order
    When User provides username,password and click Login button
    Then User select and start place the order for group
    Then User select 'My House' , validate '3137 Laguna' and click group order button
    When User fill up sections 'I love Selenium' , 'mehmet@gmail.com , ayse@gmail.com'
    Then User validate header 'View Group Order'
    And User validate if the description contains the 'Your group order is now pending'