Feature: Logout

  	Background: Login
  		Given A user must be loggedin user "VAM Teste" password "Veloe#2020" in web page "http://localhost:3000/#/login"
	
	@logout
	Scenario: execute logout 
	Given User is Logged in
	Then click on logout button
	And check if is already logged out
