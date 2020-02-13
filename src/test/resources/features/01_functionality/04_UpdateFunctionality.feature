Feature: Update Functionality

	Background:
	  Given A user must be loggedin user "VAM Teste" password "Veloe#2020" in web page "http://localhost:3000/#/login"
	    
  @updateFunctionality @active
  Scenario Outline: Edit functionality <name> - Activating
  	Given A user access the functionality menu
  	And select a functionality "<name>" to edit 
  	And click on edit functionality
  	And wait the popUp edit functionality
  	And input description "<description>"
  	And change the status "<status>"
  	And click on save button to edit functionality
  	Then check if functionality was successfully edited
  Examples:
    | 			name 		|			description 			|	status	|
    |    funcVeloeTestOne 	|   funcVeloeTestOneDescUpdated		|	ativo	|
    |    funcVeloeTestTwo 	|   funcVeloeTestTwoDescUpdated		|	ativo	|
    |    funcVeloeTestTree 	|   funcVeloeTestTreeDescUpdated	|	ativo	|
    |    funcVeloeTestFour 	|   funcVeloeTestFourDescUpdated	|	ativo	|
    |    funcVeloeTestFive 	|   funcVeloeTestFiveDescUpdated	|	ativo	|
    |    funcVeloeTestSix 	|   funcVeloeTestSixDescUpdated		|	ativo	|
    
    
    
  #@editFunctionality @inactive @editFunctionalityIgnoreScenario
  #Scenario Outline: Edit functionality <name> - Inactivating
  #	Given A user access the functionality menu
  #	And select a functionality "<name>" to edit 
  #	And click on edit functionality
  #	And wait the popUp edit functionality
  #	And input description "<description>"
  #	And change the status "<status>"
  #	And click on save button to edit functionality
  #	Then check if functionality was successfully edited
  #	And close Edit functionality
  #Examples:
  # | 			name 		|			description 			|	status	|
  #  |    funcVeloeTestOne 	|   funcVeloeTestOneDescUpdated		|	inativo	|
  #  |    funcVeloeTestTwo 	|   funcVeloeTestTwoDescUpdated		|	inativo	|
  #  |    funcVeloeTestTree 	|   funcVeloeTestTreeDescUpdated	|	inativo	|
  #  |    funcVeloeTestFour 	|   funcVeloeTestFourDescUpdated	|	inativo	|
  #  |    funcVeloeTestFive 	|   funcVeloeTestFiveDescUpdated	|	inativo	|
  #  |    funcVeloeTestSix 	|   funcVeloeTestSixDescUpdated		|	inativo	|
