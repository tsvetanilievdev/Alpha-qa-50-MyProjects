package demo.classes.models;

import demo.classes.contracts.Person;

class Child extends Person {
    private int age;
     public Child(String name, int age) {
        super(name);
        setAge(age);
    }

    @Override
    public void canSpeak() {
        System.out.println("a,b,c,d,e,f,g,h.....");
    }
    protected void setAge(int age){
        if(age < 0 || age > 9) {
            throw new IllegalArgumentException("In child class age must be between 0 and 9");
        }
    }
}
