# Exercise: Fears

In this exercise you'll read in a text file that contains people's names, ages and fears. Then you'll display each person grouped by their fear.

## The Data

Here's the first few lines of the `people.txt` file.

> **NOTE**: The complete file will be provided to you.

```text
Rosella Burks 31 spiders
Damien Avila 32 spiders
Robin Olsen 35 public speaking
Edgar Moises Estes 5 spiders
Heath Brian Pruitt 29 ghosts
```

Each line contains the following fields separated by a single space:

1. First Name
1. Last Name
1. Middle Name _(This field is **optional**. It may or may not be there)_
1. Age
1. Fear _(Some fears are a single word and some are two words)_

## The Output

Your goal is to write a program that reads in the data from `people.txt` and prints each unique fear followed by the people who have that fear. For example, if the `peeople.txt` file contains only the data shown above, the output would be something like:

```text
---------------------------
ghosts
    Heath Brian (29)
---------------------------
---------------------------
spiders
    Rosella Burks (31)
    Damien Avila (32)
    Edgar Moises (5)
---------------------------
---------------------------
public speaking
    Robin Olsen (35)
---------------------------
```

## The Exercise

### Setup

You instructor will provide a _Github Classroom_ link that will automatically generate a Github repository for you.

1. Click the link to create the Github repository
1. Clone the new repository to your computer
1. Create a new branch to do your work in
1. Open the directory in Visual Studio Code and go through the instructions below. Make sure you commit your code after each phase.

### Phase One

Any time you begin a project with existing code, the first step is to understand the code.

1. Read through the code. Can you make predictions about what it will do?
1. Compile the code with `javac *.java`. Are there errors?
1. If there are no errors, try running the code.  
    Look through the code to find the class that contains the `main()` method, and run that class.  
    To run the "fears" program, use the command `java App`.
1. Where your predictions correct? Where there any surprises?

### Phase Two

1. Take a look at the `Class_Diagram.puml` file. Use the `PlantUML` Visual Studio Code extension to visualize it. This diagram contains the private fields and the _public_ methods that the finished program should have. It does NOT contain any getters or setters your program may need, nor any constructors. It also does NOT contain any private methods you may need.
1. Compare the diagram to the existing code.

### Phase Three

The `Person` class is incomplete. Add the appropriate code to complete it. Don't forget to update the `toString()` method to display any new fields you add.

### Phase Four

The `PeopleReader::getAllPeople()` method does not properly create `Person` objects. It is reading the text file, but it stores each line of the file in the `firstName` field of a `Person` object.

The first word in each line (the text before the first space) is a person's first name. Update the code to store only the person's first name in the `firstName` field. For now store the _rest_ of the link in the `lastName` fields.

### Phase Five

Now that you've got a good start on creating `Person` objects, it's time to finish the job. Write code to correctly parse each line and save the correct information in each `Person` object.

Revisit the file description near the top of this document to understand how the data in the file is structured.

### Phase Six

Now it's time to turn your attention to the `App` class. Right now the `main()` method simply prints each `Person` object. Your task is to change the code so that it prints each fear followed by the people who have that fear.

The class diagram shows a method like this in the `App` class

```java
public static Map<String, List<Person>> groupByFear(List<Person> people) {
    // ...
}
```

Create this method and call it from the `main()` method to generate a `HashMap` that contains the groups. The `HashMap` `key` should be the name of the fear and the `value` should be an `ArrayList<Peerson>` that contains the people who have that fear.

Print the fears and people as described near the top of this document.


