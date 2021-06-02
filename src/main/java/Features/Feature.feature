Feature: Sign Up 

Scenario: Sign Up Scenario
		Given User is on the Application Home Page 
		When Application Page Title is PHP Travels
		Then user clicks MY ACCOUNT 
		And user clicks on Sign Up Link
		When User navigate to Sign Up page
		Then user enters personal data and the entered values are validated 
		| Sample | Name | 1144556633 | sample@testmail.com | sample@123| Sample@123 |
		
		Then click on Sign Up button
		Then Close the Browser