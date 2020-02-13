Feature: Access Functionality

	Background:
	  Given A user must be loggedin user "VAM Teste" password "Veloe#2020" in web page "http://localhost:3000/#/login"

  @accessFunctionality
  Scenario: Access functionality
  	Given A user access the functionality menu 
  	When user select a functionality
  	Then check if role appears is equals to functionality
  	