@echo off

:: Using keycloak 19.0.2

set KEYCLOAK_ADMIN=admin
set KEYCLOAK_ADMIN_PASSWORD=admin
set keycloak_home="C:\Users\TO11RC\OneDrive - ING\miel\keycloak-19.0.2"

%keycloak_home%\bin\kc.bat start-dev --http-port 8180
