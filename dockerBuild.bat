Setlocal EnableDelayedExpansion
@ECHO OFF
set version=0.3

docker build -t citi.cloud.gatling:%version% .
rem docker run -ti citi.cloud.gatling:%version% sh