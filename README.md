# Pokedex
Pokemon app where the main stats of 20 Pokemon by page are being displayed. 


-------------------------------------------------------------------------------------------------------------------------------
Architecture 

Flask-web-app
      |
Spring-Java-Rest-Api
      |
 Poke api 
 ------------------------------------------------------------------------------------------------------------------------------

#Back end --> Developed in Spring Java 

REST API: Home_controller.java   --< package com.rest_poke.backend.Home_controller; 
   
   HTTP Request GET --> Parameters: off: is the offset of the pokemon list the rest api is fetching from the Poke Api, as default it will start in 0
   if no parameter is given. 
   
   it will send an array of Pokemon objetcs  (Pokemon Class) to the requester in a json format. 
   
   
#Front end --> Developed in Flask Python

Sends a get request to our REST API with the correct parameters (off) in order to get the pokemon objects and display them in a web app. 


   
