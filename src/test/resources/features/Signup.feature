Feature: SignUp 

	@iframe
  Scenario Outline: Negative Email Signup
  	Given I am on the signup page
    When I enter my "<email>"
     And click create an account
    Then I should see an error
     And I should be on the signup page
 		
 		Examples:
 			|email|
 			|abc@gmail|
 			|a bc@gmail.com|
 			|$#$@gmail.com|
 			