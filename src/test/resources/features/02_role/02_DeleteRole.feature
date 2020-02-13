Feature: Delete Role

  @deleteRole
	Scenario Outline: Delete role <name>
	  	Given a user delete the role "<name>"
  Examples:
	| name 						| 
    |    VeloeTestAutomateOne 	|
    |    VeloeTestAutomateTwo 	|
    |    VeloeTestAutomateTree 	|
    |    VeloeTestAutomateFour 	|
    |    VeloeTestAutomateFive 	|
    |    VeloeTestAutomateSix 	|
    
    