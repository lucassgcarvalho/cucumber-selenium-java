Feature: Access User

  Background: Check Login
  	Given A user must be loggedin user "VAM Teste" password "Veloe#2020" in web page "http://localhost:3000/#/login"

  @accessUser
  Scenario: Access User
  	Given access the User menu 
  	Then check if the header "Usuários" appears
      
    
    
    