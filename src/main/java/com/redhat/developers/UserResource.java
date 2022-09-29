package com.redhat.developers;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.stream.Collectors;

@Path("api/users")
public class UserResource {

    @Inject
    JsonWebToken jwt;

    @Inject
    Logger log;

    @GET
    @Path("info")
    @RolesAllowed({"Subscriber", "manager"})
    public String getInfo() {
        log.info("Printing JWT claimNames: " + jwt.getClaimNames().stream().sorted().collect(Collectors.toList()));
        log.info("Printing JWT address claim: " + jwt.getClaim("address"));
        log.info("Printing JWT: " + jwt.toString());
        return "Access for subject " + jwt.getName() + " is granted";
    }

    @GET
    @Path("jwt")
    public void printJwt() {
        log.info("Printing JWT: " + jwt.toString());
    }


}