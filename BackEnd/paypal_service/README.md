## Paypal service

## Docker 

1. Build docker image
```
docker build --tag xocbayar/paypal-service .
```
2. Push docker image to docker hub
```
docker push --all-tags xocbayar/paypal-service
```

## Kubernetes
```
$ helm repo add cnieg https://cnieg.github.io/helm-charts
$ helm install BankAccountDb cnieg/h2-database --version 1.0.3
$ helm install paypal-db cnieg/h2-database --version 1.0.3

$ kubectl create deployment paypal-service --image=xocbayar/paypal-service --dry-run=client -o=yaml > paypal-deployment.yaml 

$ echo --- >> paypal-deployment.yaml

$ kubectl create service clusterip paypal-service --tcp=9002:9002 --dry-run=client -o=yaml >> paypal-deployment.yaml

$ kubectl apply -f paypal-deployment.yaml

$ kubectl port-forward svc/paypal-service 9002:9002
```
### Application properties
```
spring.data.mongodb.uri=mongodb://hoteluser:hotelpass@hotel-paypal-mongodb.default.svc.cluster.local:27017/paypal_DB
```