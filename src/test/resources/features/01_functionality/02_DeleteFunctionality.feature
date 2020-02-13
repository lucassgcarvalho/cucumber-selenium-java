Feature: Delete Functionality

  @deleteFunctionality
  Scenario Outline: Delete functionality <name>
  	Given a user delete a functionality "<name>"
  Examples:
   	| 		   name 		| 
  	|    funcVeloeTestOne 	|   
    |    funcVeloeTestTwo 	|   
    |    funcVeloeTestTree 	|   
    |    funcVeloeTestFour 	|   
    |    funcVeloeTestFive 	|   
    |    funcVeloeTestSix 	|  
  	
  	
  	