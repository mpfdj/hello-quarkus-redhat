package com.redhat.developers;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;
import java.util.stream.Collectors;

@Path("/fruit")
public class FruitResource {


    @Inject
    Logger log;

    @RestClient
    FruityViceService fruityViceService;

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response newFruit(Fruit fruit) {
        fruit.id = null;
        fruit.persist();
        return Response.status(Status.CREATED).entity(fruit).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FruitDTO> fruits(@QueryParam("season") String season) {

        log.info("season: " + season);

//        List<Fruit> fruits = Fruit.findBySeason(season);
//
//        FruityVice mango = fruityViceService.getFruitByName("Mango");
//        FruityVice strawberry = fruityViceService.getFruitByName("Strawberry");
//
//        return null;

        if (season != null) {
            List<FruitDTO> fruits = Fruit.findBySeason(season).stream()
                    .map(fruit -> FruitDTO.of(fruit, fruityViceService.getFruitByName(fruit.name)))
                    .collect(Collectors.toList());

            log.info(fruits);
            return fruits;
        }
        return Fruit.<Fruit>listAll().stream()
                .map(fruit -> FruitDTO.of(fruit, fruityViceService.getFruitByName(fruit.name)))
                .collect(Collectors.toList());
    }

}