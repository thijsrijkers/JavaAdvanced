package nl.stenden.javaminor.Service;

import nl.stenden.javaminor.Model.Animal;
import nl.stenden.javaminor.Repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository){
        this.animalRepository = animalRepository;
    }

    public List getAnimals() {
        return animalRepository.getAnimals();
    }

    public List getAnimal(Integer id){
        return animalRepository.getAnimal(id);
    }

    public void create(Animal animal){
        animalRepository.postAnimal(animal);
    }

    public void update(Animal animalBody, Integer id){
        animalRepository.putAnimal(animalBody, id);
    }

    public void delete(Integer id){
        animalRepository.deleteAnimal(id);
    }
}
