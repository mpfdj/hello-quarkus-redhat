package com.redhat.developers;

import org.eclipse.microprofile.faulttolerance.*;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.redhat.developers.FruityVice.Nutritions;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/fruit")
@RegisterRestClient
//@RegisterProvider(FruityViceServiceRequestFilter.class)
//@RegisterProvider(FruityViceServiceResponseFilter.class)
public interface FruityViceService {

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
//    @Retry(maxRetries = 3, delay = 2000)
//    @Fallback(FruityViceFallback.class)
    @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.75, delay = 5000)
    FruityVice getFruitByName(@PathParam("name") String name);

    public static class FruityViceFallback implements FallbackHandler<FruityVice> {

        private static final FruityVice EMPTY_FRUITY_VICE = FruityVice.of("empty", Nutritions.of(0.0, 0.0));
        @Override
        public FruityVice handle(ExecutionContext context) {
            return EMPTY_FRUITY_VICE;
        }

    }

}