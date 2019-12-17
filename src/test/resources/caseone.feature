
Feature: Registration Process

  Scenario: User Registration
  
  Given Enter the URL
  When  User enters his name as "jacki2231623"
  And FirstName as "santhosh"
  And LastName as "narayan"
  And Password as "samuel" 
  And Confirms as "samuel"
  And select Gender as Male
  And EmailID as "sammy@gmail.com"
  And Mobile Number as "8762349989"
  And DOB is entered as "01/12/1998"
  And Address is entered as "New Edappadi Road,Chennai"
  Then Security Question is selected as What is your favour color?
  And  Answer as "red"
  Then User Clicks on Register Button
  Then User Registration is Successful
   