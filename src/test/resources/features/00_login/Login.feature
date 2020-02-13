Feature: Login

  @login
  Scenario Outline: Check Login
    Given A user navigates to login page "<loginPage>"
    And login fields are displayed
    And input user "<user>"
    And input password "<password>"
    And click on button login
 	Then check if user is logged-In
  Examples:
    | 	user 		|	password 	| loginPage 						|
    |    VAM Teste 	|   Veloe#2020	|	http://localhost:3000/#/login	|
