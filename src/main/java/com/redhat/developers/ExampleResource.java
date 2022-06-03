package com.redhat.developers;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
import java.util.NoSuchElementException;

@Path("/example")
@Produces("text/plain")
public class ExampleResource {

    private final MeterRegistry registry;

    LinkedList<Long> list = new LinkedList<>();

    // Update the constructor to create the gauge
    ExampleResource(MeterRegistry registry) {
        this.registry = registry;
        registry.gaugeCollectionSize("example.list.size", Tags.empty(), list);
//        registry.gaugeCollectionSize("miel", Tags.empty(), list);
    }

    @GET
    @Path("gauge/{number}")
    @Produces(MediaType.TEXT_PLAIN)
    public Long checkListSize() {
//        if (number == 2 || number % 2 == 0) {
//            // add even numbers to the list
//            list.add(number);
//        } else {
//            // remove items from the list for odd numbers
//            try {
//                number = list.removeFirst();
//            } catch (NoSuchElementException nse) {
//                number = 0;
//            }
//        }
        return -1L;
    }
}