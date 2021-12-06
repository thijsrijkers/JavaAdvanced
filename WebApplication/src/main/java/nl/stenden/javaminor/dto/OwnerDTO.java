package nl.stenden.javaminor.dto;

import lombok.Getter;
import lombok.Setter;
import nl.stenden.javaminor.Model.Owner;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OwnerDTO {
    @Getter @Setter
    private int id;

    @NotBlank
    @Getter @Setter private String name;

    @NotNull
    @Getter @Setter private Owner owner;


    public OwnerDTO() {

    }

}
