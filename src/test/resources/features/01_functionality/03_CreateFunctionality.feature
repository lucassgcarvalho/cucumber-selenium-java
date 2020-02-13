Feature: Create Functionality

	Background:
	  Given A user must be loggedin user "VAM Teste" password "Veloe#2020" in web page "http://localhost:3000/#/login"
  	
  @newFunctionality
	Scenario Outline: Create new functionality <name>
	  	Given A user access the functionality menu 
	  	And click on new functionality
	  	And wait the popUp create new functionality
	  	And input name "<name>" and description "<description>"
	  	And click on create new functionality
	  	Then check if functionality was successfully added
	  	#And close Create new functionality
  Examples:
    | name 					| description 				| 
    |    funcVeloeTestOne 	|   funcVeloeTestOneDesc	|
    |    funcVeloeTestTwo 	|   funcVeloeTestTwoDesc	|
    |    funcVeloeTestTree 	|   funcVeloeTestTreeDesc	|
    |    funcVeloeTestFour 	|   funcVeloeTestFourDesc	|
    |    funcVeloeTestFive 	|   funcVeloeTestFiveDesc	|
    |    funcVeloeTestSix 	|   funcVeloeTestSixDesc	|
    
  	