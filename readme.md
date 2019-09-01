INTRODUCTION
=============
This is a Spring Boot microservice that call external 3rd party API to validate phone number.
It exposes REST API for client program to involve and validate phone number; it return the response in JSON format.

HOW TO BUILD
==============
it is built using maven, the output jar file will be output to target directory
command:
./mvnw clean package


HOW TO RUN
=============
command:
java -jar target/validator-0.0.1-SNAPSHOT.jar


DOCKER support
==================
if it is run in containerized environment, please build with maven and run as below:


command to build:
./mvnw install dockerfile:build

command to run as below, e.g. server run in port 8080 and docker image tagged as com.jy/validator:
docker run -p 8080:8080 -t com.jy/validator

command to stop:
To get container id, run:
docker ps

To stop the container, e.g. id : 81c723d22865, run:
docker stop 81c723d22865



HOW to USE
==============
using http GET method

format: http://localhost:8080/api/phoneValidation/{phone}
where {phone} is phone number in hong kong

example:
http://localhost:8080/api/phoneValidation/38441434

result:
the response is JSON format to indicate it is valid phone number or not; with other information as well.
example:
{
    "valid": true,
    "number": "85238441434",
    "local_format": "38441434",
    "international_format": "+85238441434",
    "country_prefix": "+852",
    "country_code": "HK",
    "country_name": "Hong Kong, China",
    "location": "",
    "carrier": "",
    "line_type": "landline"
}

LIMITATION
=============
It is supporting phone number in Hong Kong only.


System design
==============
please refer to system-design.txt

