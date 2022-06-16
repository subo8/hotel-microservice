## Rate service

## Docker 

1. Build docker image
```
$ docker build --tag xocbayar/rate-service .
```
2. Push docker image to docker hub
```
$ docker push --all-tags xocbayar/rate-service
```

## Kubernetes
```
$ helm repo add bitnami https://charts.bitnami.com/bitnami
$ helm install hotel-mongodb --set auth.rootPassword=secretpassword bitnami/mongodb

$ kubectl create deployment rate-service --image=xocbayar/rate-service --dry-run=client -o=yaml > rate-deployment.yaml 

$ echo --- >> rate-deployment.yaml

$ kubectl create service loadbalancer rate-service --tcp=8099:8099 --dry-run=client -o=yaml >> rate-deployment.yaml

$ kubectl apply -f rate-deployment.yaml

$ minikube tunnel
$ kubectl port-forward svc/rate-service 8099:8099
```
### Application properties
```
spring.data.mongodb.uri=mongodb://root:secretpassword@hotel-mongodb.default.svc.cluster.local:27017/rate_DB?authSource=admin
```