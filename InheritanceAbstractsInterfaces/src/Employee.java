/**
 * Created by Refi on 24.02.2017.
 */
public class Employee extends Human {


    public Employee(String name, String email, int age, String color) {
        super(name, email, age, color);
    }

    @Override
    protected void someMethod(String name) {
        System.out.println(this.name);
        this.name = name;
        System.out.println(name + " " + getAge());
    }
}
