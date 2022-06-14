# Sample project

## Swagger API document
### Include below dependency in pom.xml
```
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-ui</artifactId>
			<version>1.6.4</version>
		</dependency>
```
### Check in browser
http://localhost:8080/swagger-ui/index.html

## Docker

### Dockerfile
Dockerfile included in this project. You need to change <span style="color:red">package and application name</span> in ENTRYPOINT
```
ENTRYPOINT ["java","-cp","app:app/lib/*","com.sa.sample.project.SampleProjectApplication"]
```

### Docker build
Change your <span style="color:red">username</span> in https://hub.docker.com/
```
docker build --tag xocbayar/sample-project .
```
##### Result
> [+] Building 90.8s (18/18) FINISHED

### Docker push to docker hub
Change your <span style="color:red">username</span> in https://hub.docker.com/
```
docker push --all-tags xocbayar/sample-project
```
##### Result
>The push refers to repository [docker.io/xocbayar/sample-project]
8ccf80b306ba: Pushed
b94d198181e9: Pushed
7b85482b08d6: Pushed
dc9fa3d8b576: Mounted from xocbayar/discovery-service
27ee19dc88f2: Mounted from xocbayar/discovery-service
c8dd97366670: Mounted from xocbayar/discovery-service
Post "https://registry-1.docker.io/v2/xocbayar/sample-project/blobs/uploads/": net/http: TLS handshake timeout

### Check in docker hub
if it's succesfull pushed in hub. Please check https://hub.docker.com/repositories address exists.
![alt text](/final-project/BackEnd/sample-project/Docker%20hub%20sample%20project.png "Docker hub sample project")

## Kubernetes
#### Start minikube
```
minikube start
```
##### Result
> 😄  minikube v1.25.2 on Darwin 12.4
✨  Using the docker driver based on existing profile
👍  Starting control plane node minikube in cluster minikube
🚜  Pulling base image ...
🔄  Restarting existing docker container for "minikube" ...
🐳  Preparing Kubernetes v1.23.3 on Docker 20.10.12 ...
    ▪ kubelet.housekeeping-interval=5m
🔎  Verifying Kubernetes components...
    ▪ Using image kubernetesui/dashboard:v2.3.1
    ▪ Using image gcr.io/k8s-minikube/storage-provisioner:v5
    ▪ Using image kubernetesui/metrics-scraper:v1.0.7
🌟  Enabled addons: storage-provisioner, default-storageclass, dashboard
🏄  Done! kubectl is now configured to use "minikube" cluster and "default" namespace by default
#### Start minikube dashboard
```
minikube dashboard
```
##### Result
> 🤔  Verifying dashboard health ...
🚀  Launching proxy ...
🤔  Verifying proxy health ...
🎉  Opening http://127.0.0.1:51091/api/v1/namespaces/kubernetes-dashboard/services/http:kubernetes-dashboard:/proxy/ in your default browser...
### ConfigMap
Check config file in k8s/config folder
#### Apply DEV config
```
kubectl apply -f dev-configmap.yaml
```
##### Result
> configmap/spring-config created
#### Check ConfigMap is present 
```
kubectl get configmaps
```
##### Result

> NAME               DATA   AGE

> kube-root-ca.crt   1      3d13h

> spring-config      1      23m
### Secret
Check config file in k8s/secret folder

### Service discovery

### Apply app
```
kubectl apply -f sample-pod.yaml
```
##### Result
> pod/sample-project created
### Check the Pod is running
```
kubectl get pods
```
##### Result
> NAME             READY   STATUS   RESTARTS   AGE

> sample-project   0/1     Error    0          96m
### Port forward
```
kubectl port-forward pod/sample-project 8080:8080
```

### Check Pod is running
http://localhost:8080/

### Check Pod log
```
kubectl logs pod/sample-project
```