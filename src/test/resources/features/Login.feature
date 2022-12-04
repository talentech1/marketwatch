Feature: Login

	Scenario: User should able to login with valid credentials
		Given I am on the homepage
		 And I navigate to the login page
		When I enter valid username and password
		Then I should be logged in
	