Setlocal EnableDelayedExpansion
@ECHO OFF
set version=0.4

docker build -t citi.cloud.demo:%version% .
rem docker run -ti citi.cloud.demo%version% sh