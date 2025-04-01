#!/bin/bash

helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx

helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm repo update

helm install nginx-ingress ingress-nginx/ingress-nginx --create-namespace --namespace ingress-nginx

helm upgrade --install prometheus prometheus-community/kube-prometheus-stack \
  --namespace infnet-monitoring --create-namespace \
  --set adminUser=infnet \
  --set adminPassword=infnet \
  --set grafana.ingress.enabled=false \
  --set grafana.persistence.enabled=true \
  --set grafana.persistence.size=5Gi \
  --set prometheus.server.persistentVolume.enabled=true \
  --set prometheus.server.persistentVolume.size=10Gi \
  --set grafana.service.type=ClusterIP \
  --values values.yaml
