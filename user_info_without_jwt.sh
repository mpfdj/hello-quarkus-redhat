#!/bin/bash

# Expecting a 401 Unauthorized
cmd.exe /c curl -v http://localhost:8080/api/users/info
