package data;

public class Parent {

    String name;

    /**
     * Constructor del pariente
     *
     * @param name Nombre del pariente
     */
    public Parent(String name) {
        this.name = name;
    }

    /**
     * @return Nombre del pariente
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return Primer nombre del pariente
     */
    public String getShortName() {
        return this.name.split(" ")[0].trim();
    }
}
