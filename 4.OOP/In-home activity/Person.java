public class Person {
    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public boolean equals(Person p) {
        System.out.println(this);
        System.out.println(p);

        return this.name.equals(p.name);
    }

    public void sayName(){
        System.out.printf("My name is %s%n", this.name);
    }

    void sayMyType(){
        System.out.println("I am human");
    }
}
