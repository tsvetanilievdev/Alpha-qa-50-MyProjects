package demo.classes.intro;


public class Some extends Test{
    private String name;
    public Some(String name){
        this.name = name;
    }
    protected void sayMyName() {
        super.SaySomething();
        System.out.println("After SaySomething from abstarcted class INSIDE sayMyName Some");
        System.out.println("I am " + this.name);
    }
}
