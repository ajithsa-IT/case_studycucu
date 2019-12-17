Feature: proceed to payment with and without adding to cart
Background: user logs in and searches for product
Given  user signin into the testmeapp 


Scenario: user proceeds to payment without adding to cart
When  user searches for the  particular product
Given user proceeds for payment without adding to the cart
Then TestMeApp doesnt display the cart icon without adding 

Scenario: user proceeds to payment after adding to cart
And user clicks the search tab & enters the first four letters of the product
And user selects product from the drop down
Then user proceeds for payment after adding to the cart
Then testmeapp displays the cart icon