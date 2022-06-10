import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws IOException {
        PeopleReader reader = new PeopleReader("people.txt");
       //GET ALL PEOPLE
        List<Person> people = reader.getAllPeople();
       
        //GET MAP AND GROUP THEM BY FEAR METHOD
        Map<String, List<Person>> groups = groupByFear(people);

        //ENTRY HAS KEY AND VALUE
        for (Map.Entry<String, List<Person>> entry : groups.entrySet()) {
            
            System.out.println("---------------------------");
            
            //KEY IS FEAR
            System.out.println(entry.getKey());

            // List<Person> peopleInGroup = entry.getValue();
            //for (Person p : peopleInGroup) {

            //LOOP OVER LIST THAT IS CONTAINED IN THE ENTRY VALUE
            for (Person p : entry.getValue()) {
                System.out.println(
                        String.format(
                                "    %s %s (%d)",
                                p.getFirstName(), p.getLastName(), p.getAge()));
            }
            System.out.println("---------------------------");
        }
    }
     
    //CREATE NEW HASHMAP IS TWO VALUES, KEY AND VALUE 
    // (THINK LOOKING UP WORD IN DICTIONARY --- Look for word (key), read definition (value)) 
    private static Map<String, List<Person>> groupByFear(List<Person> people) {
        
        //CREATE NEW GROUPS HASHMAP 
        Map<String, List<Person>> groups = new HashMap<>();
        
        //LOOP THROUGH EVERY PERSON IN GIVEN PEOPLE LIST
        for (Person p : people) {
            //IS IT ALREADAY IN MY HASHMAP AND IF ITS NOT ADD NEW ENTRY INTO HASHMAP 
             //WHERE KEY IS FEAR AND THE VALUE IS A NEW LIST
            
            //IF NO PERSON CONTAINS THAT FEAR CREATE NEW LIST AND PUT THAT PERSON IN IT
            if (!groups.containsKey(p.getFear())) {
                
                //only the first time do I need to create a new list
                groups.put(p.getFear(), new ArrayList<>());
            }
            //OTHERWISE GET THE PERSONS FEAR AND ADD IT TO 
            groups.get(p.getFear()).add(p);

            //COULD ALSO WRITE
            //GO FIND LIST I JUST PUT INTO THE MAP AND CALL THE ADD METHOD TO IT
            // List<Person> peopleInGroup = groups.get(p.getFear());
            // if (!groups.containsKey(p.getFear())) {
            //     List<Person> newList = new ArrayList<>();
            //     groups.put(p.getFear(), newList);
            // }
            // peopleInGroup.add(p);
        }
        return groups;
    }
}
