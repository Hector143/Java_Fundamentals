package Constructors;

public class Dog {
    private String name;
    private String color;
    
    public Dog(String name, String color) {
        this.name = name;
        this.color = color;
    }
    
    
    public static void main(String[] args) {
        Dog d = new Dog("Doggy", "Pinkish-Black");
        System.out.println("Dog's Name: " + d.name);
        System.out.println("Dog's Color: " + d.color);
    }
}
