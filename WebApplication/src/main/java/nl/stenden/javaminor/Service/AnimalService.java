package nl.stenden.javaminor.Service;

import nl.stenden.javaminor.Model.Animal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AnimalService {

    private ArrayList<Animal> animals = new ArrayList<Animal>();

    public AnimalService(){
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
    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public ResponseEntity<Animal> getAnimal(Integer id){
        Animal animalFound = null;
        for (Animal animal : getAnimals()) {
            if (animal.getId() == id) {
                animalFound = animal;
                return ResponseEntity.ok(animalFound);
            }
        }
        return (ResponseEntity<Animal>) ResponseEntity.status(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity.BodyBuilder create(Animal animal){
        try {
            Animal newAnimal = new Animal();
            newAnimal.setId(animals.get(animals.size() - 1).getId() + 1);
            newAnimal.setName(animal.getName());
            animals.add(newAnimal);
            return ResponseEntity.ok();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity.BodyBuilder update(Animal animalBody, Integer id){
        for (Animal animal : animals) {
            if (animal.getId() == id) {
                animal.setName(animalBody.getName());
                return ResponseEntity.ok();
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity.BodyBuilder delete(Integer id){
        for (Animal animal : animals) {
            if (animal.getId() == id){
                animals.remove(animal);
                return ResponseEntity.ok();
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND);
    }
}
