Feature: Delete User

  @deleteUser
	Scenario Outline: Delete User <cpf>
	  	Given user is deleted by name "<cpf>"
  Examples:
	| cpf 						| 
    |    45840916099 	|
   # |    VeloeTestAutoUserTwo 	|
   # |    VeloeTestAutoUserTree 	|
   # |    VeloeTestAutoUserFour 	|
   # |    VeloeTestAutoUserFive 	|
   # |    VeloeTestAutoUserSix 	|
    
    