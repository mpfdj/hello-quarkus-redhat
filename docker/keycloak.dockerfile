# https://stackoverflow.com/questions/71744615/keycloak-17-0-1-import-realm-on-docker-docker-compose-startup
# https://raw.githubusercontent.com/redhat-developer-demos/quarkus-tutorial/master/jwt-token/quarkus-realm.json


FROM quay.io/keycloak/keycloak:19.0.2

# Make the realm configuration available for import
COPY quarkus-realm.json /opt/keycloak_import/

# Import the realm and user
RUN /opt/keycloak/bin/kc.sh import --file /opt/keycloak_import/quarkus-realm.json

# Set environment variables
ENV KEYCLOAK_ADMIN=admin
ENV KEYCLOAK_ADMIN_PASSWORD=admin

# Import the realm on start-up
CMD ["start-dev"]