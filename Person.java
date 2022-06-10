public class Person {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final int age;
    private final String fear;

    public Person(String firstName, String lastName, String middleName, int age, String fear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.age = age;
        this.fear = fear;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFear() {
        return fear;
    }

    public int getAge() {
        return age;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", fear=" + fear + ", firstName=" + firstName + ", lastName=" + lastName
                + ", middleName=" + middleName + "]";
    }
}