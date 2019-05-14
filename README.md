# fonix technical interview exercise 

The JAR in the tech folder.

The port is 8090 and the context root is /bestoffer. 

Go to localhost:8090/bestoffer/swagger-ui to consult the available rest services. 

api/flights is the endpoint for the crawler. 


I used Java8, Spring and H2 for the backend, Static html and jquery for front-end.

I made the following assumptions:

  - The user inserts origin and destination values that are equivalent in format to the ones inserted by the crawler.
  - There is no need for instant updates, and instead a minimum interval of an hour is acceptable.
  - An email registered to offersf or a specific route can have only one frequency.
  - The crawler can update previously inserted flights with a new price. That means that the best price can go up amd down.
  
  
  Kindest regards,
  
  Guido Pintus


  
