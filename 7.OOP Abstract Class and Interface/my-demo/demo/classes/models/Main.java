package demo.classes.models;

import demo.classes.contracts.Person;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person ivancho = new Child("Ivancho", 5);
        ivancho.canSpeak();
        Person petkancho = new Youth("Petkancho");
        petkancho.canSpeak();

        List<Person> listing = new ArrayList<>();
        listing.add(ivancho);
        listing.add(petkancho);

        for (Person person: listing) {
            System.out.println(person.getName());
        }
    }
}
