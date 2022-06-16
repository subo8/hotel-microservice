git# Room service
Admin can create, update and delete room data

## Docker 

1. Build docker image
```
$ docker build --tag xocbayar/room-service .
```
2. Push docker image to docker hub
```
$ docker push --all-tags xocbayar/room-service
```

## Kubernetes
```
$ helm repo add bitnami https://charts.bitnami.com/bitnami
$ helm install hotel-mongodb --set auth.rootPassword=secretpassword bitnami/mongodb

$ kubectl create deployment room-service --image=xocbayar/room-service --dry-run=client -o=yaml > room-deployment.yaml 

$ echo --- >> room-deployment.yaml

$ kubectl create service loadbalancer room-service --tcp=8088:8088 --dry-run=client -o=yaml >> room-deployment.yaml

$ kubectl apply -f room-deployment.yaml

$ minikube tunnel
$ kubectl port-forward svc/room-service 8088:8088
```
### Application properties
```
spring.data.mongodb.uri=mongodb://root:secretpassword@hotel-mongodb.default.svc.cluster.local:27017/room_DB?authSource=admin
```

## Endpoints
### Create Room

~~~
POST http://localhost:8088/room/
Content-Type: application/json

{
    "roomNumber": 601,
    "type": "Single",
    "price": 120.0,
    "bedType": null,
    "numberOfBeds": null,
    "maxNumberOfGuests": null,
    "smoking": false,
    "description": null,
    "available": false,
    "roomRating":null,
    "totalRatings": 1
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
