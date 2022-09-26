# Keycloak
Realm (quarkus)
Client (test-client) > Client Scopes > microprofile-jwt
Client Scopes >  microprofile-jwt > Mappers (upn, groups, user_address)
Roles > add role (manager)
Users > Role Mappings


curl --location --request POST 'http://localhost:60601/realms/quarkus/protocol/openid-connect/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'username=miel2' \
--data-urlencode 'password=miel2' \
--data-urlencode 'grant_type=password' \
--data-urlencode 'client_id=test-client'


# Online JWT debugger tool https://jwt.io/