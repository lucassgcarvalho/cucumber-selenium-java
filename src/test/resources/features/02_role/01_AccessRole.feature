Feature: Access Role

  Background: Check Login
  	Given A user must be loggedin user "VAM Teste" password "Veloe#2020" in web page "http://localhost:3000/#/login"

  @functionality
  Scenario: Access Role
  	Given a user access the role menu 
  	When user select a role
  	Then check if functionality appears is equals to role description  
  	And close access role
      
    
    
    