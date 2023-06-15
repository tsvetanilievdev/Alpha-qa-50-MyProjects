package demo.classes.intro;

public class Main {
    public static void main(String[] args) {
        Some some = new Some("Cesc");

        some.sayMyName();

        Other other = new Other("Iliev");
        other.sayMyName();
        other.SaySomething();
        some.SaySomething();
    }
}
