FROM quay.io/keycloak/keycloak:19.0.2

ENV KEYCLOAK_ADMIN=admin
ENV KEYCLOAK_ADMIN_PASSWORD=admin

CMD ["start-dev"]
