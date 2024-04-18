# Hotel Application

### Description
This Hotel Application is built as an backend API using Java Spring Boot
application lets you perform the following operations:
- Add Hotel
- Get all Hotels

Following is a description of each of the above operations and how to perform them.

#### 1. Add a Hotel
This is the first step to perform before using the application. The _username_ and _password_ are used for all the subsequesnt requests for authentication.

API Endpoint
```POST /hotel```

Body
```json
{
   "name":"Hotel Marina",
   "address":{
      "line1":"23 Marina Way",
      "city":"Richmond",
      "state":"CA",
      "country":"USA",
      "zip":"94804",
      "type":"HOTEL"
   },
   "rooms":[{"type":"SINGLE", "status":"AVAILABLE"},
      {"type":"SINGLE", "status":"AVAILABLE"},
      {"type":"SINGLE", "status":"AVAILABLE"},
      {"type":"SINGLE", "status":"AVAILABLE"},
      {"type":"DOUBLE", "status":"AVAILABLE"},
      {"type":"DOUBLE", "status":"AVAILABLE"},
      {"type":"SUITE", "status":"AVAILABLE"}]
}
```

Response
```json
Hotel added : Hotel Marina:2
```
#### 2. Get all Hotels
This call returns a list of all the Hotels and its properties like Address and Room details
API Endpoint
```GET /hotels```

Response
```json
[
   {
      "id": 1,
      "name": "Grand Bay New",
      "address": null,
      "rooms": [
         {
            "id": 1,
            "type": "SINGLE",
            "status": "AVAILABLE"
         },
         {
            "id": 2,
            "type": "DOUBLE",
            "status": "AVAILABLE"
         },
         {
            "id": 3,
            "type": "SUITE",
            "status": "AVAILABLE"
         }
      ],
      "roomCounts": {
         "DOUBLE": 1,
         "SINGLE": 1,
         "SUITE": 1
      }
   },
   {
      "id": 2,
      "name": "Hotel Marina",
      "address": {
         "id": 1,
         "line1": "23 Marina Way",
         "line2": null,
         "city": "Richmond",
         "state": "CA",
         "country": "USA",
         "zip": 94804,
         "type": "HOTEL"
      },
      "rooms": [
         {
            "id": 4,
            "type": "SINGLE",
            "status": "AVAILABLE"
         },
         {
            "id": 5,
            "type": "SINGLE",
            "status": "AVAILABLE"
         },
         {
            "id": 6,
            "type": "SINGLE",
            "status": "AVAILABLE"
         },
         {
            "id": 7,
            "type": "SINGLE",
            "status": "AVAILABLE"
         },
         {
            "id": 8,
            "type": "DOUBLE",
            "status": "AVAILABLE"
         },
         {
            "id": 9,
            "type": "DOUBLE",
            "status": "AVAILABLE"
         },
         {
            "id": 10,
            "type": "SUITE",
            "status": "AVAILABLE"
         }
      ],
      "roomCounts": {
         "DOUBLE": 2,
         "SINGLE": 4,
         "SUITE": 1
      }
   }
]
```


### Run the Hotel Application
1. For downloading and running the code, you should have the following installed on your system:
    * Java8 and above
    * Git or Gitbash
    * Maven
    * Docker
    * SQL
    * Liquibase

2. Checkout code from repository : ```git clone https://github.com/choudhury-abhishek29/<>```
3. This will create a directory `hotel`.
4. Go inside the directory `hotel` and checkout the `master` branch.
    ```
   cd hotel
   git checkout master
   ```
5. To setup the database,navigate to the following directory : ```hotel/src/main/resources/db/changelog``` 
6. Run ```liquibase update --username <username>``` 
7. This should successfully create the following tables:
   * hotel
   * room
   * address
   * booking
   * customer
   * reservation 