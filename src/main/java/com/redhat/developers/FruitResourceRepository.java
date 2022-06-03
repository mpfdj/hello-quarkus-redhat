package com.redhat.developers;

import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;

@Path("/fruit-repository")
public class FruitResourceRepository {

    @Autowired
    FruitRepository fruitRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruit> fruits(@QueryParam("season") String season) {
        if (season != null) {
            return fruitRepository.findBySeason(season);
        }
        return Fruit.listAll();
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Fruit fruit) {
        fruit.id = null;
        fruit.persist();
        return Response.status(Status.CREATED).entity(fruit).build();
    }

}