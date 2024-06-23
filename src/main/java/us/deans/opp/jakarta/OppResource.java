package us.deans.opp.jakarta;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("version")
public class OppResource {

    Logger logger = LoggerFactory.getLogger(OppResource.class);

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public OppVersion getVersion () {
        return new OppVersion("1.0.0");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setPostList(OppPostList postList) {
        logger.info("Hellooo!");
        return Response.ok("Inserted...").build();
    }

}
