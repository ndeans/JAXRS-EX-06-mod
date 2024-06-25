package us.deans.opp.jakarta;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Path("upload")
public class OppUpload {

    Logger logger = LoggerFactory.getLogger(OppUpload.class);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setPostList(List<OppPost> postList) {
        OppProcessor processor = new OppProcessor(postList);
        processor.printDataToLog();
        String msg = "inserting " + postList.size() + " post records...";
        logger.info(msg);
        return Response.ok(msg).build();
    }

}
