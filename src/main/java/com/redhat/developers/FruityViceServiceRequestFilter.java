package com.redhat.developers;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class FruityViceServiceRequestFilter implements ClientRequestFilter {

    @Inject
    Logger log;

    @Override
    public void filter(ClientRequestContext clientRequestContext) {
        log.info("Uri is " + clientRequestContext.getUri().toString());
//        log.info("This is the request filter...");
    }
}
