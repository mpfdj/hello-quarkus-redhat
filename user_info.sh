#!/bin/bash

token=$(curl -X POST 'http://localhost:60601/realms/quarkus/protocol/openid-connect/token' \
-H "Content-Type: application/x-www-form-urlencoded" \
-d "username=miel" \
-d 'password=miel' \
-d 'grant_type=password' \
-d 'client_id=my-api-client' | jq -r '.access_token')



#token=$(curl -X POST 'http://localhost:60601/realms/quarkus/protocol/openid-connect/token' \
#-H "Content-Type: application/x-www-form-urlencoded" \
#-d "username=jdoe" \
#-d 'password=jdoe' \
#-d 'grant_type=password' \
#-d 'client_id=quarkus-app' | jq -r '.access_token')



#token=$(curl -X POST 'http://localhost:8180/realms/keycloak-tutorial/protocol/openid-connect/token' \
#-H "Content-Type: application/x-www-form-urlencoded" \
#-d "username=miel" \
#-d 'password=miel' \
#-d 'grant_type=password' \
#-d 'client_id=my-api-client' | jq -r '.access_token')




#token="eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJDSlJYOVdqSjBtRFRzbnN3OG80WXlqWThHWlM3Zm1kUFdCeDFzVm1qYjc4In0.eyJleHAiOjE2NjM5NTk3MTIsImlhdCI6MTY2Mzk1OTQxMiwiYXV0aF90aW1lIjoxNjYzOTU5NDExLCJqdGkiOiIxYzQ3ZTBkZi0xNTcyLTQ1ZTQtYWY5Ni1kNjY5OGVlY2QzODAiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjUxNTkzL3JlYWxtcy9xdWFya3VzIiwic3ViIjoiMTZiNjQyN2EtOTAxMi00MTVhLTkyM2YtOWVjOWFiOWEwODgzIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoicXVhcmt1cy1hcHAiLCJub25jZSI6IjNGazRzZjkiLCJzZXNzaW9uX3N0YXRlIjoiNTYxNThlNWQtY2M5OS00NGFhLTk1YjUtOTE1Zjg3NjllYmU4IiwiYWNyIjoiMSIsInNjb3BlIjoib3BlbmlkIG1pY3JvcHJvZmlsZS1qd3QiLCJzaWQiOiI1NjE1OGU1ZC1jYzk5LTQ0YWEtOTViNS05MTVmODc2OWViZTgiLCJ1cG4iOiJqZG9lIiwiZ3JvdXBzIjpbIlN1YnNjcmliZXIiLCJ1c2VyIiwiY29uZmlkZW50aWFsIl19.gw-jG-eEH08TNk_mYhQfXnaQCdDxf3wTLMPwAdFyLttjSvTmQA-d_N1_55LpXFpCLqeO-b0AX0N2Cky382-aRTHWCm0PmG0HEC0Z3ZuIJiZAJj7nn5fIOgCX_Js6kJqLrX4wJJU3gYSKnSeDadLHrezOBGiXDZv7blVSZNb3HDNNE7n-g7Uf9Xgf3i34X6nmJcUGTTuzxMUiOYwxp7cqe-PxiyTlL1wQh25XKoRVQrJIqHVxfGlNC_EkJ6DyUblvAz9Qw7t6p0T_genQdDCCEtpdFxfgoM-Z-x2H6IqvUVGLsnAFXZU3ku9Ya7MqS1RTSEMkhZTUAc_cYpIv2_1MLQ"


echo $token





cmd.exe /c curl -v -H "Authorization: Bearer $token" http://localhost:8080/api/users/info
#cmd.exe /c curl -v -H "Authorization: Bearer $token" http://localhost:8080/api/users/jwt

#cmd.exe /c curl -v http://localhost:8080/api/users/info
