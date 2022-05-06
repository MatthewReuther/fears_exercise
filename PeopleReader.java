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

            String firstName = parts[0];
            String lastName = parts[1];

            String middleName = "";

            int ageIndex;

            if (isNumeric(parts[2])) {
                ageIndex = 2;
            } else {
                ageIndex = 3;
                middleName = parts[2];
            }

            int age = Integer.parseInt(parts[ageIndex]);

            int fearIndex = ageIndex + 1;
            String fear = (parts.length == fearIndex + 1)
                    ? parts[fearIndex]
                    : parts[fearIndex] + " " + parts[fearIndex + 1];

            people.add(new Person(firstName, lastName, middleName, age, fear));
        }

        return people;
    }

    private boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException _nfe) {
            return false;
        }
    }
}