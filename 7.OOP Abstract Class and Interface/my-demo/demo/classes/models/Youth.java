package demo.classes.models;

import demo.classes.contracts.Person;

public class Youth extends Person {

    protected Youth(String name) {
        super(name);
    }

    @Override
    public void canSpeak() {
        System.out.println("I can speak freely");
    }
}
