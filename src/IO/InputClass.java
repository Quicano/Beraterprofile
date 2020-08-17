package IO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import DBMS.SetupBeraterprofile;

public class InputClass {

    public static List<String> analyseInput(String input){
        List<String> expertise = SetupBeraterprofile.expertise;
        List<String> matches = new ArrayList<String>();
        for(int i = 0; i < input.length() ; i++){
            Boolean found = Arrays.asList(input.split(" ")).contains(expertise.get(i));
            if(found){
                matches.add(expertise.get(i));
            }
        }
        return matches;
    }
}
