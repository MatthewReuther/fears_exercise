import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws IOException {
        PeopleReader reader = new PeopleReader("people.txt");
        List<Person> people = reader.getAllPeople();
        Map<String, List<Person>> groups = groupByFear(people);

        for (Map.Entry<String, List<Person>> entry : groups.entrySet()) {
            System.out.println("---------------------------");
            System.out.println(entry.getKey());
            for (Person p : entry.getValue()) {
                System.out.println(
                        String.format(
                                "    %s %s (%d)",
                                p.getFirstName(), p.getLastName(), p.getAge()));
            }
            System.out.println("---------------------------");
        }
    }

    private static Map<String, List<Person>> groupByFear(List<Person> people) {
        Map<String, List<Person>> groups = new HashMap<>();
        for (Person p : people) {
            if (!groups.containsKey(p.getFear())) {
                groups.put(p.getFear(), new ArrayList<>());
            }
            groups.get(p.getFear()).add(p);
        }
        return groups;
    }
}