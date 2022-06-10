import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PeopleReader {
    private String filename;

    public PeopleReader(String filename) {
        this.filename = filename;
    }

    public List<Person> getAllPeople() throws IOException {
        List<Person> people = new ArrayList<>();

        List<String> lines = Files.readAllLines(Path.of(filename));
        for (String line : lines) {
            String[] parts = line.split(" ");

            //WE ALWAYS KNOW FIRST AND LAST NAMES ARE 0 AND 1
            String firstName = parts[0];
            String lastName = parts[1];

            //YOU KNOW YOU WANT A MIDDLE NAME, EMPTY STRING OR A NAME
            String middleName = "";

            //YOU KNOW YOUR ALWAYS GOING TO HAVE AN AGE
            int ageIndex;

            //IS INDEX 2 A NUMBER OR NOT
            if (isNumeric(parts[2])) {
                //IF IT IS AGE INDEX IS 2
                ageIndex = 2;
            } else {
                //IF IT IS NOT AGE INDEX IS 3
                ageIndex = 3;
                //AND MIDDLE NAME IS IN INDEX 2
                middleName = parts[2];
            }

            //SET THE AGE VALUE = TO THE AGEINDEX 
            int age = Integer.parseInt(parts[ageIndex]);

            //FEAR WILL ALWAYS BE THE INDEX OF AGE + 1 (AFTER ) 
            int fearIndex = ageIndex + 1;
            //IF THE LENGTH OF THE ENTIRE ARRAY IS = TO THE LENGTH OF THE FEAR INDEX + 1
            String fear = (parts.length == fearIndex + 1)
                
                //FEAR INDEX IS ONLY 1 WORD
                ? parts[fearIndex]

                //GIVE ME FIRST LINE AND GIVE ME THE WORD AFTER THAT
                : parts[fearIndex] + " " + parts[fearIndex + 1];


                // String fear2 = parts[fearIndex];
                // if(parts.length > fearIndex + 1) {
                //     fear2 = fear2 + " " + parts[fearIndex + 1];
                // }

            //PERSON OBJECT IS IMMUTABLE IT CANNOT BE CHANGED
            people.add(new Person(firstName, lastName, middleName, age, fear));
        }

        return people;
    }

    
    
    private boolean isNumeric(String s) {
        //IF YOU CAN CONVERT THIS STRING INTO INTEGER THEN RETURN TRUE
        try {
            Integer.parseInt(s);
            return true;
        } 
        //IF NOT RETURN AN NUMBER FORMAT EXCEPTION AND RETURN FALSE
        catch (NumberFormatException _nfe) {
            return false;
        }
    }
}