package nl.stenden.javaminor.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class AnimalDTO {

    @Getter
    @Setter
    private int id;

    @NotBlank
    @Getter @Setter private String name;


    public AnimalDTO() {

    }
}
