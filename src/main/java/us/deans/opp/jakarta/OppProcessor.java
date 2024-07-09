package us.deans.opp.jakarta;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class OppProcessor {

    private final List<OppPost> postList;
    Logger logger = LoggerFactory.getLogger(OppUpload.class);
    private final String uri = "mongodb+srv://ncdeans:Qelar9E8DfXgZrrs@cluster0.ueelqzu.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

    public OppProcessor(List<OppPost> postList) {
        this.postList = postList;
        logger.info("instantiating processor...");
    }

    public void printDataToLog() {
        for (OppPost post: this.postList) {
            logger.info("record: " + post.printRecord() + "\n");
        }
    }

    public void uploadToDB() {

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Opp-1");
            MongoCollection<Document> collection = database.getCollection("post-text");

            List<Document> postData = new ArrayList<>();

            for (OppPost post : this.postList) {
                int idx = post.getLink().lastIndexOf("=");
                String topic_id = post.getLink().substring(idx + 1);
                Document record = new Document()
                        .append("post_id", post.getId())
                        .append("author", post.getAuthor())
                        .append("head", post.getHead())
                        .append("link", post.getLink())
                        .append("text", post.getText())
                        .append("topic_id", topic_id);
                postData.add(record);
            }
            collection.insertMany(postData);
            logger.info(">>> " + postData.size() + "post records inserted...");
        }

    }
}
