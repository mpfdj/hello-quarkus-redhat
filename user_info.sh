#!/bin/bash

# Using keycloak docker image
token=$(cmd.exe /c curl -X POST 'http://localhost:8180/realms/quarkus/protocol/openid-connect/token' \
-H "Content-Type: application/x-www-form-urlencoded" \
-d "username=miel" \
-d 'password=miel' \
-d 'grant_type=password' \
-d 'client_id=quarkus-app' | jq -r '.access_token')



# Change port number, using embedded keycloak server here...
#token=$(cmd.exe /c curl -X POST 'http://localhost:60601/realms/quarkus/protocol/openid-connect/token' \
#-H "Content-Type: application/x-www-form-urlencoded" \
#-d "username=jdoe" \
#-d 'password=jdoe' \
#-d 'grant_type=password' \
#-d 'client_id=quarkus-app' | jq -r '.access_token')



echo $token



# Expecting a 200 OK
cmd.exe /c curl -v -H "Authorization: Bearer $token" http://localhost:8080/api/users/info
