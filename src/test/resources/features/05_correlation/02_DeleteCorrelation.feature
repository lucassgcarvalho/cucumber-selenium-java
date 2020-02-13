Feature: Delete Correlation user

	Background: Check Login
  		Given A user must be loggedin user "VAM Teste" password "Veloe#2020" in web page "http://localhost:3000/#/login"

	@deleteCorrelationUser 
	Scenario Outline: Delete Correlation User <fullName>
	  	Given access the User menu
	  	And input the search value fullName "<fullNameSearch>" or cpf "<cpfSearch>" or e-mail "<emailSearch>" of "<searchType>"
	  	And click on search user
	  	And select user to delete correlation 
	  	Then delete correlations
  Examples:
	| searchType	| fullNameSearch 		|	cpfSearch	|	emailSearch					|	fullName 			| firstName 					|  lastName					|	cpf			|	email						|
	|   CPF			| TestFullNameOne 		| 45840916099 	|	testemailone@hotmail.com	| TestFullNameEditedOne |   TestFirstNameEditedOne		|	TestlstNameEditedOne	|	45840916099	|	testemailone@hotmail.com	|
    
    
    