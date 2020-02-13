Feature: Create Role

  Background: Check Login
  	Given A user must be loggedin user "VAM Teste" password "Veloe#2020" in web page "http://localhost:3000/#/login"
# 	And try to delete role "VeloeTestAutomate"

  @newRole
	Scenario Outline: Create new role <name>
	  	Given a user access the role menu 
	  	And click on new role
	  	And input role name "<name>" and description "<description>"
	  	And select functionalities
		|funcVeloeTestOne | funcVeloeTestTwo | funcVeloeTestTree | funcVeloeTestFour | funcVeloeTestFive | funcVeloeTestSix |  
	  	And click on create new role
	  	Then check if role was successfully added
	  	#And close Create new role
  Examples:
    | name 						| description 				| 
    |    VeloeTestAutomateOne 	|   VeloeTestAutomDescOne	|
    |    VeloeTestAutomateTwo 	|   VeloeTestAutomDescTwo	|
    |    VeloeTestAutomateTree 	|   VeloeTestAutomDescTree	|
    |    VeloeTestAutomateFour 	|   VeloeTestAutomDescFour	|
    |    VeloeTestAutomateFive 	|   VeloeTestAutomDescFive	|
    |    VeloeTestAutomateSix 	|   VeloeTestAutomDescSix	|