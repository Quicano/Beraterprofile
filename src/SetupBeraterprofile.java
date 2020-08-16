import DBMS.MongoDB;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class SetupBeraterprofile {

    public static void setupProfile(){

        createProfile();
    }

    private static void createProfile(){
        MongoCollection<Document> beraterCollection = MongoDB.connectCollection("Profile", "Collection");

        List<Document> beraterListe = new ArrayList<>();
        List<String> list = List.of("Java", "Javascript", "SQL", "Human Resourcing", "Distribution", "Project Managment", "Project Architecture", "Python", "Haskell", "C#");
        List<String> firstNames = List.of("Hans", "Penelope", "Reiner", "Thorsten", "Marie", "Max", "Martin", "Kevin", "Jenny", "Peter");
        List<String> lastName = List.of("Zimmer", "Cruz", "Calmund", "Legat", "Antoinette", "Kleber", "Luther", "Costner", "From the Block", "Lustig");

        for(int i = 0; i < 10; i++){
            List<String> userAreas = List.of(list.get(i), list.get(9-i), list.get((i+4)%10));
            Document doc = new Document("firstName", firstNames.get(i));
            doc.append("lastName", lastName.get(i));
            doc.append("email", firstNames.get(i) + "." + lastName.get(i) + "@Beraterfirma.com");
            doc.append("focusArea", userAreas);
            beraterListe.add(doc);
        }

        beraterCollection.insertMany(beraterListe);
    }
}
