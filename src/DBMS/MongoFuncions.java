package DBMS;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;

public class MongoFuncions {
    private static MongoCollection collection = MongoDB.collection;         //Better way possible?

    public static Document findByValue(String identifier, String value){
        return (Document) collection.find(new Document(identifier,value)).first();
    }

    public static boolean updateValue(String identifier, String oldValue, String newValue){
        Document found = MongoFuncions.findByValue(identifier, oldValue);
        if (found != null){
            Bson updatedvalue = new Document(identifier, newValue);
            Bson updateoperation = new Document("$set", updatedvalue);
            collection.updateOne(found,updateoperation);
            return true;
        }
        else return false;
    }

    public static void searchForKeyword(String keyword){
        ArrayList<Document> docs = new ArrayList<Document>();
        MongoIterable found = collection.find();
            MongoCursor<Document> cursor = found.iterator();
            while(cursor.hasNext()){
                Document doc = cursor.next();
                docs.add(doc);
                System.out.println(doc.toString());
            }


    }

    private static void createDocuments(){

    }
}
