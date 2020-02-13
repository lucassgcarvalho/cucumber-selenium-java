Feature: Update Role

  Background: Check Login
  	Given A user must be loggedin user "VAM Teste" password "Veloe#2020" in web page "http://localhost:3000/#/login"
	    
  @updateRole
	Scenario Outline: Edit role
	  	Given a user access the role menu 
	  	And select a role "<name>"
	  	And click on edit role
	  	And change role description "<newDescription>"
	  	And change status
	  	And select functionalities to edit
	  		| funcVeloeTestOne | funcVeloeTestTree | funcVeloeTestSix |
	  	Then click on save edited role
	  	And check if role was successfully edited
  Examples:
    | 			name 			| 		newDescription 		| 
    |    VeloeTestAutomateOne 	|   VeloeTestAutomDescOne	|
    |    VeloeTestAutomateTwo 	|   VeloeTestAutomDescTwo	|
    |    VeloeTestAutomateTree 	|   VeloeTestAutomDescTree	|
    |    VeloeTestAutomateFour 	|   VeloeTestAutomDescFour	|
    |    VeloeTestAutomateFive 	|   VeloeTestAutomDescFive	|
    |    VeloeTestAutomateSix 	|   VeloeTestAutomDescSix	|
    