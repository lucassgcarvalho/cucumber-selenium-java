Feature: Update user

  Background:  Check Login
  	Given A user must be loggedin user "VAM Teste" password "Veloe#2020" in web page "http://localhost:3000/#/login"
	    
  @updateUser
	Scenario Outline: Update User <fullName>
	  	Given access the User menu
	  	And input the search value fullName "<fullNameSearch>" or cpf "<cpfSearch>" or e-mail "<emailSearch>" of "<searchType>"
	  	And click on search user
	  	And select user to be edited
	  	And click on edit user
	  	And input user edited fullName "<fullName>"
	  	And input user edited firstName "<firstName>"
	  	And input user edited lastName "<lastName>"
	  	#And input user edited cpf "<cpf>"
	  	And input user edited email "<email>"
	  	And change edited user status
	  	And click on save edit user
	  	Then check if user was successfully edited
  Examples:
	| searchType	| fullNameSearch 		|	cpfSearch	|	emailSearch					|	fullName 			| firstName 					|  lastName					|	cpf			|	email						|
	|   CPF			| TestFullNameOne 		| 45840916099 	|	testemailone@hotmail.com	| TestFullNameEditedOne |   TestFirstNameEditedOne		|	TestlstNameEditedOne	|	45840916099	|	testemailone@hotmail.com	|
    
	@updateCorrelationUser 
	Scenario Outline: Update Correlation User <fullName>
	  	Given access the User menu
	  	And input the search value fullName "<fullNameSearch>" or cpf "<cpfSearch>" or e-mail "<emailSearch>" of "<searchType>"
	  	And click on search user
	  	And select user to be edited
	  	And click on select client
	  	And select client from economic group
	  	And select account to edit correlation
	  	And click on button select account
	  	And check data filled in form
	  	And select roles to correlation
	  	And click on button effective correlations
	  	Then check if users correlations was successfully edited
  Examples:
	| searchType	| fullNameSearch 		|	cpfSearch	|	emailSearch					|	fullName 			| firstName 					|  lastName					|	cpf			|	email						|
	|   CPF			| TestFullNameOne 		| 45840916099 	|	testemailone@hotmail.com	| TestFullNameEditedOne |   TestFirstNameEditedOne		|	TestlstNameEditedOne	|	45840916099	|	testemailone@hotmail.com	|
    