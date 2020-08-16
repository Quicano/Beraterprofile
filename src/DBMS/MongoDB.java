package DBMS;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDB {
    public static String uri = "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false";

    public static MongoDatabase connectDB(String database){                        //Creates the Connection to the Database and returns the connection
        MongoClientURI clientURI = new MongoClientURI(uri);
        MongoClient mongoClient = new MongoClient(clientURI);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(database);
        return mongoDatabase;
    }
    public static void createCollection(String database, String collection){
        MongoDatabase mongoDb = connectDB(database);
        mongoDb.createCollection(collection);
    }
    public static MongoCollection connectCollection(String database, String collection){
        MongoCollection mongoCollection = connectDB(database).getCollection(collection);
        return mongoCollection;
    }

}
