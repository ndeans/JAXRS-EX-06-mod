package us.deans.opp.jakarta;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("version")
public class OppResource {

    Logger logger = LoggerFactory.getLogger(OppResource.class);

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public OppVersion getVersion () {
        String version = "1.0.1";
        logger.info("version: " + version);
        return new OppVersion(version);
    }
}
