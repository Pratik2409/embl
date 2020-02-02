# embl
Person Repository


This is person repository project. It uses in memory h2 database and store all information there.

This project has 4 endpoint expose for create,update,delete and read. below are the urls for same:

1. Retrive all person details:

Get call : http://localhost:9090/person/api/v1/persons
  
2. Get any person detail:

Get call : http://localhost:9090/person/api/v1/persons/1

3. Update person detail:

PUT call : http://localhost:9090/person/api/v1/person

4. Create person details:

POST call : http://localhost:9090/person/api/v1/person

5. Delete person details:

Delete call : http://localhost:9090/person/api/v1/person/1


Run this project first and then angular project. Angular project can be found at https://github.com/Pratik2409/emblAngularPerson.git

both project code has been pushed to develop branch. so please checkout develop branch of both project spring boot 
and Angular.

Dummy Payload:

{
    "person": [{
    	"first_name" : "Johns",
    	"last_name" : "Smiths",
    	"age" : "29",
    	"favorite_colour" : "red",
    	"hobby" : ["shopping","football"]
    },
    {
    	"first_name" : "Sarah",
    	"last_name" : "Connor",
    	"age" : "54",
    	"favorite_colour" : "blue",
    	"hobby" : ["chess"]
    }]
}

I have also added postman collection for api call. It will be in resources folder.