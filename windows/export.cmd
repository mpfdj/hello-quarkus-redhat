@echo off

set keycloak_home="C:\Users\TO11RC\OneDrive - ING\miel\keycloak-19.0.2"

:: Export realm with user data
%keycloak_home%\bin\kc.ba" export --dir . --realm quarkus --users realm_file
