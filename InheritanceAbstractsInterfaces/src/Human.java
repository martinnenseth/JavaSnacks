import javax.swing.*;

/**
 * Created by Refi on 20.02.2017.
 */
public abstract class Human implements Animal{
    protected String name;
    private String email;
    private int age;
    private String color;

    public Human(String name, String email, int age, String color) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.color = color;
    }

    // Will be implemented by children
    protected abstract void someMethod(String name);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getColor() {
        return color;
    }
}
