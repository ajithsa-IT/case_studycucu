Feature: Search Functionality  

Background: Alex Login to TestMeApp
Given Alex Open the Browser and enters testmeapp
Given Alex Enters "lalitha" and "Password123"

  Scenario: Alex purchase product using Search Engine
    Given Alex types "head" in search bar  
    When Headphone appears for search and clicked
    And Alex add the product to cart
    And Checkout from cart
    Then Proceed with payment
    And Alex types "123456" and "Pass@456" for payment
    And transaction is made by entering "Trans@456"
    And Alex purchase the product succesfully

 