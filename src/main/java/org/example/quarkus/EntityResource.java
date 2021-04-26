package org.example.quarkus;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.OK;

@ApplicationScoped
@Path("/entities")
public class EntityResource {

    @Inject
    EntityRepository repository;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response listAll() {
        List<ConcreteEntity> entities = repository.listAll();
        return Response.status(OK).entity(entities).build();
    }
}
