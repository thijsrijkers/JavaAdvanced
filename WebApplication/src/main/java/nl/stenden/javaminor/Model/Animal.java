package nl.stenden.javaminor.Model;

import javax.validation.constraints.NotBlank;

public class Animal {
    private int id;

    @NotBlank
    private String name;

    public Animal() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
