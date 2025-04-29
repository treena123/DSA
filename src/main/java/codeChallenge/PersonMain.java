package codeChallenge;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author trinapal
 */
final class Person {
    /*encapsulation*/
    private final String name;
    private final int age;
    private final List<String> hobbies;
    static Person person = null;

    public Person(String name, int age, List<String> hobbies){
        this.name = name;
        this.age = age;
        //this.hobbies = Collections.unmodifiableList(new ArrayList<>(hobbies));
        this.hobbies = hobbies.stream().map(String::new).collect(Collectors.toUnmodifiableList()); //// deep copy each Project
    }


    //AtomicInteger age = new AtomicInteger(1);
    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    public List<String> getHobbies() {
        return hobbies;
    }

    @Override
    public String toString() {
        return "Person{name='%s', age=%d, hobbies=%s}".formatted(name, age, hobbies);
    }
}

public class PersonMain {
    public static void main(String[] args) {
        //Person person = new Person();
        List<String> hobbyList = List.of("playing games", "study");
        Person person = new Person("Aishi", 22, hobbyList);
        Logger logger = Logger.getLogger("Info");
        logger.info(person.toString());
        /*
        This will throw unsupportedOperationException
         */
        /*hobbyList.set(0, "Singing");
        hobbyList.add("drawing"); */

        ImmutablePerson immutablePerson =   new ImmutablePerson.Builder()
                .name("Sresa").
                age(24).
                hobbies(List.of("Drawing", "Singing")).build();

        logger.info(immutablePerson.toString());
        /*
        This will throw unsupportedOperationException
         */
        immutablePerson.getHobbies().add("cooking");

    }
}
