# Clomb API

This API is used for rock climbers to track their climbs at various gyms.

## Using the API

## Users

URL: http://clomb-env.eba-kg7pg8ee.us-west-2.elasticbeanstalk.com/api/users

### Method: GET
Description: Retrieves all users or user by ID
Query Parameters: userID
Request Body: Not Applicable

Response:
* Status Code: 200 OK
* Response Body:
```dtd
[
        {
        "id": 1,
        "firstName": "bob",
        "lastName": "shmob",
        "email": "bob@mob.com",
        "shoes": "big red shoes",
        "chalk": "magic dust",
        "username": "bob123",
        "password": "bobpassword",
        "gender": "male",
        "createDate": "2024-07-21T14:13:59.000+00:00",
        "updateDate": "2024-07-21T14:14:47.000+00:00"
        },
        {
        "id": 2,
        "firstName": "kevin",
        "lastName": "shmevin",
        "email": "kev@shmev.com",
        "shoes": "medium blue shoes",
        "chalk": "fairy dust",
        "username": "kevin88",
        "password": "kevinpass",
        "gender": "male",
        "createDate": "2024-08-11T18:33:45.000+00:00",
        "updateDate": "2024-08-11T18:34:21.000+00:00"
        }
        ]
```
### Method: PUT
Description: Updates user by ID
Query Parameters: userID
Request Body: 

```dtd
{
        "firstName": "kevin",
        "lastName": "shmevin",
        "email": "kev@shmev.com",
        "shoes": "medium blue shoes",
        "chalk": "fairy dust",
        "username": "kevin88",
        "password": "kevinpass",
        "gender": "male"
}
```

Response:
* Status Code: 200 OK
* Response Body:
```dtd
{
    "id": 2,
    "firstName": "kevin",
    "lastName": "shmevin",
    "email": "kev@shmev.com",
    "shoes": "medium blue shoes",
    "chalk": "fairy dust",
    "username": "kevin88",
    "password": "kevinpass",
    "gender": "male",
    "createDate": "2024-08-11T18:33:45.000+00:00",
    "updateDate": "2024-08-11T18:34:21.357+00:00"
}
```

### Method: POST
Description: Creates a new User
Request Body: 
```dtd
{
    "firstName": "kevin",
    "lastName": "shmevin",
    "email": "kev@shmev.com",
    "shoes": "medium blue shoes",
    "chalk": "fairy dust",
    "username": "kevin88",
    "password": "kevinpass",
    "gender": "male"
}

```

Response:
* Status Code: 201 Created
* Response Body:

```
{
    "id": 2,
    "firstName": "kevin",
    "lastName": "shmevin",
    "email": "kev@shmev.com",
    "shoes": "medium blue shoes",
    "chalk": null,
    "username": "kevin88",
    "password": "kevinpass",
    "gender": "male",
    "createDate": "2024-08-11T18:33:44.591+00:00",
    "updateDate": "2024-08-11T18:33:44.591+00:00"
}
```

### Method: DELETE
Description: Deletes user  by ID
Query Parameters: userID
Request Body: Not Applicable

Response:
* Status Code: 200 OK
* Response Body:
Successfully deleted user with id 3





## Gyms

URL: http://clomb-env.eba-kg7pg8ee.us-west-2.elasticbeanstalk.com/api/gyms

### Method: GET
Description: Retrieves all gyms or gym by ID
Query Parameters: gymID
Request Body: Not Applicable

Response:
* Status Code: 200 OK
* Response Body:
```dtd
[
        {
        "id": 1,
        "gymName": "dave's climbing",
        "gymAddress": "123 dave street",
        "gymCreateDate": "2024-08-11T18:45:34.000+00:00",
        "gymUpdateDate": "2024-08-11T18:45:34.000+00:00"
        },
        {
        "id": 2,
        "gymName": "steve's climbing",
        "gymAddress": "567 steve street",
        "gymCreateDate": "2024-08-11T18:45:58.000+00:00",
        "gymUpdateDate": "2024-08-11T18:46:19.000+00:00"
        }
        ]
```
### Method: PUT
Description: Updates gym by ID
Query Parameters: gymID
Request Body:

```dtd
{
        "gymName": "steve's climbing",
        "gymAddress": "567 steve street"

        }
```

Response:
* Status Code: 200 OK
* Response Body:
```dtd
{
        "id": 2,
        "gymName": "steve's climbing",
        "gymAddress": "567 steve street",
        "gymCreateDate": "2024-08-11T18:45:58.000+00:00",
        "gymUpdateDate": "2024-08-11T18:46:18.599+00:00"
        }
```

### Method: POST
Description: Creates a new Gym
Request Body:
```dtd
{
        "gymName": "sams's climbing",
        "gymAddress": "999 sam street"
        }

```

Response:
* Status Code: 201 Created
* Response Body:

```
{
    "id": 3,
    "gymName": "sams's climbing",
    "gymAddress": "999 sam street",
    "gymCreateDate": "2024-08-11T18:48:43.684+00:00",
    "gymUpdateDate": "2024-08-11T18:48:43.684+00:00"
}
```

### Method: DELETE
Description: Deletes gym  by ID
Query Parameters: gymID
Request Body: Not Applicable

Response:
* Status Code: 200 OK
* Response Body:
  Successfully deleted gym with id 3



## Routes

URL: http://clomb-env.eba-kg7pg8ee.us-west-2.elasticbeanstalk.com/api/routes

### Method: GET
Description: Retrieves all gyms or gym by ID
Query Parameters: gymID
Request Body: Not Applicable

Response:
* Status Code: 200 OK
* Response Body:
```dtd
[
        {
        "id": 1,
        "gymName": "dave's climbing",
        "gymAddress": "123 dave street",
        "gymCreateDate": "2024-08-11T18:45:34.000+00:00",
        "gymUpdateDate": "2024-08-11T18:45:34.000+00:00"
        },
        {
        "id": 2,
        "gymName": "steve's climbing",
        "gymAddress": "567 steve street",
        "gymCreateDate": "2024-08-11T18:45:58.000+00:00",
        "gymUpdateDate": "2024-08-11T18:46:19.000+00:00"
        }
        ]
```
### Method: PUT
Description: Updates gym by ID
Query Parameters: gymID
Request Body:

```dtd
{
        "gymName": "steve's climbing",
        "gymAddress": "567 steve street"

        }
```

Response:
* Status Code: 200 OK
* Response Body:
```dtd
{
        "id": 2,
        "gymName": "steve's climbing",
        "gymAddress": "567 steve street",
        "gymCreateDate": "2024-08-11T18:45:58.000+00:00",
        "gymUpdateDate": "2024-08-11T18:46:18.599+00:00"
        }
```

### Method: POST
Description: Creates a new Gym
Request Body:
```dtd
{
        "gymName": "sams's climbing",
        "gymAddress": "999 sam street"
        }

```

Response:
* Status Code: 201 Created
* Response Body:

```
{
    "id": 3,
    "gymName": "sams's climbing",
    "gymAddress": "999 sam street",
    "gymCreateDate": "2024-08-11T18:48:43.684+00:00",
    "gymUpdateDate": "2024-08-11T18:48:43.684+00:00"
}
```

### Method: DELETE
Description: Deletes gym  by ID
Query Parameters: gymID
Request Body: Not Applicable

Response:
* Status Code: 200 OK
* Response Body:
  Successfully deleted gym with id 3