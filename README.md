# Quarkus tutorial
https://redhat-developer-demos.github.io/quarkus-tutorial/quarkus-tutorial/index.html
https://github.com/redhat-developer-demos/quarkus-tutorial
https://www.graalvm.org/java/quickstart/

# Run docker image
docker run -ti -p 8080:8080 -v "C:/Users/TO11RC/OneDrive - ING/miel/workspace/Java/quarkus/quarkus-tutorial:/work" quay.io/rhdevelopers/tutorial-tools:0.0.4 bash

# Run project
mvn clean compile quarkus:dev

# Create project
mvn "io.quarkus:quarkus-maven-plugin:create" \
-DprojectGroupId="com.redhat.developers" \
-DprojectArtifactId="hello-quarkus-redhat" \
-DprojectVersion="1.0.0-SNAPSHOT" \
-DclassName="HelloResource" \
-Dpath="hello"
cd hello-quarkus-redhat

# Some curl commands
curl -X "GET" "http://localhost:8080/fruit?season=Summer" -H "accept: application/json"


# Multiple mechanisms present that use the same credential transport HttpCredentialTransport
https://github.com/quarkusio/quarkus/issues/10227






token=$(curl https://raw.githubusercontent.com/redhat-developer-demos/quarkus-tutorial/master/jwt-token/quarkus.jwt.token -s)
curl -H "Authorization: Bearer $token" localhost:8080/secure/claim


token=$(curl https://raw.githubusercontent.com/redhat-developer-demos/quarkus-tutorial/master/jwt-token/quarkus.jwt.token -s)
curl -v -H "Authorization: Bearer $token" localhost:8080/secure/claim



















# hello-quarkus-redhat Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/hello-quarkus-redhat-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
