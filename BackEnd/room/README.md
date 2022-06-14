
## Room service

### Admin can create, update and delete room data


### Create Room

~~~
POST http://localhost:8088/room/
Content-Type: application/json


{
    "roomId":2,
    "roomNumber":"303",
    "type" : "Delux",
    "price" : 150
}
~~~

### Delete Room
~~~
DELETE http://localhost:8088/room/1

~~~

## Update Room

~~~
PUT http://localhost:8088/room/2
Content-Type: application/json

{
    "roomId":2,
    "roomNumber":"303",
    "type" : "Delux",
    "price" : 160
}


~~~
### Show All Rooms
~~~
GET http://localhost:8088/room/
Content-Type: application/json
~~~



>>>>>>> Stashed changes
