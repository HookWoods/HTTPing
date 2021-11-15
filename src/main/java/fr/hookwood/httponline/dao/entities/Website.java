package fr.hookwood.httponline.dao.entities;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public class Website {

    @MongoId
    private ObjectId _id;

    @Indexed
    private String url;
    @Indexed
    private String name;

    public String getUrl() {
        return url;
    }

    public Website setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public Website setName(String name) {
        this.name = name;
        return this;
    }

}
