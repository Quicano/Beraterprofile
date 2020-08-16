package DBMS;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDB {
    public static final String uri = "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false";
    public static MongoDatabase database = MongoDB.connectDB();
    public static MongoCollection collection = MongoDB.connectCollection();

    public static MongoDatabase connectDB(){                        //Creates the Connection to the Database and returns the connection
        MongoClientURI clientURI = new MongoClientURI(uri);
        MongoClient mongoClient = new MongoClient(clientURI);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("LolProfile");
        return mongoDatabase;
    }
    public static MongoCollection connectCollection(){
        MongoCollection collection = database.getCollection("User");
        return collection;
    }

}
