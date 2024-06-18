package us.deans.opp.jakarta;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("version")
public class OppResource {

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public OppVersion getVersion () {
        return new OppVersion("1.0.0");
    }

}
