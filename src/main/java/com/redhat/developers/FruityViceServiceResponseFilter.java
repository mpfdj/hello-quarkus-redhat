package com.redhat.developers;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;

@Provider
public class FruityViceServiceResponseFilter implements ClientResponseFilter {

//    https://www.tabnine.com/code/java/methods/javax.ws.rs.client.ClientResponseContext/getEntityStream




    @Inject
    Logger log;

    @Override
    public void filter(ClientRequestContext clientRequestContext, ClientResponseContext clientResponseContext) throws IOException {
        log.info("Response filter...");

//        We comment out the below. As this is causing the Unmarshaller exception. Unable to solve this :-(
//        2022-04-13 16:11:33,363 SEVERE [org.ecl.yas.int.Unmarshaller] (executor-thread-0) Invalid token=EOF at (line no=1, column no=0, offset=-1). Expected tokens are: [CURLYOPEN, SQUAREOPEN, STRING, NUMBER, TRUE, FALSE, NULL]
//        logJson(clientResponseContext);
    }





    private void logJson(ClientResponseContext responseContext) throws IOException {
        InputStream entityStream = responseContext.getEntityStream();

        if(entityStream != null && responseContext.getMediaType().isCompatible(MediaType.APPLICATION_JSON_TYPE)) {
            byte[] bytes = entityStream.readAllBytes();
            String json = new String(bytes);
            log.info(json);
        }
    }
}
