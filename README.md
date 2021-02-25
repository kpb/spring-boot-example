# What is this?

A trivial Spring boot project used for demos, building pipelines, etc.

## Building

Using the Gradle wrapper:

    $ ./gradlew clean build

Or your own version of Gradle:

    $ gradle clean build

## Running

Using the Spring Boot Gradle task:

    $ ./gradlew bootRun
    
Running the jarfile:

    $ java -jar build/libs/spring-boot-example-0.0.1.jar
    
The default port is 8090, which you can change by setting an environment var:

    $ export server_port=9000
    
## Endpoints

_GET /hello_

    $ curl -i localhost:8090/hello
    HTTP/1.1 200 OK
    Content-Type: application/json
    
    {"greeting":"Hello World!"}
    
_POST /echo_

    $ curl -i localhost:8090/echo -H "Content-type: text/plain" -d "Hola!"
    HTTP/1.1 202 Accepted
    Content-Type: text/plain;charset=UTF-8

    Hola!
