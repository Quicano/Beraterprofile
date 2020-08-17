package DBMS;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;

public class MongoHelper {
    private MongoCollection collection;         //Better way possible?

    public MongoHelper(MongoCollection collection){
        this.collection = collection;
    }
    public Document findByValue(String identifier, String value){
        return (Document) collection.find(new Document(identifier,value)).first();
    }

    public boolean updateValue(String identifier, String oldValue, String newValue){
        Document found = this.findByValue(identifier, oldValue);
        if (found != null){
            Bson updatedvalue = new Document(identifier, newValue);
            Bson updateoperation = new Document("$set", updatedvalue);
            collection.updateOne(found,updateoperation);
            return true;
        }
        else return false;
    }

    public void searchForKeyword(String keyword){
        ArrayList<Document> docs = new ArrayList<Document>();
        MongoIterable found = collection.find();
            MongoCursor<Document> cursor = found.iterator();
            while(cursor.hasNext()){
                Document doc = cursor.next();
                docs.add(doc);
                System.out.println(doc.toString());
            }
    }

    public void searchInFocusAreas(){

    }

    private void createDocuments(){

    }
}
