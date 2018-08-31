package data;

public class Parent {

    String name;

    public Parent(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getShortName() {
        return this.name.split(" ")[0].trim();
    }
}
