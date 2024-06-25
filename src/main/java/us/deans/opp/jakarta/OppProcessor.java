package us.deans.opp.jakarta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class OppProcessor {

    private final List<OppPost> postList;
    Logger logger = LoggerFactory.getLogger(OppUpload.class);

    public OppProcessor(List<OppPost> postList) {
        this.postList = postList;
        logger.info("instantiating processor...");
    }

    public void printDataToLog() {
        for (OppPost post: this.postList) {
            logger.info(post.printRecord());
        }
    }
}
