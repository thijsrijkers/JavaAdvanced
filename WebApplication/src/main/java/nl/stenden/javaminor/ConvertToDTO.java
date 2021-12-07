package nl.stenden.javaminor;

import nl.stenden.javaminor.Model.Animal;
import nl.stenden.javaminor.Model.Owner;
import nl.stenden.javaminor.dto.AnimalDTO;
import nl.stenden.javaminor.dto.OwnerDTO;

public class ConvertToDTO {

    public AnimalDTO toAnimalDto(Animal animal) {
        AnimalDTO animalToReturn = new AnimalDTO();
        animalToReturn.setId(animal.getId());
        animalToReturn.setName(animal.getName());
        animalToReturn.setOwner(animal.getOwner());
        return animalToReturn;
    }

    public OwnerDTO toOwnerDto(Owner owner) {
        OwnerDTO ownerToReturn = new OwnerDTO();
        ownerToReturn.setId(owner.getId());
        ownerToReturn.setName(owner.getName());
        return ownerToReturn;
    }
}
