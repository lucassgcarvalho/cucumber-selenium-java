Feature: Create User

  Background: Check Login
  	Given A user must be loggedin user "VAM Teste" password "Veloe#2020" in web page "http://localhost:3000/#/login"

  @newUser
	Scenario Outline: Create new User <fullName>
	  	Given access the User menu 
	  	And click on new user
	  	And input user fullName "<fullName>"
	  	And input user firstName "<firstName>"
	  	And input user lastName "<lastName>"
	  	And input user cpf "<cpf>"
	  	And input user email "<email>"
	  	And click on create new user
	  	Then check if user was successfully created
  Examples:
	| fullName 					| firstName 				|  lastName			|	cpf			|	email						|
    |    TestFullNameOne 		|   TestFirstNameOne		|	TestlstNameOne	|	45840916099	|	testemailone@hotmail.com	|
	#|    TestFullNameTwo 		|   TestFirstNameTwo		|	TestlstNameTwo	|	45840916099	|	TestEmailTwo@hotmail.com	|
	