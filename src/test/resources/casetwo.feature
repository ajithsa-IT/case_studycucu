Feature: SignUp

  Scenario Outline: Login
    Given click on the URL
    And  click on the signIn
    And   enter the "<username>" and "<password>" 
    When  click on login
    Then open home page
    Examples: 
      | username  |   password      | 
      | lalitha   |   Password123  | 

