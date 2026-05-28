package learning_oop;

public class Animal {
    String name;

    public void eat() {
        System.out.println(name + " is eating ");
    }

    public void sleep() {
        System.out.println(name + " is sleeping ");
    }

}

class Cat extends Animal {
    public void meow() {
        System.out.println(name + " is meowing ");
    }

    public static void main(String[] args) {
        Cat c = new Cat();
        c.name = "Luna";
        c.eat();
        c.sleep();
        c.meow();

    }
}
