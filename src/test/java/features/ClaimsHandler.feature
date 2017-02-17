
  Feature: Claims Handler

    Scenario: Create new case
      When user log in to https://supplier01.scalepoint.com/eccAdmin/gb/login.action with username set_user_here and password set_password_here
      And create new case for default customer
      Then add new item
      And fill customer information
      Then email should be sent