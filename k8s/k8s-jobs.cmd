@echo off

kubectl delete job gatling
kubectl delete pod web
kubectl delete svc gatling-results

kubectl create -f pvc.yaml
kubectl create -f web-job.yaml
kubectl create -f gatling-job.yaml

echo:
echo VOLUMES
kubectl get pvc

echo:
echo SERVICES
kubectl get svc

echo:
echo PODS
kubectl get pods