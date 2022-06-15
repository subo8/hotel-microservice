## Payment service

## Docker 

1. Build docker image
```
$ docker build --tag xocbayar/payment-service .
```
2. Push docker image to docker hub
```
$ docker push --all-tags xocbayar/payment-service
```

## Kubernetes
```
$ helm repo add bitnami https://charts.bitnami.com/bitnami
$ helm install hotel-payment-mongodb \
    --set auth.rootPassword=secretpassword,auth.username=hoteluser,auth.password=hotelpass,auth.database=payment_DB \
    bitnami/mongodb

$ kubectl create deployment payment-service --image=xocbayar/payment-service --dry-run=client -o=yaml > payment-deployment.yaml 

$ echo --- >> payment-deployment.yaml

$ kubectl create service clusterip payment-service --tcp=9004:9004 --dry-run=client -o=yaml >> payment-deployment.yaml

$ kubectl apply -f payment-deployment.yaml

$ kubectl port-forward svc/payment-service 9004:9004
```
### Application properties
```
spring.data.mongodb.uri=mongodb://hoteluser:hotelpass@hotel-payment-mongodb.default.svc.cluster.local:27017/payment_DB
```