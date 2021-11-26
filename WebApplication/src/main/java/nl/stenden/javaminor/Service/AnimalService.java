package nl.stenden.javaminor.Service;

import nl.stenden.javaminor.Model.Animal;
import nl.stenden.javaminor.Repository.AnimalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository){
        this.animalRepository = animalRepository;
        init();
    }

    private void init(){
        Animal dog = new Animal();
        dog.setId(0);
        dog.setName("dog");
        animals.add(dog);

        Animal cat = new Animal();
        cat.setId(1);
        cat.setName("cat");
        animals.add(cat);
    }

    public List getAnimals() {
        return animalRepository.getAnimals();
    }

    public List getAnimal(Integer id){
        return animalRepository.getAnimal(id);
    }

    public void create(Animal animal){
        animalRepository.postAnimals(animal);
    }

    public void update(Animal animalBody, Integer id){
        animalRepository.putAnimals(animalBody, id);
    }

    public void delete(Integer id){
        animalRepository.deleteAnimals(id);
    }
}
