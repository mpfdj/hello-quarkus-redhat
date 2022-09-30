@echo off

:: Delete h2 database
set keycloak_home="C:\Users\TO11RC\OneDrive - ING\miel\keycloak-19.0.2\data"

del /s /q %keycloak_home%\*"
rmdir %keycloak_home%\h2"
rmdir %keycloak_home%
