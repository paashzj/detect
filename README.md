# detect
[![Docker Pulls](https://img.shields.io/docker/pulls/ttbb/detect)](https://hub.docker.com/ttbb/detect/latest)
[![Docker Image Size](https://img.shields.io/docker/image-size/ttbb/detect/latest)](https://hub.docker.com/ttbb/detect/latest)
## usage
you can use docker image or target jar to run detect
### run image
```bash
docker run ttbb/detect java --log-level info --detect-type CONNECT_PRODUCER kafka --bootstrap-servers localhost:9092
```
### run jar
```bash
java -jar detect-executable.jar --log-level info --detect-type CONNECT_PRODUCER kafka --bootstrap-servers localhost:9092
```
### detect kafka server can CONNECT_PRODUCER
```bash
--log-level info --detect-type CONNECT_PRODUCER kafka --bootstrap-servers localhost:9092
```
### detect pulsar server can CONNECT_PRODUCER
```bash
--log-level info --detect-type CONNECT_PRODUCER pulsar --service-url pulsar://localhost:6650
```
